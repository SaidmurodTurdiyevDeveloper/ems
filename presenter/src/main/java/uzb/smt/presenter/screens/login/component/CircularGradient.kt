package uzb.smt.presenter.screens.login.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun CircularGradient(
    modifier: Modifier = Modifier.Companion, color: Color
) {
    val largeRadialGradient = object : ShaderBrush() {
        override fun createShader(size: Size): Shader {
            val biggerDimension = maxOf(size.height, size.width)
            return RadialGradientShader(
                colors = listOf(color, Color.Companion.Transparent), center = size.center, radius = biggerDimension / 3f, colorStops = listOf(0f, 1.2f)
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
private fun CircularGradientPrev() {
    CircularGradient(
        color = Color.Red.copy(0.35f)
    )
}