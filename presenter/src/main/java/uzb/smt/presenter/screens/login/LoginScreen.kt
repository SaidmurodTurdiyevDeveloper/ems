package uzb.smt.presenter.screens.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uzb.smt.presenter.screens.login.component.LoginBackground
import uzb.smt.presenter.screens.login.component.LoginContent
import uzb.smt.presenter.screens.login.component.TopErrorToast


@Composable
internal fun LoginScreen(
    state: LoginState,
    onAction: (LoginIntent) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LoginBackground()
        LoginContent(
            state = state,
            onAction = onAction
        )
        TopErrorToast(
            isShow = state.isShowError,
            loginError = state.loginError,
            passwordError = state.passwordError
        )
    }
}

@Preview
@Composable
private fun LoginScreenPrev() {
    LoginScreen(
        state = LoginState(),
        onAction = {}
    )
}

