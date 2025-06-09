package uzb.smt.presenter.screens.home_tab.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.presenter.theme.Gray
import uzb.smt.presenter.theme.Montserrat

@Composable
internal fun CircularProgress(
    modifier: Modifier = Modifier.Companion,
    score: Int,
    percent: Float,
    color: Color
) {
    var startAnimation by remember { mutableStateOf(false) }

    val animatedPercentage by animateFloatAsState(
        targetValue = if (startAnimation) percent else 0f,
        animationSpec = tween(
            durationMillis = 800,
            easing = FastOutSlowInEasing
        ),
        label = "Score Animation"
    )

    LaunchedEffect(Unit) {
        startAnimation = true
    }

    Box(
        contentAlignment = Alignment.Companion.Center,
        modifier = modifier.size(56.dp)
    ) {
        Canvas(modifier = Modifier.Companion.size(56.dp)) {
            drawArc(
                color = Gray,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(8.dp.toPx(), cap = StrokeCap.Companion.Round)
            )

            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360f * animatedPercentage,
                useCenter = false,
                style = Stroke(8.dp.toPx(), cap = StrokeCap.Companion.Round)
            )
        }
        Text(
            text = score.toString(),
            textAlign = TextAlign.Companion.Center,
            style = TextStyle(
                color = color,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Companion.W700,
                fontFamily = Montserrat
            )
        )
    }
}

@Preview
@Composable
private fun CircularProgressPrev() {
    CircularProgress(
        modifier = Modifier.size(56.dp),
        score = 80,
        percent = 0.8f,
        color = Color.Red
    )
}