// ISSUE: KT-71210
// RENDER_DIAGNOSTICS_FULL_TEXT

class C<T> {
    companion object {
        operator fun <T> invoke(name: String) = C<T>()
    }
}

fun main() {
    C.Companion.<!CANNOT_INFER_PARAMETER_TYPE, NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>invoke<!>("")
    C<Int>.Companion.<!CANNOT_INFER_PARAMETER_TYPE, NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>invoke<!>("")
    C<Int, Int, Int>.Companion.<!CANNOT_INFER_PARAMETER_TYPE, NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>invoke<!>("")

    C.<!CANNOT_INFER_PARAMETER_TYPE, NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>invoke<!>("")
    C<Int>.<!CANNOT_INFER_PARAMETER_TYPE, NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>invoke<!>("")
    C<Int, Int, Int>.<!CANNOT_INFER_PARAMETER_TYPE, NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>invoke<!>("")

    C.Companion.invoke<Int>("")
    C<Int>.Companion.invoke<Int>("")
    C<Int, Int, Int>.Companion.invoke<Int>("")

    C.invoke<Int>("")
    C<Int>.invoke<Int>("")
    C<Int, Int, Int>.invoke<Int>("")

    <!CANNOT_INFER_PARAMETER_TYPE, NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>C<!>("")
    C<Int>("")
    C<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><Int, Int, Int><!>("")

    C.Companion.invoke<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><Int, Int, Int><!>("")
    C<Int>.Companion.invoke<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><Int, Int, Int><!>("")
    C<Int, Int, Int>.Companion.invoke<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><Int, Int><!>("")

    C.invoke<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><Int, Int, Int><!>("")
    C<Int>.invoke<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><Int, Int, Int><!>("")
    C<Int, Int, Int>.invoke<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><Int, Int><!>("")
}
