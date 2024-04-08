/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.resolve.transformers

import org.jetbrains.kotlin.KtFakeSourceElementKind
import org.jetbrains.kotlin.fir.copyWithNewSourceKind
import org.jetbrains.kotlin.fir.declarations.FirCallableDeclaration
import org.jetbrains.kotlin.fir.declarations.FirClass
import org.jetbrains.kotlin.fir.declarations.FirValueParameter
import org.jetbrains.kotlin.fir.types.*
import org.jetbrains.kotlin.fir.types.builder.buildResolvedTypeRef

internal fun FirValueParameter.transformVarargTypeToArrayType() {
    if (isVararg) {
        this.transformTypeToUnderlyingType()
    }
}

internal fun FirCallableDeclaration.transformTypeToUnderlyingType() {
    val returnTypeRef = this.returnTypeRef
    require(returnTypeRef is FirResolvedTypeRef)
    // If the delegated type is already resolved, it means we have already created a resolved array type for this vararg type declaration.
    // This is because in the buildResolvedTypeRef call below, we set the delegated type ref to the previous (non-vararg) resolved type ref.
    if (returnTypeRef.delegatedTypeRef is FirResolvedTypeRef &&
        returnTypeRef.delegatedTypeRef?.source?.kind == KtFakeSourceElementKind.UnderlyingTypeFromVarargParameter
    ) return
    val returnType = returnTypeRef.coneType

    replaceReturnTypeRef(
        buildResolvedTypeRef {
            source = returnTypeRef.source
            type = ConeKotlinTypeProjectionOut(returnType).createIterableType()
            annotations += returnTypeRef.annotations
            // ? do we really need replacing source of nested delegatedTypeRef ?
            delegatedTypeRef = returnTypeRef.copyWithNewSourceKind(KtFakeSourceElementKind.UnderlyingTypeFromVarargParameter)
        }
    )
}

inline fun <T> withScopeCleanup(scopes: MutableList<*>, l: () -> T): T {
    val sizeBefore = scopes.size
    return try {
        l()
    } finally {
        val size = scopes.size
        assert(size >= sizeBefore)
        repeat(size - sizeBefore) {
            scopes.let { it.removeAt(it.size - 1) }
        }
    }
}

inline fun <T> withClassDeclarationCleanup(
    classDeclarations: ArrayDeque<FirClass>,
    topClassDeclaration: FirClass,
    l: () -> T
): T {
    classDeclarations.addLast(topClassDeclaration)
    return try {
        l()
    } finally {
        classDeclarations.removeLast()
    }
}
