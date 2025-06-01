package uzb.smt.presenter.screens.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.presenter.R
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.common.R as commonR


@Composable
internal fun LoginScreen(
    state: LoginState,
    onAction: (LoginIntent) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        ComposeBackground()
        LoginContent(
            state = state,
            onAction = onAction
        )
        ErrorScreen(
            isShow = state.isShowError,
            loginError = state.loginError,
            passwordError = state.passwordError
        )
    }
}

@Composable
private fun LoginContent(
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
            text = stringResource(commonR.string.login_title),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp,
                color = Color(0xFF00226B),
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
            error = state.loginError
        )
        Spacer(modifier = Modifier.height(8.dp))
        PasswordTextField(
            modifier = Modifier.fillMaxWidth(),
            password = state.password,
            onChange = { onAction(LoginIntent.ChangePassword(it)) },
            error = state.passwordError
        )
        Spacer(modifier = Modifier.height(16.dp))
        ContinueButton(
            modifier = Modifier.fillMaxWidth(),
            isActive = state.isActive,
            onClick = { onAction(LoginIntent.Login) }
        )
        Spacer(modifier = Modifier.height(48.dp))
        TextButton(
            onClick = {
                onAction(LoginIntent.ForgotPassword)
            }
        ) {
            Text(
                text = stringResource(commonR.string.forgot_password),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF0077FF),
                    lineHeight = 16.sp,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.W500
                )
            )
        }
    }
}

@Composable
private fun ErrorScreen(
    modifier: Modifier = Modifier,
    isShow: Boolean = false,
    loginError: String?,
    passwordError: String?
) {
    AnimatedVisibility(
        visible = isShow, enter = fadeIn() + expandVertically(), exit = fadeOut() + shrinkVertically()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.statusBars)
                .padding(top = 24.dp, start = 32.dp, end = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            if (!loginError.isNullOrBlank()) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFEF5F5F), shape = RoundedCornerShape(10.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(1f), text = loginError, textAlign = TextAlign.Center, style = TextStyle(
                            color = Color.White, fontSize = 14.sp, lineHeight = 16.sp, fontFamily = Montserrat, fontWeight = FontWeight.W700
                        )
                    )
                    Spacer(Modifier.width(6.dp))
                    Icon(
                        painter = painterResource(R.drawable.ic_info), contentDescription = "Close", tint = Color.White
                    )
                }
            }

            if (!passwordError.isNullOrBlank()) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFEF5F5F), shape = RoundedCornerShape(10.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(1f), text = passwordError, textAlign = TextAlign.Center, style = TextStyle(
                            color = Color.White, fontSize = 14.sp, lineHeight = 16.sp, fontFamily = Montserrat, fontWeight = FontWeight.W700
                        )
                    )
                    Spacer(Modifier.width(6.dp))
                    Icon(
                        painter = painterResource(R.drawable.ic_info), contentDescription = "Close", tint = Color.White
                    )
                }
            }
        }

    }
}

@Composable
private fun LoginTextField(
    modifier: Modifier = Modifier,
    login: String,
    error: String?,
    onChange: (String) -> Unit
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = stringResource(commonR.string.login),
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.sp,
                color = Color(0xFF3A405A),
                fontFamily = Montserrat,
                fontWeight = FontWeight.W600
            )
        )
        Spacer(Modifier.height(4.dp))
        OutlinedTextField(
            value = login,
            onValueChange = onChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            placeholder = {
                Text(
                    text = stringResource(commonR.string.login_placeholder),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        color = Color(0xFF3A405A),
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.W500
                    )
                )
            },
            shape = RoundedCornerShape(10.dp),
            textStyle = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.sp,
                color = Color(0xFF3A405A),
                fontFamily = Montserrat,
                fontWeight = FontWeight.W500
            ),
            isError = error != null,
            colors = OutlinedTextFieldDefaults.colors(
                errorBorderColor = Color(0xFFFF0000),
                unfocusedBorderColor = Color(0xFFBCBCBC),
                focusedBorderColor = Color(0xFF3A405A),
                cursorColor = Color(0xFF3A405A)
            )
        )
        if (error != null) {
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = error,
                style = TextStyle(
                    fontSize = 10.sp,
                    lineHeight = 14.sp,
                    color = Color(0xFFFF0000),
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.W500
                )
            )
        }
    }
}

@Composable
private fun PasswordTextField(
    modifier: Modifier = Modifier,
    password: String,
    error: String?,
    onChange: (String) -> Unit
) {
    var passwordVisible by remember { mutableStateOf(false) }
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = stringResource(commonR.string.password),
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.sp,
                color = Color(0xFF3A405A),
                fontFamily = Montserrat,
                fontWeight = FontWeight.W600
            )
        )
        Spacer(Modifier.height(4.dp))
        OutlinedTextField(
            value = password,
            onValueChange = onChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            trailingIcon = {
                val image = if (passwordVisible)
                    painterResource(R.drawable.ic_password_show)
                else
                    painterResource(R.drawable.ic_password_show_off)

                val description = if (passwordVisible) "Hide password" else "Show password"
                Row(verticalAlignment = Alignment.CenterVertically) {
                    VerticalDivider(
                        color = Color(0xFFBCBCBC), thickness = 1.dp
                    )
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = image,
                            contentDescription = description,
                            tint = Color(0xFF00226B)
                        )
                    }
                }

            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            placeholder = {
                Text(
                    text = stringResource(commonR.string.password_placeholder),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        color = Color(0xFF3A405A),
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.W500
                    )
                )
            },
            shape = RoundedCornerShape(10.dp),
            textStyle = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.sp,
                color = Color(0xFF3A405A),
                fontFamily = Montserrat,
                fontWeight = FontWeight.W500
            ),
            isError = error != null,
            colors = OutlinedTextFieldDefaults.colors(
                errorBorderColor = Color(0xFFFF0000),
                unfocusedBorderColor = Color(0xFFBCBCBC),
                focusedBorderColor = Color(0xFF3A405A),
                cursorColor = Color(0xFF3A405A)
            )
        )
        if (error != null) {
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = error,
                style = TextStyle(
                    fontSize = 10.sp,
                    lineHeight = 14.sp,
                    color = Color(0xFFFF0000),
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.W500
                )
            )
        }
    }
}

@Composable
private fun ContinueButton(
    modifier: Modifier = Modifier,
    isActive: Boolean,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        onClick = onClick,
        enabled = isActive,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF0077FF),
            contentColor = Color.White,
            disabledContainerColor = Color(0xFFAFD5FF),
            disabledContentColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = stringResource(commonR.string.continue_button),
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 18.sp,
                color = Color.White,
                fontFamily = Montserrat,
                fontWeight = FontWeight.W600
            )
        )
    }
}

@Composable
private fun ComposeBackground(modifier: Modifier = Modifier) {
    val height = LocalConfiguration.current.screenHeightDp * 0.7
    val width = LocalConfiguration.current.screenHeightDp * 0.8
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        CircularGradient(
            modifier = Modifier
                .offset(x = (-0.3 * width).dp, y = (-0.2 * height).dp)
                .width(width.dp)
                .height(height.dp)
                .align(Alignment.TopStart), color = Color(0x59FA7131)
        )
        CircularGradient(
            modifier = Modifier
                .offset(x = (0.2 * width).dp, y = (-0.25 * height).dp)
                .width(width.dp)
                .height(height.dp)
                .align(Alignment.TopEnd), color = Color(0x5931A0FA)
        )

    }
}

@Composable
private fun CircularGradient(
    modifier: Modifier = Modifier, color: Color
) {
    val largeRadialGradient = object : ShaderBrush() {
        override fun createShader(size: Size): Shader {
            val biggerDimension = maxOf(size.height, size.width)
            return RadialGradientShader(
                colors = listOf(color, Color.Transparent), center = size.center, radius = biggerDimension / 3f, colorStops = listOf(0f, 1.2f)
            )
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(largeRadialGradient)
    )
}

@Preview
@Composable
private fun ComposeBackgroundPrev() {
    ComposeBackground()
}