/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.backend.jvm.ir

import org.jetbrains.kotlin.backend.jvm.unboxInlineClass
import org.jetbrains.kotlin.ir.builders.*
import org.jetbrains.kotlin.ir.expressions.*
import org.jetbrains.kotlin.ir.types.*
import org.jetbrains.kotlin.ir.util.constructors
import org.jetbrains.kotlin.ir.util.functions
import org.jetbrains.kotlin.ir.util.getPropertyGetter

inline fun JvmIrBuilder.irVararg(arrayType: IrType, block: IrVarargBuilder.() -> Unit): IrExpression =
    IrVarargBuilder(this, arrayType).apply { block() }.build()

fun JvmIrBuilder.irVarargOf(arrayType: IrType, elements: List<IrExpression> = listOf()): IrExpression =
    irVararg(arrayType) { elements.forEach { +it } }

private class IrVarargElement(val expression: IrExpression, val isSpread: Boolean)

class IrVarargBuilder(val builder: JvmIrBuilder, val arrayType: IrType) {
    val elementType = arrayType.getArrayElementType(builder.context.irBuiltIns)

    private val elements: MutableList<IrVarargElement> = mutableListOf()
    private val spreadBuilder = builder.irSymbols.alternativeSpreadBuilder

    private val hasSpread
        get() = elements.any { it.isSpread }

    operator fun IrExpression.unaryPlus() = add(this)
    fun add(expression: IrExpression) = elements.add(IrVarargElement(expression, false))

    fun addSpread(expression: IrExpression) = elements.add(IrVarargElement(expression, true))

    fun build(): IrExpression {
        val array = when {
            elements.isEmpty() -> newCollection(0)
            !hasSpread -> buildSimpleArray()
            elements.size == 1 -> copyArray(elements.single().expression)
            else -> buildComplexArray()
        }
        return array
    }

    // Construct a new array of the specified size
    private fun newCollection(size: Int) = newCollection(builder.irInt(size))

    private fun newCollection(size: IrExpression): IrExpression {
        val arrayConstructor = builder.irSymbols.arrayList.constructors.single { it.owner.valueParameters.size == 1 }

        return builder.irCall(arrayConstructor, arrayType).apply {
            if (typeArgumentsCount != 0)
                putTypeArgument(0, elementType)
            putValueArgument(0, size)
        }
    }

    // Build an array without spreads
    private fun buildSimpleArray(): IrExpression =
        builder.irBlock {
            val result = irTemporary(newCollection(elements.size))

            val set = builder.irSymbols.arrayList.functions.single {
                it.owner.name.asString() == "set"
            }

            for ((index, element) in elements.withIndex()) {
                +irCall(set).apply {
                    dispatchReceiver = irGet(result)
                    putValueArgument(0, irInt(index))
                    putValueArgument(1, element.expression)
                }
            }

            +irGet(result)
        }

    // Copy a single spread expression, unless it refers to a newly constructed array.
    private fun copyArray(spread: IrExpression): IrExpression {
//        if (spread is IrConstructorCall ||
//            (spread is IrFunctionAccessExpression && spread.symbol == builder.irSymbols.arrayOfNulls)
//        )
//            return spread

//        return builder.irBlock {
//            val spreadVar = if (spread is IrGetValue) spread.symbol.owner else irTemporary(spread)
//            val size = builder.irSymbols.arrayList.getPropertyGetter("size")!!
//            val arrayCopyOf = builder.irSymbols.getArraysCopyOfFunction(unwrappedArrayType as IrSimpleType)
//            // TODO consider using System.arraycopy if the requested array type is non-generic.
//            +irCall(arrayCopyOf).apply {
//                putValueArgument(0, coerce(irGet(spreadVar), unwrappedArrayType))
//                putValueArgument(1, irCall(size).apply { dispatchReceiver = irGet(spreadVar) })
//            }
//        }

//        builder.irBlock {
//            val result = irTemporary(newCollection(elements.size))
//
//            val set = builder.irSymbols.arrayList.functions.single {
//                it.owner.name.asString() == "set"
//            }
//
//            for ((index, element) in spread.()) {
//                +irCall(set).apply {
//                    dispatchReceiver = irGet(result)
//                    putValueArgument(0, irInt(index))
//                    putValueArgument(1, coerce(element.expression, elementType))
//                }
//            }
//
//            +irGet(result)
//        }

        return newCollection(builder.irInt(0))
    }

    // Build an array containing spread expressions.
    private fun buildComplexArray(): IrExpression {
        return newCollection(builder.irInt(0))
//        val spreadBuilder = if (unwrappedArrayType.isBoxedArray)
//            builder.irSymbols.spreadBuilder
//        else
//            builder.irSymbols.primitiveSpreadBuilders.getValue(elementType)
//
//        val addElement = spreadBuilder.functions.single { it.owner.name.asString() == "add" }
//        val addSpread = spreadBuilder.functions.single { it.owner.name.asString() == "addSpread" }
//        val toArray = spreadBuilder.functions.single { it.owner.name.asString() == "toArray" }
//
//        return builder.irBlock {
//            val spreadBuilderVar = irTemporary(irCallConstructor(spreadBuilder.constructors.single(), listOf()).apply {
//                putValueArgument(0, irInt(elements.size))
//            })
//
//            for (element in elements) {
//                +irCall(if (element.isSpread) addSpread else addElement).apply {
//                    dispatchReceiver = irGet(spreadBuilderVar)
//                    putValueArgument(0, coerce(element.expression, if (element.isSpread) unwrappedArrayType else elementType))
//                }
//            }
//
//            val toArrayCall = irCall(toArray).apply {
//                dispatchReceiver = irGet(spreadBuilderVar)
//                if (unwrappedArrayType.isBoxedArray) {
//                    val size = spreadBuilder.functions.single { it.owner.name.asString() == "size" }
//                    putValueArgument(0, irCall(builder.irSymbols.arrayOfNulls, arrayType).apply {
//                        putTypeArgument(0, elementType)
//                        putValueArgument(0, irCall(size).apply {
//                            dispatchReceiver = irGet(spreadBuilderVar)
//                        })
//                    })
//                }
//            }
//
//            if (unwrappedArrayType.isBoxedArray)
//                +builder.irImplicitCast(toArrayCall, unwrappedArrayType)
//            else
//                +toArrayCall
//        }
    }

}
