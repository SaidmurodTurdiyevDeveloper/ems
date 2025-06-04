package uzb.smt.presenter.screens.lesson_schedule_tab.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.common.utils.getMonthRes
import uzb.smt.domen.model.LessonScheduleData
import uzb.smt.domen.model.WeekLessonData
import uzb.smt.presenter.R
import uzb.smt.presenter.theme.Montserrat
import java.util.Calendar
import kotlin.random.Random

@Composable
internal fun LessonComponentWeek(
    modifier: Modifier = Modifier,
    lessons: List<WeekLessonData>,
    times: List<String>,
    now: Calendar,
    onClick: (LessonScheduleData) -> Unit
) {

    val verticalScroll = rememberScrollState()
    val horizontalScroll = rememberScrollState()
    var scrollXY by remember {
        mutableStateOf(Pair(-1, -1))
    }
    var verticalCurrentItem by remember {
        mutableIntStateOf(-1)
    }
    val density = LocalDensity.current


    LaunchedEffect(Unit) {

        lessons.forEachIndexed { index, item ->
            if (item.day.get(Calendar.DAY_OF_YEAR) == now.get(Calendar.DAY_OF_YEAR) && item.day.get(Calendar.YEAR) == now.get(Calendar.YEAR)) {
                var verticalScrollItem = times.indexOfFirst {
                    val startTimes = it.split(":")
                    val startTime = startTimes[0].toInt() * 60 + startTimes[1].toInt()
                    val firstTimes = item.lessons.first().startTime.split(":")
                    val endTime = firstTimes[0].toInt() * 60 + firstTimes[1].toInt()
                    startTime == endTime || it == item.lessons.first().startTime
                }
                verticalCurrentItem = item.lessons.indexOfFirst {
                    val startTimes = it.startTime.split(":")
                    val startTime = startTimes[0].toInt() * 60 + startTimes[1].toInt()
                    val endTimes = it.endTime.split(":")
                    val endTime = endTimes[0].toInt() * 60 + endTimes[1].toInt()
                    val nowTime = now.get(Calendar.HOUR_OF_DAY) * 60 + now.get(Calendar.MINUTE)
                    startTime <= nowTime && endTime >= nowTime
                }
                scrollXY = Pair(index, verticalScrollItem)
            }
        }
        if (scrollXY.first > 0 && !horizontalScroll.canScrollBackward) {
            val width = scrollXY.first * with(density) { 215.dp.toPx() }
            horizontalScroll.animateScrollBy(width)
        }
        if (scrollXY.second > 0 && !verticalScroll.canScrollBackward) {
            val height = (scrollXY.second - 1) * with(density) { 42.dp.toPx() }
            verticalScroll.animateScrollBy(height)
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        Background(
            modifier = Modifier,
            horizontalScroll = horizontalScroll,
            verticalScroll = verticalScroll,
            lessonSize = lessons.size,
            timeSize = times.size
        )
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(start = 40.dp)
                .horizontalScroll(horizontalScroll)
        ) {
            repeat(lessons.size) { horizontalIndex ->

                Column(
                    modifier = Modifier
                        .width(216.dp)
                        .padding(top = 41.dp)
                        .verticalScroll(verticalScroll),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    var index = 0
                    var currentIndex = 0
                    while (index < times.size - 1) {
                        if (currentIndex < lessons[horizontalIndex].lessons.size) {
                            val time = times[index]
                            val item = lessons[horizontalIndex].lessons[currentIndex]
                            if (time == item.startTime) {
                                LessonScheduleItemColor(
                                    item = item,
                                    isNow = verticalCurrentItem == currentIndex && horizontalIndex == scrollXY.first,
                                    onClick = onClick
                                )
                                Spacer(Modifier.height(21.dp))
                                index += 3
                                currentIndex++
                            } else {
                                Spacer(Modifier.height(41.dp))
                                index++
                            }
                        } else {
                            Spacer(Modifier.height(41.dp))
                            index++
                        }
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .padding(start = 40.dp)
                .width((215 * lessons.size + 1).dp)
                .horizontalScroll(horizontalScroll)
        ) {
            repeat(lessons.size) { horizontalIndex ->
                var day = lessons[horizontalIndex].day
                val monthRes = (day.get(Calendar.MONTH) + 1).getMonthRes()
                val month = stringResource(monthRes)
                val isToday = day.get(Calendar.DAY_OF_YEAR) == now.get(Calendar.DAY_OF_YEAR) && day.get(Calendar.YEAR) == now.get(Calendar.YEAR)
                Box(
                    Modifier
                        .width(216.dp)
                        .height(41.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${day.get(Calendar.DAY_OF_MONTH)}-${month}",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = if (isToday) Color(0xFF000000)
                            else Color(0x99000000),
                            lineHeight = 18.sp,
                            fontWeight = FontWeight.W600,
                            fontFamily = Montserrat
                        )
                    )
                }
            }
        }
        Times(
            modifier = Modifier,
            verticalScroll = verticalScroll,
            times = times
        )
    }
}


@Composable
private fun Times(modifier: Modifier = Modifier, verticalScroll: ScrollState, times: List<String>) {
    Column(
        modifier = modifier
            .width(40.dp)
            .verticalScroll(verticalScroll)
            .padding(top = 40.dp),
        verticalArrangement = Arrangement.spacedBy(68.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(times.size) { index ->
            if (index % 2 == 0) {
                Text(
                    text = times[index], style = TextStyle(
                        fontSize = 12.sp,
                        color = Color(0xFF3A405A),
                        lineHeight = 12.sp,
                        fontWeight = FontWeight.W600,
                        fontFamily = Montserrat
                    )
                )
            }
        }
    }
}

@Composable
private fun Background(
    modifier: Modifier = Modifier,
    horizontalScroll: ScrollState,
    verticalScroll: ScrollState,
    lessonSize: Int,
    timeSize: Int
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .horizontalScroll(horizontalScroll)
    ) {
        Column(
            modifier = Modifier
                .width((220 * lessonSize + 1).dp)
                .verticalScroll(verticalScroll)
                .padding(top = 40.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            repeat(timeSize + 1) {
                if (it % 2 != 0) {
                    CustomHorizontalDivider()
                } else {
                    HorizontalDivider(color = Color(0x333A405A))
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 40.dp)
                .width((220 * lessonSize + 1).dp),
            horizontalArrangement = Arrangement.spacedBy(215.dp)
        ) {
            repeat(7) {
                VerticalDivider(color = Color(0x333A405A))
            }
        }
    }
}


@Composable
private fun CustomHorizontalDivider(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(1.dp)
    ) {
        val dashWidth = 20f
        val dashGap = 20f
        var startX = 0f
        while (startX < size.width) {
            drawLine(
                color = Color(0x333A405A), start = Offset(startX, 0f), end = Offset(startX + dashWidth, 0f), strokeWidth = size.height
            )
            startX += dashWidth + dashGap
        }
    }
}

@Composable
internal fun LessonScheduleItemColor(
    modifier: Modifier = Modifier, item: LessonScheduleData, isNow: Boolean, onClick: (LessonScheduleData) -> Unit
) {
    val color = remember {
        Color(
            red = Random.Default.nextInt(256), green = Random.Default.nextInt(256), blue = Random.Default.nextInt(256)
        )
    }
    Card(
        modifier = modifier
            .height(100.dp)
            .width(204.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isNow) Color(0xFFC7FFDC) else Color(0xFFEAF4FF)
        ), elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(20.dp), onClick = {
            onClick(item)
        }) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(Modifier.width(16.dp))
            VerticalDivider(thickness = 3.5.dp, color = color)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Column(
                    modifier = Modifier.padding(start = 6.5.dp, top = 11.dp), verticalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Text(
                        text = item.name, style = TextStyle(
                            fontSize = 16.sp, color = Color(0xFF3A405A), lineHeight = 16.sp, fontWeight = FontWeight.W600, fontFamily = Montserrat
                        )
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(2.dp), verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_room_), contentDescription = "icon room", tint = Color(0xFF3A405A), modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = item.lessonType, style = TextStyle(
                                fontSize = 12.sp, color = Color(0xFF3A405A), lineHeight = 12.sp, fontWeight = FontWeight.W600, fontFamily = Montserrat
                            )
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(2.dp), verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_clock), contentDescription = "icon room", tint = Color(0xFF3A405A), modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = item.startTime, style = TextStyle(
                                fontSize = 12.sp, color = Color(0xFF3A405A), lineHeight = 12.sp, fontWeight = FontWeight.W600, fontFamily = Montserrat
                            )
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(2.dp), verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_person), contentDescription = "icon room", tint = Color(0xFF3A405A), modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = item.teacher, style = TextStyle(
                                fontSize = 12.sp, color = Color(0xFF3A405A), lineHeight = 12.sp, fontWeight = FontWeight.W600, fontFamily = Montserrat
                            )
                        )
                    }
                }
                Text(
                    text = item.room, style = TextStyle(
                        fontSize = 20.sp, color = Color(0xFF00226B), lineHeight = 20.sp, fontWeight = FontWeight.W600, fontFamily = Montserrat
                    ), modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 8.dp, end = 12.dp)
                )
            }
        }
    }
}