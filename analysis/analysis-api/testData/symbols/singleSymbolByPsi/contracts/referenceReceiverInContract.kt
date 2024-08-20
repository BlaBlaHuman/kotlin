// WITH_STDLIB
// DO_NOT_CHECK_SYMBOL_RESTORE_K1
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
fun (() -> Unit).referenceReceiverInContract() {
    contr<caret>act {
        callsInPlace(this@referenceReceiverInContract, InvocationKind.EXACTLY_ONCE)
    }
    this()
}
