/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.backend.jvm.ir

/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

import org.jetbrains.kotlin.backend.jvm.unboxInlineClass
import org.jetbrains.kotlin.builtins.PrimitiveType
import org.jetbrains.kotlin.ir.builders.*
import org.jetbrains.kotlin.ir.expressions.IrConstructorCall
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.expressions.IrFunctionAccessExpression
import org.jetbrains.kotlin.ir.expressions.IrGetValue
import org.jetbrains.kotlin.ir.expressions.impl.IrVarargImpl
import org.jetbrains.kotlin.ir.types.*
import org.jetbrains.kotlin.ir.util.*

inline fun JvmIrBuilder.irSpreadArray(arrayType: IrType, block: IrSpreadBuilder.() -> Unit): IrExpression =
    IrSpreadBuilder(this, arrayType).apply { block() }.build()

fun JvmIrBuilder.irSpreadArrayOf(arrayType: IrType, elements: List<IrExpression> = listOf()): IrExpression =
    irSpreadArray(arrayType) { elements.forEach { +it } }

private class IrSpreadElement(val expression: IrExpression, val isSpread: Boolean)

class IrSpreadBuilder(val builder: JvmIrBuilder, val collectionType: IrType) {
    // The unwrapped element type
    val elementType = collectionType.getArrayElementType(builder.context.irBuiltIns)

//
//    val isPrimitive = elementType.isPrimitiveType() || elementType.isNullablePrimitiveType()
//
//    val arrayType = if (collectionType.isBoxedArray || collectionType.isPrimitiveArray()) collectionType else elementType.toArrayOrPrimitiveArrayType(builder.irSymbols.irBuiltIns)
//
//    // We build unboxed arrays for inline classes (UIntArray, etc) by first building
//    // an unboxed array of the underlying primitive type, then coercing the result
//    // to the correct type.
//    val unwrappedArrayType = arrayType.unboxInlineClass()
//
//    // Check if the array type is an inline class wrapper (UIntArray, etc.)
//    val isUnboxedInlineClassArray
//        get() = collectionType !== unwrappedArrayType

    private val elements: MutableList<IrSpreadElement> = mutableListOf()

    private val hasSpread
        get() = elements.any { it.isSpread }

    operator fun IrExpression.unaryPlus() = add(this)
    fun add(expression: IrExpression) = elements.add(IrSpreadElement(expression, false))

    fun addSpread(expression: IrExpression) = elements.add(IrSpreadElement(expression, true))

    fun build(): IrExpression {
        println("irSpreadArrayBuilder build")
//        println(unwrappedArrayType.render())
        println(collectionType.render())
        println(elementType.render())
        println(elementType.classOrNull)
        println(elementType.classOrNull?.defaultType)
//        println(isPrimitive)
//        println(isUnboxedInlineClassArray)
//        println(unwrappedArrayType.render())
//        println(arrayType.render())
        val array = when {
            elements.isEmpty() -> newArray(0)
            !hasSpread -> buildSimpleArray()
            elements.size == 1 -> copyArray(elements.single().expression)
            else -> buildComplexArray()
        }
        return coerce(array, collectionType)
    }

    // Construct a new array of the specified size
    private fun newArray(size: Int) = newArray(builder.irInt(size))

    private fun newArray(size: IrExpression): IrExpression {
//        val arrayConstructor = if (unwrappedArrayType.isBoxedArray)
//            builder.irSymbols.arrayOfNulls
//        else
//            unwrappedArrayType.classOrNull!!.constructors.single { it.owner.valueParameters.size == 1 }
//
//        println("newArray element type ${elementType.render()}")
//        println("newArray array type ${unwrappedArrayType.render()}")

        val arrayConstructor = builder.irSymbols.mutableListOf
        println("spread newArray element type ${collectionType.render()}")
        return builder.irCall(arrayConstructor, collectionType).apply {
            if (typeArgumentsCount != 0)
                putTypeArgument(0, elementType)
        }
    }

    // Build an array without spreads
    private fun buildSimpleArray(): IrExpression =
        builder.irBlock {
            val result = irTemporary(newArray(elements.size))

            val set = builder.irSymbols.mutableList.functions.single { it.owner.name.asString() == "set" }

            for ((index, element) in elements.withIndex()) {
                +irCall(set).apply {
                    dispatchReceiver = irGet(result)
                    putValueArgument(0, irInt(index))
                    putValueArgument(1, coerce(element.expression, elementType))
                }
            }

            +irGet(result)
        }

    // Copy a single spread expression, unless it refers to a newly constructed array.
    private fun copyArray(spread: IrExpression): IrExpression {
//        if (spread is IrConstructorCall ||
//            (spread is IrFunctionAccessExpression && spread.symbol == builder.irSymbols.arrayOfNulls))
//            return spread

        return builder.irBlock {
            val spreadVar = if (spread is IrGetValue) spread.symbol.owner else irTemporary(spread)
            val size = collectionType.classOrNull!!.getPropertyGetter("size")!!
//            val arrayCopyOf = builder.irSymbols.list.functions.single { it.owner.name.asString() == "toMutableList" }
            // TODO consider using System.arraycopy if the requested array type is non-generic.
            +coerce(irGet(spreadVar), collectionType)
//            +irCall(arrayCopyOf).apply {
//                putValueArgument(0, coerce(irGet(spreadVar), collectionType))
////                putValueArgument(1, irCall(size).apply { dispatchReceiver = irGet(spreadVar) })
//            }
        }
    }

    // Build an array containing spread expressions.
    private fun buildComplexArray(): IrExpression {
        val spreadBuilder = if (unwrappedArrayType.isBoxedArray)
            builder.irSymbols.spreadBuilder
        else
            builder.irSymbols.primitiveSpreadBuilders.getValue(elementType)

        val addElement = spreadBuilder.functions.single { it.owner.name.asString() == "add" }
        val addSpread = spreadBuilder.functions.single { it.owner.name.asString() == "addSpread" }
        val toArray = spreadBuilder.functions.single { it.owner.name.asString() == "toArray" }

        return builder.irBlock {
            val spreadBuilderVar = irTemporary(irCallConstructor(spreadBuilder.constructors.single(), listOf()).apply {
                putValueArgument(0, irInt(elements.size))
            })

            for (element in elements) {
                +irCall(if (element.isSpread) addSpread else addElement).apply {
                    dispatchReceiver = irGet(spreadBuilderVar)
                    putValueArgument(0, coerce(element.expression, if (element.isSpread) unwrappedArrayType else elementType))
                }
            }

            val toArrayCall = irCall(toArray).apply {
                dispatchReceiver = irGet(spreadBuilderVar)
                if (unwrappedArrayType.isBoxedArray) {
                    val size = spreadBuilder.functions.single { it.owner.name.asString() == "size" }
                    putValueArgument(0, irCall(builder.irSymbols.arrayOfNulls, arrayType).apply {
                        putTypeArgument(0, elementType)
                        putValueArgument(0, irCall(size).apply {
                            dispatchReceiver = irGet(spreadBuilderVar)
                        })
                    })
                }
            }

            if (unwrappedArrayType.isBoxedArray)
                +builder.irImplicitCast(toArrayCall, unwrappedArrayType)
            else
                +toArrayCall
        }
    }

    // Coerce expression to irType if we are working with an inline class array type
    private fun coerce(expression: IrExpression, irType: IrType): IrExpression =
        if (true)
            builder.irCall(builder.irSymbols.unsafeCoerceIntrinsic, irType).apply {
                putTypeArgument(0, expression.type)
                putTypeArgument(1, irType)
                putValueArgument(0, expression)
            }
        else expression
}
