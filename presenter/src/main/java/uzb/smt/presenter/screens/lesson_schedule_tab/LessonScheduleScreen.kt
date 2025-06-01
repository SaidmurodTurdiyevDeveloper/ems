package uzb.smt.presenter.screens.lesson_schedule_tab

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.common.utils.getMonthRes
import uzb.smt.domen.model.LessonScheduleData
import uzb.smt.presenter.R
import uzb.smt.presenter.screens.lesson_schedule_tab.component.DayItem
import uzb.smt.presenter.theme.Montserrat
import java.util.Calendar
import kotlin.random.Random
import uzb.smt.common.R as commonR


@Composable
internal fun LessonScheduleScreen(state: LessonScheduleState, onAction: (LessonScheduleIntent) -> Unit) {
    val width = (LocalConfiguration.current.screenWidthDp - 16 - (7 * 50)) / 6
    val now = remember {
        Calendar.getInstance()
    }
    val isNow = now[Calendar.DAY_OF_YEAR] == state.selectedDay[Calendar.DAY_OF_YEAR] &&
            now[Calendar.YEAR] == state.selectedDay[Calendar.YEAR]
    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Row(
            modifier = Modifier
                .padding(start = 16.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(commonR.string.lesson_schedule),
                style = TextStyle(
                    fontSize = 30.sp,
                    lineHeight = 32.sp,
                    color = Color(0xFF000000),
                    fontWeight = FontWeight.W700,
                    fontFamily = Montserrat
                )
            )
            Spacer(Modifier.weight(1f))
            IconButton(
                modifier = Modifier.size(41.dp),
                onClick = {}) {
                Image(
                    painter = painterResource(R.drawable.ic_news_black), contentDescription = "notification"
                )
            }
            IconButton(
                modifier = Modifier.size(41.dp), onClick = {}) {
                Image(
                    painter = painterResource(R.drawable.ic_moon_black), contentDescription = "day night"
                )
            }
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 20.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(if (state.isDay) 10.dp else width.dp)
        ) {
            items(state.days) {
                DayItem(
                    calendarDay = it,
                    selectedDay = state.selectedDay
                ) {
                    onAction(LessonScheduleIntent.SelectDate(it))
                }
            }
        }
        Spacer(Modifier.height(2.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Row(modifier = Modifier.align(Alignment.CenterStart), horizontalArrangement = Arrangement.spacedBy(3.dp)) {
                Card(
                    modifier = Modifier.size(40.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF1F2937),
                        contentColor = Color.White
                    ),
                    onClick = {
                        if (state.isDay) {
                            onAction(LessonScheduleIntent.PreviousDay)
                        } else {
                            onAction(LessonScheduleIntent.PreviousWeek)
                        }
                    }) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Left"
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(40.dp)
                        .background(
                            color = Color(0xFF0077FF),
                            shape = RoundedCornerShape(10.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (isNow) stringResource(commonR.string.today) else {
                            stringResource((state.selectedDay[Calendar.MONTH] + 1).getMonthRes())
                        },
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 16.sp,
                            color = Color.White,
                            fontWeight = FontWeight.W500,
                            fontFamily = Montserrat
                        )
                    )
                }
                Card(
                    modifier = Modifier.size(40.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF1F2937),
                        contentColor = Color.White
                    ),
                    onClick = {
                        if (state.isDay) {
                            onAction(LessonScheduleIntent.NextDay)
                        } else {
                            onAction(LessonScheduleIntent.NextWeek)
                        }
                    }) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Right"
                        )
                    }
                }
            }
            Row(modifier = Modifier.align(Alignment.CenterEnd), horizontalArrangement = Arrangement.spacedBy(3.dp)) {
                Card(
                    modifier = Modifier
                        .width(100.dp)
                        .height(40.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (state.isDay) Color(0xFF1F2937) else Color.White,
                        contentColor = if (state.isDay) Color.White else Color(0xFF3A405A)
                    ),
                    border = BorderStroke(
                        width = 1.dp,
                        color = Color(0xFF3A405A)
                    ),
                    onClick = {
                        onAction(LessonScheduleIntent.ChangeToDay)
                    }
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(
                            text = stringResource(commonR.string.day),
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 16.sp,
                                fontWeight = FontWeight.W500,
                                fontFamily = Montserrat
                            )
                        )
                    }

                }
                Card(
                    modifier = Modifier
                        .width(100.dp)
                        .height(40.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (state.isDay) Color.White else Color(0xFF1F2937),
                        contentColor = if (state.isDay) Color(0xFF3A405A) else Color.White
                    ),
                    border = BorderStroke(
                        width = 1.dp,
                        color = Color(0xFF3A405A)
                    ),
                    onClick = {
                        onAction(LessonScheduleIntent.ChangeToWeek)
                    }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(commonR.string.week),
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 16.sp,
                                fontWeight = FontWeight.W500,
                                fontFamily = Montserrat
                            )
                        )
                    }
                }
            }
        }
        Spacer(Modifier.height(12.dp))
        if (state.lessons.isNotEmpty()) {
            LessonComponent(
                lessons = state.lessons,
                calendar = now,
                isNow = isNow,
                onClick = {}
            )
        } else {
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.size(130.dp),
                    painter = painterResource(id = R.drawable.img_lesson_schedule_empty),
                    contentDescription = "empty"
                )
            }
        }

    }
}

@Composable
internal fun LessonComponent(
    modifier: Modifier = Modifier,
    lessons: List<LessonScheduleData>,
    isNow: Boolean,
    calendar: Calendar,
    onClick: (LessonScheduleData) -> Unit
) {
    val currentIndex = if (isNow) {
        lessons.indexOfFirst {
            val startTimes = it.startTime.split(":")
            val startTime = startTimes[0].toInt() * 60 + startTimes[1].toInt()
            val endTimes = it.endTime.split(":")
            val endTime = endTimes[0].toInt() * 60 + endTimes[1].toInt()
            val nowTime = calendar.get(Calendar.HOUR_OF_DAY) * 60 + calendar.get(Calendar.MINUTE)
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
                Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
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
                                            if (currentIndex == index)
                                                Modifier.background(
                                                    color = Color(0xFF35DD75),
                                                    shape = CircleShape
                                                )
                                            else
                                                Modifier.border(
                                                    width = 4.dp,
                                                    color = Color(0xFF0077FF),
                                                    shape = CircleShape
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
                                                color = Color(0xFF0077FF)
                                            )
                                    )
                                    Spacer(modifier = Modifier.height(6.dp))
                                }

                            }
                            Spacer(Modifier.width(6.dp))
                            Box(
                                Modifier.height(20.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = item.startTime,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        color = if (currentIndex == index) Color(0xFF35DD75) else Color(0xFF3A405A),
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
                    modifier = Modifier.fillMaxWidth(0.75f),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    lessons.forEach {
                        LessonScheduleItem(
                            item = it,
                            onClick = onClick
                        )
                    }
                }
            }
        }
    }

}

@Composable
internal fun LessonScheduleItem(
    modifier: Modifier = Modifier,
    item: LessonScheduleData,
    onClick: (LessonScheduleData) -> Unit
) {
    val color = remember {
        Color(
            red = Random.nextInt(256),
            green = Random.nextInt(256),
            blue = Random.nextInt(256)
        )
    }
    Card(
        modifier = modifier
            .height(100.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(20.dp),
        onClick = {
            onClick(item)
        }
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(Modifier.width(16.dp))
            VerticalDivider(thickness = 3.5.dp, color = color)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Column(
                    modifier = Modifier.padding(start = 6.5.dp, top = 11.dp),
                    verticalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Text(
                        text = item.name,
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color(0xFF3A405A),
                            lineHeight = 16.sp,
                            fontWeight = FontWeight.W600,
                            fontFamily = Montserrat
                        )
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_room_),
                            contentDescription = "icon room",
                            tint = Color(0xFF3A405A),
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = item.lessonType,
                            style = TextStyle(
                                fontSize = 12.sp,
                                color = Color(0xFF3A405A),
                                lineHeight = 12.sp,
                                fontWeight = FontWeight.W600,
                                fontFamily = Montserrat
                            )
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_clock),
                            contentDescription = "icon room",
                            tint = Color(0xFF3A405A),
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = item.startTime,
                            style = TextStyle(
                                fontSize = 12.sp,
                                color = Color(0xFF3A405A),
                                lineHeight = 12.sp,
                                fontWeight = FontWeight.W600,
                                fontFamily = Montserrat
                            )
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_person),
                            contentDescription = "icon room",
                            tint = Color(0xFF3A405A),
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = item.teacher,
                            style = TextStyle(
                                fontSize = 12.sp,
                                color = Color(0xFF3A405A),
                                lineHeight = 12.sp,
                                fontWeight = FontWeight.W600,
                                fontFamily = Montserrat
                            )
                        )
                    }
                }
                Text(
                    text = item.endTime,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color(0xFF00226B),
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.W600,
                        fontFamily = Montserrat
                    ),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 8.dp, end = 12.dp)
                )
                Card(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 7.dp, bottom = 8.dp),
                    shape = RoundedCornerShape(10.dp),
                    onClick = {},
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1F2937))
                ) {
                    Row(
                        modifier = Modifier
                            .width(130.dp)
                            .height(36.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home),
                            contentDescription = "icon room",
                            tint = Color(0xFFFFFFFF),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(Modifier.width(5.dp))
                        Text(
                            text = stringResource(commonR.string.home_work),
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color(0xFFFFFFFF),
                                lineHeight = 14.sp,
                                fontWeight = FontWeight.W600,
                                fontFamily = Montserrat
                            )
                        )
                    }
                }
            }
        }
    }
}
