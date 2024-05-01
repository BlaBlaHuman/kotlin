/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package kotlin.jvm.internal


public abstract class AlternativeSpreadBuilder<T : Any>() {

    private val values: MutableList<T> = mutableListOf()


    public fun addSpread(spreadArgument: Array<T>) {
        values.addAll(spreadArgument)
    }

    public fun addSpread(spreadArgument: List<T>) {
        values.addAll(spreadArgument)
    }

    public fun addSpread(spreadArgument: Set<T>) {
        values.addAll(spreadArgument)
    }

    public fun add(value: T) {
        values.add(value)
    }

    protected fun size(): Int {
        return values.size
    }

    protected fun toArrayList(): ArrayList<T> {
        return ArrayList(values)
    }

    protected fun empty(): ArrayList<T> {
        return ArrayList()
    }
}
