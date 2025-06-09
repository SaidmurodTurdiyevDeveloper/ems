package uzb.smt.presenter.screens.login.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.presenter.R
import uzb.smt.presenter.screens.login.LoginIntent
import uzb.smt.presenter.screens.login.LoginState
import uzb.smt.presenter.theme.Blue
import uzb.smt.presenter.theme.DarkBlue
import uzb.smt.presenter.theme.Montserrat

@Composable
internal fun LoginContent(
    modifier: Modifier = Modifier,
    state: LoginState,
    onAction: (LoginIntent) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.img_logo_login),
            contentDescription = "Login logo",
            modifier = Modifier
                .width(130.dp)
                .height(126.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = stringResource(uzb.smt.common.R.string.login_title),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp,
                color = DarkBlue,
                lineHeight = 20.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.W600
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            login = state.login,
            onChange = { onAction(LoginIntent.ChangeLogin(it)) },
            onFocusChange = {
                onAction(LoginIntent.ChangeLoginFocused(it))
            },
            isFocused = state.loginFocus,
            error = state.loginError
        )
        Spacer(modifier = Modifier.height(8.dp))
        PasswordTextField(
            modifier = Modifier.fillMaxWidth(),
            password = state.password,
            onChange = { onAction(LoginIntent.ChangePassword(it)) },
            onFocusChange = {
                onAction(LoginIntent.ChangePasswordFocused(it))
            },
            isFocused = state.passwordFocus,
            error = state.passwordError
        )
        Spacer(modifier = Modifier.height(16.dp))
        ContinueButton(
            modifier = Modifier.fillMaxWidth(),
            isActive = state.isActive,
            onClick = { onAction(LoginIntent.Login) }
        )
        Spacer(modifier = Modifier.height(36.dp))
        TextButton(
            onClick = {
                onAction(LoginIntent.ForgotPassword)
            }
        ) {
            Text(
                text = stringResource(uzb.smt.common.R.string.forgot_password),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Blue,
                    lineHeight = 16.sp,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.W500
                )
            )
        }
    }
}

@Preview
@Composable
private fun LoginContentPrev() {
    LoginContent(
        state = LoginState(),
        onAction = {}
    )
}