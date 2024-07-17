// FIR_IDENTICAL
// !LANGUAGE: +AssigningArraysToVarargsInNamedFormInAnnotations
// WITH_STDLIB

import kotlin.collections.*

annotation class Ann(vararg val s: String)

@Ann(s = <!ANNOTATION_ARGUMENT_MUST_BE_CONST!>listOf()<!>)
fun test1() {}

@Ann(s = <!ANNOTATION_ARGUMENT_MUST_BE_CONST!>setOf()<!>)
fun test2() {}

@Ann(s = <!ANNOTATION_ARGUMENT_MUST_BE_CONST!>mutableListOf("Hello")<!>)
fun test3() {}

annotation class IntAnn(vararg val i: Int)

@IntAnn(i = arrayOf(1, 2))
fun foo1() {}

@IntAnn(i = <!ANNOTATION_ARGUMENT_MUST_BE_CONST!>listOf(0)<!>)
fun foo2() {}
