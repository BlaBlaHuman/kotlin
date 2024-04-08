/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package kotlin.jvm.internal

import java.util.*
import kotlin.collections.ArrayList

public class IterableSpreadBuilder<T> {
    private var list: MutableList<T> = mutableListOf()

    public fun addSpread(container: Any?) {
        if (container == null) return

        if (container is Array<*> && container.isArrayOf<Any>()) {
            if (container.size > 0) {
                (container as? Array<T>)?.toCollection(list)
            }
        } else if (container is Collection<*>) {
            if (container.size > 0) {
                (container as? Collection<T>)?.toCollection(list)
            }
        } else if (container is Iterable<*>) {
            for (element in container) {
                list.add(element as T)
            }
        } else if (container is Iterator<*>) {
            val iterator = container
            while (iterator.hasNext()) {
                list.add(iterator.next()!! as T)
            }
        } else {
            throw UnsupportedOperationException("Don't know how to spread " + container.javaClass)
        }
    }

    public fun size(): Int {
        return list.size
    }

    public fun add(element: T) {
        list.add(element)
    }

    public fun toArray(): MutableList<T> {
        return list
    }
}