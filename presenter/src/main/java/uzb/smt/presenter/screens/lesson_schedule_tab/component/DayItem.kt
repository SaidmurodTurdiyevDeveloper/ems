package uzb.smt.presenter.screens.lesson_schedule_tab.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.common.utils.getWeekDayRes
import uzb.smt.presenter.theme.Montserrat
import java.util.Calendar

@Composable
internal fun DayItem(
    modifier: Modifier = Modifier,
    calendarDay: Calendar,
    selectedDay: Calendar,
    onClick: () -> Unit
) {
    val day = calendarDay.get(Calendar.DAY_OF_MONTH)
    val dayWeek = calendarDay.get(Calendar.DAY_OF_WEEK)
    val week = stringResource(dayWeek.getWeekDayRes()).substring(0, 3)
    val isSelected = calendarDay[Calendar.DAY_OF_YEAR] == selectedDay[Calendar.DAY_OF_YEAR] &&
            calendarDay[Calendar.YEAR] == selectedDay[Calendar.YEAR]
    Card(
        modifier = modifier,
        border = BorderStroke(
            width = 1.dp,
            color = if (isSelected) Color.Transparent else Color(0xFFBCBCBC)
        ),
        shape = RoundedCornerShape(15.dp),
        onClick = onClick,
        colors = CardDefaults.cardColors(containerColor = if (isSelected) Color(0xFF0077FF) else Color.White)
    ) {
        Column(
            modifier = Modifier
                .height(60.dp)
                .width(50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = day.toString(),
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 24.sp,
                    color = if (isSelected) Color(0xFFFFFFFF) else Color(0xFF3A405A),
                    fontWeight = FontWeight.W600,
                    fontFamily = Montserrat
                )
            )
            Text(
                text = week,
                style = TextStyle(
                    fontSize = 10.sp,
                    lineHeight = 12.sp,
                    color = if (isSelected) Color(0xFFFFFFFF) else Color(0xFF3A405A),
                    fontWeight = FontWeight.W500,
                    fontFamily = Montserrat
                )
            )
        }
    }

}