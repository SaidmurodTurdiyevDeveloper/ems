package uzb.smt.presenter.screens.login.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.common.R
import uzb.smt.presenter.theme.Blue
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.presenter.theme.WhiteBlueSecond

@Composable
internal fun ContinueButton(
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
            containerColor = Blue,
            contentColor = Color.White,
            disabledContainerColor = WhiteBlueSecond,
            disabledContentColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = stringResource(R.string.continue_button),
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

@Preview
@Composable
private fun ContinueButtonPrev() {
    ContinueButton(
        isActive = true,
        onClick = {}
    )
}