package uzb.smt.presenter.screens.login

internal data class LoginState(
    val isLoading: Boolean = false,
    val isActive: Boolean = false,
    val isShowError: Boolean = false,
    val loginError: String? = null,
    val passwordError: String? = null,
    val login: String = "",
    val password: String = "",
)
