package uzb.smt.domen.validator

fun passwordValidator(password: String): String? {
    if (password.isEmpty()) return "Parol bo'sh bo'lishi mumkin emas"
    return null
}
