package uzb.smt.presenter.screens.lesson_schedule_tab.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.domen.model.LessonScheduleData
import uzb.smt.presenter.theme.Blue
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.presenter.theme.Purple
import java.util.Calendar

@Composable
internal fun LessonComponent(
    modifier: Modifier = Modifier,
    lessons: List<LessonScheduleData>,
    isNow: Boolean,
    now: Calendar,
    onClick: (LessonScheduleData) -> Unit
) {
    val currentIndex = if (isNow) {
        lessons.indexOfFirst {
            val startTimes = it.startTime.split(":")
            val startTime = startTimes[0].toInt() * 60 + startTimes[1].toInt()
            val endTimes = it.endTime.split(":")
            val endTime = endTimes[0].toInt() * 60 + endTimes[1].toInt()
            val nowTime = now.get(Calendar.HOUR_OF_DAY) * 60 + now.get(Calendar.MINUTE)
            startTime <= nowTime && endTime >= nowTime
        }
    } else {
        -1
    }
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(top = 24.dp, bottom = 120.dp, end = 10.dp)
    ) {
        item(key = "item") {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(Modifier.height(48.dp))
                    lessons.forEachIndexed { index, item ->
                        Row {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Box(
                                    modifier = Modifier
                                        .height(20.dp)
                                        .padding(vertical = 2.dp)
                                        .width(16.dp)
                                        .then(
                                            if (currentIndex == index) Modifier.background(
                                                color = Color(0xFF35DD75), shape = CircleShape
                                            )
                                            else Modifier.border(
                                                width = 4.dp, color = Blue, shape = CircleShape
                                            )
                                        )
                                )
                                if (index != lessons.size - 1) {
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Box(
                                        Modifier
                                            .width(7.dp)
                                            .height(76.dp)
                                            .background(
                                                color = Blue
                                            )
                                    )
                                    Spacer(modifier = Modifier.height(6.dp))
                                }

                            }
                            Spacer(Modifier.width(6.dp))
                            Box(
                                Modifier.height(20.dp), contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = item.startTime, style = TextStyle(
                                        fontSize = 16.sp,
                                        color = if (currentIndex == index) Color(0xFF35DD75) else Purple,
                                        lineHeight = 16.sp,
                                        fontWeight = FontWeight.W500,
                                        fontFamily = Montserrat
                                    )
                                )
                            }
                        }
                    }

                }
                Column(
                    modifier = Modifier.fillMaxWidth(0.75f), verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    lessons.forEach {
                        LessonScheduleItem(
                            item = it, onClick = onClick
                        )
                    }
                }
            }
        }
    }

}

