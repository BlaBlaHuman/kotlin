fun fooInt(vararg x: Int) {}

fun fooString(vararg x: String) {}

fun main(x: Array<String>?) {
    val nullableIntList: List<Int>? = null
    fooInt(<!SPREAD_OF_NULLABLE!>*<!><!TYPE_MISMATCH!>nullableIntList<!>)

    val nullableStringList: List<String>? = null
    fooString(<!SPREAD_OF_NULLABLE!>*<!><!TYPE_MISMATCH!>nullableStringList<!>)
}
