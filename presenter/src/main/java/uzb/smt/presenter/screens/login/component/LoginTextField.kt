package uzb.smt.presenter.screens.login.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.common.R
import uzb.smt.presenter.theme.GrayThird
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.presenter.theme.Purple
import uzb.smt.presenter.theme.Red

@Composable
internal fun LoginTextField(
    modifier: Modifier = Modifier,
    login: String,
    isFocused: Boolean,
    error: String?,
    onFocusChange: (Boolean) -> Unit,
    onChange: (String) -> Unit
) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    LaunchedEffect(Unit) {
        if (isFocused) {
            focusRequester.requestFocus()
        }
    }
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = stringResource(R.string.login),
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 16.sp,
                color = Purple,
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
                .onFocusEvent(onFocusEvent = {
                    onFocusChange(it.isFocused)
                })
                .focusRequester(focusRequester)
                .height(50.dp),
            placeholder = {
                Text(
                    text = stringResource(R.string.login_placeholder),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        color = Purple,
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.W500
                    )
                )
            },
            shape = RoundedCornerShape(10.dp),
            textStyle = TextStyle(
                fontSize = 14.sp,
                lineHeight = 16.sp,
                color = Purple,
                fontFamily = Montserrat,
                fontWeight = FontWeight.W500
            ),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
            isError = error != null,
            colors = OutlinedTextFieldDefaults.colors(
                errorBorderColor = Red,
                unfocusedBorderColor = GrayThird,
                focusedBorderColor = Purple,
                cursorColor = Purple
            )
        )
        AnimatedVisibility(visible = error != null) {
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = error ?: "",
                style = TextStyle(
                    fontSize = 10.sp,
                    lineHeight = 12.sp,
                    color = Red,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.W500
                )
            )
        }
    }
}

@Preview
@Composable
private fun LoginTextFieldPrev() {
    LoginTextField(
        modifier = Modifier.padding(horizontal = 8.dp),
        login = "login",
        isFocused = false,
        error = null,
        onFocusChange = { },
        onChange = { }
    )
}