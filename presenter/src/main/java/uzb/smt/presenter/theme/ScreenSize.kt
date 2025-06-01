package uzb.smt.presenter.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Int.wDp(screenWidth: Int): Dp {
    return (this * screenWidth / 375).dp
}

@Composable
fun Int.hDp(screenHeight: Int): Dp {
    return (this * screenHeight / 812).dp
}

@Composable
fun rememberScreenWidth(): Int {
    val configuration = LocalConfiguration.current
    return remember(configuration) {
        if(configuration.screenWidthDp<configuration.screenHeightDp)configuration.screenWidthDp else configuration.screenHeightDp
    }
}

@Composable
fun rememberScreenHeight(): Int {
    val configuration = LocalConfiguration.current
    return remember(configuration) {
        if(configuration.screenWidthDp>configuration.screenHeightDp)configuration.screenWidthDp else configuration.screenHeightDp
    }
}