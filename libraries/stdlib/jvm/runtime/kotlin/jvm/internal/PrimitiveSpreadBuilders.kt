/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package kotlin.jvm.internal

public abstract class PrimitiveSpreadBuilder<T : Any>(private val size: Int) {
    protected var position: Int = 0

    private val spreads: Array<Any?> = arrayOfNulls(size)

    public fun addSpread(spreadArgument: Any) {
        spreads[position++] = spreadArgument
    }

    private fun isPrimitiveArray(element: Any): Boolean {
        return element is IntArray
                || element is LongArray
                || element is ShortArray
                || element is ByteArray
                || element is CharArray
                || element is FloatArray
                || element is DoubleArray
                || element is BooleanArray
    }

    private fun getCollectionSize(element: Any): Int {
        return when (element) {
            is Collection<*> -> {
                element.size
            }
            is Array<*> -> {
                element.size
            }
            is BooleanArray -> {
                element.size
            }
            is CharArray -> {
                element.size
            }
            is ByteArray -> {
                element.size
            }
            is ShortArray -> {
                element.size
            }
            is IntArray -> {
                element.size
            }
            is LongArray -> {
                element.size
            }
            is FloatArray -> {
                element.size
            }
            is DoubleArray -> {
                element.size
            }
            else -> {
                throw AssertionError()
            }
        }
    }

    protected fun size(): Int {
        var totalLength = 0
        for (i in 0..<size) {
            when (val element = spreads[i]) {
                null -> {
                    totalLength++
                }
                else -> {
                    totalLength += getCollectionSize(element)
                }
            }
        }
        return totalLength
    }

    protected fun toArray(values: T, result: T): T {
        var dstIndex = 0
        var copyValuesFrom = 0
        for (i in 0..<size) {
            val spreadArgument = spreads[i]
            if (spreadArgument != null) {
                if (copyValuesFrom < i) {
                    System.arraycopy(values, copyValuesFrom, result, dstIndex, i - copyValuesFrom)
                    dstIndex += i - copyValuesFrom
                }
                val spreadSize = getCollectionSize(spreadArgument)
                if (isPrimitiveArray(spreadArgument))
                    System.arraycopy(spreadArgument, 0, result, dstIndex, spreadSize)
                else if (spreadArgument is Iterable<*>) {
                    spreadArgument.forEachIndexed { index, element ->
                        when (result) {
                            is IntArray -> result[dstIndex + index] = element as Int
                            is LongArray -> result[dstIndex + index] = element as Long
                            is ShortArray -> result[dstIndex + index] = element as Short
                            is ByteArray -> result[dstIndex + index] = element as Byte
                            is CharArray -> result[dstIndex + index] = element as Char
                            is FloatArray -> result[dstIndex + index] = element as Float
                            is DoubleArray -> result[dstIndex + index] = element as Double
                            is BooleanArray -> result[dstIndex + index] = element as Boolean
                            else -> throw AssertionError()
                        }
                    }
                } else if (spreadArgument is Array<*>) {
                    spreadArgument.forEachIndexed { index, element ->
                        when (result) {
                            is IntArray -> result[dstIndex + index] = element as Int
                            is LongArray -> result[dstIndex + index] = element as Long
                            is ShortArray -> result[dstIndex + index] = element as Short
                            is ByteArray -> result[dstIndex + index] = element as Byte
                            is CharArray -> result[dstIndex + index] = element as Char
                            is FloatArray -> result[dstIndex + index] = element as Float
                            is DoubleArray -> result[dstIndex + index] = element as Double
                            is BooleanArray -> result[dstIndex + index] = element as Boolean
                            else -> throw AssertionError()
                        }
                    }
                }
                dstIndex += spreadSize
                copyValuesFrom = i + 1
            }
        }
        if (copyValuesFrom < size) {
            System.arraycopy(values, copyValuesFrom, result, dstIndex, size - copyValuesFrom)
        }

        return result
    }
}

public class ByteSpreadBuilder(size: Int) : PrimitiveSpreadBuilder<ByteArray>(size) {
    private val values: ByteArray = ByteArray(size)

    public fun add(value: Byte) {
        values[position++] = value
    }

    public fun toArray(): ByteArray = toArray(values, ByteArray(size()))
}

public class CharSpreadBuilder(size: Int) : PrimitiveSpreadBuilder<CharArray>(size) {
    private val values: CharArray = CharArray(size)

    public fun add(value: Char) {
        values[position++] = value
    }

    public fun toArray(): CharArray = toArray(values, CharArray(size()))
}

public class DoubleSpreadBuilder(size: Int) : PrimitiveSpreadBuilder<DoubleArray>(size) {
    private val values: DoubleArray = DoubleArray(size)

    public fun add(value: Double) {
        values[position++] = value
    }

    public fun toArray(): DoubleArray = toArray(values, DoubleArray(size()))
}

public class FloatSpreadBuilder(size: Int) : PrimitiveSpreadBuilder<FloatArray>(size) {
    private val values: FloatArray = FloatArray(size)

    public fun add(value: Float) {
        values[position++] = value
    }

    public fun toArray(): FloatArray = toArray(values, FloatArray(size()))
}

public class IntSpreadBuilder(size: Int) : PrimitiveSpreadBuilder<IntArray>(size) {
    private val values: IntArray = IntArray(size)

    public fun add(value: Int) {
        values[position++] = value
    }

    public fun toArray(): IntArray = toArray(values, IntArray(size()))
}

public class LongSpreadBuilder(size: Int) : PrimitiveSpreadBuilder<LongArray>(size) {
    private val values: LongArray = LongArray(size)

    public fun add(value: Long) {
        values[position++] = value
    }

    public fun toArray(): LongArray = toArray(values, LongArray(size()))
}

public class ShortSpreadBuilder(size: Int) : PrimitiveSpreadBuilder<ShortArray>(size) {
    private val values: ShortArray = ShortArray(size)

    public fun add(value: Short) {
        values[position++] = value
    }

    public fun toArray(): ShortArray = toArray(values, ShortArray(size()))
}

public class BooleanSpreadBuilder(size: Int) : PrimitiveSpreadBuilder<BooleanArray>(size) {
    private val values: BooleanArray = BooleanArray(size)

    public fun add(value: Boolean) {
        values[position++] = value
    }

    public fun toArray(): BooleanArray = toArray(values, BooleanArray(size()))
}
