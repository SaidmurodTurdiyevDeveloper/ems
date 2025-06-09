package uzb.smt.presenter.screens.login.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uzb.smt.presenter.theme.LightBlueSecond
import uzb.smt.presenter.theme.Orange

@Composable
internal fun LoginBackground(modifier: Modifier = Modifier) {
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
                .align(Alignment.TopStart), color = Orange.copy(0.35f)
        )
        CircularGradient(
            modifier = Modifier
                .offset(x = (0.2 * width).dp, y = (-0.25 * height).dp)
                .width(width.dp)
                .height(height.dp)
                .align(Alignment.TopEnd), color = LightBlueSecond.copy(0.35f)
        )
    }
}

@Preview
@Composable
private fun LoginBackgroundPrev() {
    LoginBackground()
}