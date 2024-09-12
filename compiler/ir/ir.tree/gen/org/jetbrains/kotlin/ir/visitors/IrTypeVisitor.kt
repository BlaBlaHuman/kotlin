/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

// This file was generated automatically. See compiler/ir/ir.tree/tree-generator/ReadMe.md.
// DO NOT MODIFY IT MANUALLY.

package org.jetbrains.kotlin.ir.visitors

import org.jetbrains.kotlin.ir.IrElement
import org.jetbrains.kotlin.ir.declarations.*
import org.jetbrains.kotlin.ir.expressions.*
import org.jetbrains.kotlin.ir.types.IrSimpleType
import org.jetbrains.kotlin.ir.types.IrType
import org.jetbrains.kotlin.ir.types.IrTypeProjection

/**
 * Auto-generated by [org.jetbrains.kotlin.ir.generator.print.TypeVisitorPrinter]
 */
abstract class IrTypeVisitor<out R, in D> : IrElementVisitor<R, D> {
    abstract fun visitType(container: IrElement, type: IrType, data: D)

    open fun visitTypeRecursively(container: IrElement, type: IrType, data: D) {
        visitType(container, type, data)
        if (type is IrSimpleType) {
            type.arguments.forEach {
                if (it is IrTypeProjection) {
                    visitTypeRecursively(container, it.type, data)
                }
            }
        }
    }

    override fun visitValueParameter(declaration: IrValueParameter, data: D): R {
        declaration.varargElementType?.let { visitTypeRecursively(declaration, it, data) }
        visitTypeRecursively(declaration, declaration.type, data)
        return super.visitValueParameter(declaration, data)
    }

    override fun visitClass(declaration: IrClass, data: D): R {
        declaration.valueClassRepresentation?.mapUnderlyingType {
            visitTypeRecursively(declaration, it, data)
            it
        }
        declaration.superTypes.forEach { visitTypeRecursively(declaration, it, data) }
        return super.visitClass(declaration, data)
    }

    override fun visitTypeParameter(declaration: IrTypeParameter, data: D): R {
        declaration.superTypes.forEach { visitTypeRecursively(declaration, it, data) }
        return super.visitTypeParameter(declaration, data)
    }

    override fun visitFunction(declaration: IrFunction, data: D): R {
        visitTypeRecursively(declaration, declaration.returnType, data)
        return super.visitFunction(declaration, data)
    }

    override fun visitField(declaration: IrField, data: D): R {
        visitTypeRecursively(declaration, declaration.type, data)
        return super.visitField(declaration, data)
    }

    override fun visitLocalDelegatedProperty(declaration: IrLocalDelegatedProperty, data: D): R {
        visitTypeRecursively(declaration, declaration.type, data)
        return super.visitLocalDelegatedProperty(declaration, data)
    }

    override fun visitScript(declaration: IrScript, data: D): R {
        declaration.baseClass?.let { visitTypeRecursively(declaration, it, data) }
        return super.visitScript(declaration, data)
    }

    override fun visitTypeAlias(declaration: IrTypeAlias, data: D): R {
        visitTypeRecursively(declaration, declaration.expandedType, data)
        return super.visitTypeAlias(declaration, data)
    }

    override fun visitVariable(declaration: IrVariable, data: D): R {
        visitTypeRecursively(declaration, declaration.type, data)
        return super.visitVariable(declaration, data)
    }

    override fun visitExpression(expression: IrExpression, data: D): R {
        visitTypeRecursively(expression, expression.type, data)
        return super.visitExpression(expression, data)
    }

    override fun visitMemberAccess(expression: IrMemberAccessExpression<*>, data: D): R {
        (0 until expression.typeArgumentsCount).forEach {
            expression.getTypeArgument(it)?.let { type ->
                visitTypeRecursively(expression, type, data)
            }
        }
        return super.visitMemberAccess(expression, data)
    }

    override fun visitClassReference(expression: IrClassReference, data: D): R {
        visitTypeRecursively(expression, expression.classType, data)
        return super.visitClassReference(expression, data)
    }

    override fun visitConstantObject(expression: IrConstantObject, data: D): R {
        expression.typeArguments.forEach { visitTypeRecursively(expression, it, data) }
        return super.visitConstantObject(expression, data)
    }

    override fun visitTypeOperator(expression: IrTypeOperatorCall, data: D): R {
        visitTypeRecursively(expression, expression.typeOperand, data)
        return super.visitTypeOperator(expression, data)
    }

    override fun visitVararg(expression: IrVararg, data: D): R {
        visitTypeRecursively(expression, expression.varargElementType, data)
        return super.visitVararg(expression, data)
    }
}
