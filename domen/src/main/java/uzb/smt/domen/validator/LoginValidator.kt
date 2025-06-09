package uzb.smt.domen.validator

fun loginValidator(login: String): String? {
    return if (login.isEmpty()) {
        "Login bo'sh bo'lishi mumkin emas"
    } else {
        null
    }
}
