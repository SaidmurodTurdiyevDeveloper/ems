package uzb.smt.presenter.screens.login

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uzb.smt.presenter.navigator.AppNavigatorImpl
import uzb.smt.presenter.navigator.AppScreens
import uzb.smt.presenter.utils.BaseViewModel
import javax.inject.Inject

@HiltViewModel
internal class LoginViewModel @Inject constructor(
    navigator: AppNavigatorImpl
) : BaseViewModel<LoginState, LoginIntent>(initializeData = LoginState(), appNavigator = navigator) {
    private var isSHow = false

    init {
        uiState.filter {
            (it.loginError != null || it.passwordError != null) && isSHow
        }.onEach {
            isSHow = false
            update(state.copy(isShowError = true))
            delay(3000)
            update(state.copy(isShowError = false))
        }.launchIn(viewModelScope)
    }

    override fun onAction(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.ChangeLogin -> update(
                state.copy(
                    login = intent.login,
                    isActive = intent.login.isNotBlank() || state.password.isNotBlank(),
                    loginError = null
                )
            )

            is LoginIntent.ChangePassword -> update(
                state.copy(
                    password = intent.password,
                    isActive = intent.password.isNotBlank() || state.login.isNotBlank(),
                    passwordError = null
                )
            )

            LoginIntent.ForgotPassword -> forgotPassword()
            LoginIntent.Login -> login()
        }
    }

    private fun login() {
        navigate(AppScreens.AppMainTabScreen)
    }

    private fun forgotPassword() {
        isSHow = true
        update(state.copy(loginError = "Login xato", passwordError = "Parol xato"))
    }

}