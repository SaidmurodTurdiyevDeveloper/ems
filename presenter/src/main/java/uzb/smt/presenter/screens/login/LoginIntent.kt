package uzb.smt.presenter.screens.login

internal sealed interface LoginIntent {
    data class ChangeLogin(val login: String) : LoginIntent
    data class ChangePassword(val password: String) : LoginIntent
    data object Login : LoginIntent
    data object ForgotPassword : LoginIntent
}