// WITH_STDLIB

fun booleanVararg(vararg xs: Boolean) {
    xs.forEach {
        println(it)
    }
}
fun charVararg(vararg xs: Char) {
    xs.forEach {
        println(it)
    }
}
fun byteVararg(vararg xs: Byte) {
    xs.forEach {
        println(it)
    }
}
fun shortVararg(vararg xs: Short) {
    xs.forEach {
        println(it)
    }
}
fun longVararg(vararg xs: Long) {
    xs.forEach {
        println(it)
    }
}
fun floatVararg(vararg xs: Float) {
    xs.forEach {
        println(it)
    }
}
fun doubleVararg(vararg xs: Double) {
    xs.forEach {
        println(it)
    }
}
fun anyVararg(vararg xs: Any?) {
    xs.forEach {
        println(it)
    }
}
fun <T> genericVararg(vararg xs: T) {
    xs.forEach {
        println(it)
    }
}
fun stringVararg(vararg xs: String) {
    xs.forEach {
        println(it)
    }
}
fun intVararg(vararg xs: Int) {
    xs.forEach {
        println(it)
    }
}

class A {}

fun box(): String {
    val booleanList = listOf(false)
    val booleanArray = booleanArrayOf(true)
    val booleanSet = setOf(true)
    booleanVararg()
    booleanVararg(true, false)
    booleanVararg(*listOf(true))
    booleanVararg(*booleanArrayOf(true))
    booleanVararg(*booleanList)
    booleanVararg(*booleanArray)
    booleanVararg(*booleanSet)
    booleanVararg(
        *listOf(true, false),
        *setOf(true, false),
        *mutableSetOf(true, false),
        *mutableListOf(true, false),
        *booleanArrayOf(true, false),
        *arrayOf(true, false)
    )

    val charList = listOf('a')
    val charArray = charArrayOf('a')
    val charSet = setOf('a')
    charVararg()
    charVararg('a', 'b')
    charVararg(*listOf('a'))
    charVararg(*charArrayOf('a'))
    charVararg(*charList)
    charVararg(*charArray)
    charVararg(*charSet)
    charVararg(
        *listOf('a', 'b'),
        *setOf('a', 'b'),
        *mutableSetOf('a', 'b'),
        *mutableListOf('a', 'b'),
        *charArrayOf('a', 'b'),
        *arrayOf('a', 'b')
    )

    val byteList = listOf(1.toByte())
    val byteArray = byteArrayOf(1)
    val byteSet = setOf(1.toByte())
    byteVararg()
    byteVararg(1.toByte())
    byteVararg(*listOf(1))
    byteVararg(*byteArrayOf(1))
    byteVararg(*byteList)
    byteVararg(*byteArray)
    byteVararg(*byteSet)
    byteVararg(
        *listOf(1.toByte()),
        *setOf(1),
        *mutableSetOf(1),
        *mutableListOf(1),
        *byteArrayOf(1),
        *arrayOf(1)
    )

    val shortList = listOf(1.toShort())
    val shortArray = shortArrayOf(1)
    val shortSet = setOf(1.toShort())
    shortVararg()
    shortVararg(1.toShort())
    shortVararg(*listOf(1))
    shortVararg(*shortArrayOf(1))
    shortVararg(*shortList)
    shortVararg(*shortArray)
    shortVararg(*shortSet)
    shortVararg(
        *listOf(1.toShort()),
        *setOf(1),
        *mutableSetOf(1),
        *mutableListOf(1),
        *shortArrayOf(1),
        *arrayOf(1)
    )

    val intList = listOf(1)
    val intArray = intArrayOf(1)
    val intSet = setOf(1)
    intVararg()
    intVararg(1, 2)
    intVararg(*listOf(1))
    intVararg(*intArrayOf(1))
    intVararg(*intList)
    intVararg(*intArray)
    intVararg(*intSet)
    intVararg(
        *listOf(1),
        *setOf(1),
        *mutableSetOf(1),
        *mutableListOf(1),
        *intArrayOf(1),
        *arrayOf(1)
    )

    val longList = listOf(1L)
    val longArray = longArrayOf(1L)
    val longSet = setOf(1L)
    longVararg()
    longVararg(1L)
    longVararg(*listOf(1L))
    longVararg(*longArrayOf(1L))
    longVararg(*longList)
    longVararg(*longArray)
    longVararg(*longSet)
    longVararg(
        *listOf(1L),
        *setOf(1L),
        *mutableSetOf(1L),
        *mutableListOf(1L),
        *longArrayOf(1L),
        *arrayOf(1L)
    )

    val floatList = listOf(1.0f)
    val floatArray = floatArrayOf(1.0f)
    val floatSet = setOf(1.0f)
    floatVararg()
    floatVararg(1.0f)
    floatVararg(*listOf(1.0f))
    floatVararg(*floatArrayOf(1.0f))
    floatVararg(*floatList)
    floatVararg(*floatArray)
    floatVararg(*floatSet)
    floatVararg(
        *listOf(1.0f),
        *setOf(1.0f),
        *mutableSetOf(1.0f),
        *mutableListOf(1.0f),
        *floatArrayOf(1.0f),
        *arrayOf(1.0f)
    )

    val doubleList = listOf(1.0)
    val doubleArray = doubleArrayOf(1.0)
    val doubleSet = setOf(1.0)
    doubleVararg()
    doubleVararg(1.0)
    doubleVararg(*listOf(1.0))
    doubleVararg(*doubleArrayOf(1.0))
    doubleVararg(*doubleList)
    doubleVararg(*doubleArray)
    doubleVararg(*doubleSet)
    doubleVararg(
        *listOf(1.0),
        *setOf(1.0),
        *mutableSetOf(1.0),
        *mutableListOf(1.0),
        *doubleArrayOf(1.0),
        *arrayOf(1.0)
    )

    anyVararg()
    anyVararg('a', 5)
    anyVararg(*listOf('a'))
    anyVararg(*listOf(A()))
    anyVararg(*intList)
    anyVararg(*intArray)
    anyVararg(*intSet, *charSet, *byteArray)
    anyVararg(
        *listOf('a'),
        *setOf('a'),
        *mutableSetOf('a'),
        *mutableListOf('a'),
        *arrayOf('a'),
        *charArrayOf('a'),
        *intArray,
        *byteArray
    )


    genericVararg(*listOf("a"))
    genericVararg(1, 'a', "a")
    genericVararg(
        *intList
    )
    genericVararg(
        *intList,
        *intSet,
        *charSet,
        *byteArray
    )
    genericVararg(
        *listOf(true),
        *setOf(1L),
        *mutableSetOf(1.0),
        *mutableListOf("a"),
        *arrayOf("a"),
        *intArrayOf(1),
        *arrayOf(A()),
        *listOf(A())
    )

    val stringList = listOf("a")
    val stringArray = arrayOf("a")
    val stringSet = setOf("a")
    stringVararg()
    stringVararg("a", "b")
    stringVararg(*listOf("a"))
    stringVararg(*stringArray)
    stringVararg(*stringList)
    stringVararg(*stringSet)
    stringVararg(
        *listOf("a", "b"),
        *setOf("a", "b"),
        *mutableSetOf("a", "b"),
        *mutableListOf("a", "b"),
        *arrayOf("a", "b"),
        *stringArray
    )

    return "OK"
}