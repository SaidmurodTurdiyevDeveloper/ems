package uzb.smt.presenter.screens.home_tab.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.common.utils.getMonthRes
import uzb.smt.presenter.R
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.presenter.theme.Purple
import java.util.Calendar

@Composable
internal fun CalendarScreen(
    modifier: Modifier = Modifier
) {
    val calendar by remember { mutableStateOf(Calendar.getInstance()) }
    Column(
        modifier = modifier
            .requiredHeightIn(min = 71.dp)
            .alpha(0.97f)
            .background(
                color = Color.White.copy(0.6f),
                shape = RoundedCornerShape(14.dp)
            )
            .padding(horizontal = 8.dp, vertical = 5.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(48.dp)
                    .height(43.dp)
                    .background(
                        color = Purple,
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = calendar.get(Calendar.HOUR_OF_DAY).toString(),
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight.W600,
                        fontFamily = Montserrat
                    )
                )
            }
            Box(
                modifier = Modifier
                    .width(48.dp)
                    .height(43.dp)
                    .background(
                        color = Purple,
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = calendar.get(Calendar.MINUTE).toString(),
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
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_calendar),
                contentDescription = "Calendar",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
            val monthRes = (calendar.get(Calendar.MONTH)+1).getMonthRes()
            val month = stringResource(monthRes)
            Text(
                text = "${calendar.get(Calendar.DAY_OF_MONTH)}-${month}- ${calendar.get(Calendar.YEAR)}-" + stringResource(uzb.smt.common.R.string.year),
                style = TextStyle(
                    fontSize = 10.sp,
                    lineHeight = 10.sp,
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
private fun CalendarScreenPrev() {
    CalendarScreen()
}