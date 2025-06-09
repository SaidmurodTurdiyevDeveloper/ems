package uzb.smt.presenter.screens.home_tab.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.presenter.R
import uzb.smt.presenter.theme.Montserrat

@Composable
internal fun WeatherScreen(
    modifier: Modifier = Modifier,
    degree: String
) {
    Column(
        modifier = modifier
            .height(71.dp)
            .width(72.dp)
            .alpha(0.97f)
            .background(
                color = Color.White.copy(alpha = 0.60f),
                shape = RoundedCornerShape(14.dp)
            )
            .padding(horizontal = 8.dp, vertical = 5.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_cloud),
            contentDescription = "Cloud",
            tint = Color.White,
            modifier = Modifier.size(27.dp)
        )
        Box(modifier = Modifier) {
            Text(
                text = degree,
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.W600,
                    fontFamily = Montserrat
                )
            )
        }
    }
}

@Preview
@Composable
private fun WeatherScreenPrev() {
    WeatherScreen(
        modifier = Modifier,
        degree = "18"
    )
}