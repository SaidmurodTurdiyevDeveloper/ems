package uzb.smt.common.utils

import androidx.core.text.isDigitsOnly

fun String?.changeInt(): Int {
    if (isNullOrBlank()) return 0
    if (isDigitsOnly())
        return this.toInt()
    else {
        var a = 0
        forEach {
            if (it.isDigit()) {
                a += 10 * a + it.digitToInt()
            }
        }
        return a
    }
}