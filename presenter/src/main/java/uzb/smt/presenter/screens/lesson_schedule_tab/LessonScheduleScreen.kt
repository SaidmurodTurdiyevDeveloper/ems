package uzb.smt.presenter.screens.lesson_schedule_tab

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.presenter.R
import uzb.smt.presenter.screens.lesson_schedule_tab.component.DayItem
import uzb.smt.presenter.screens.lesson_schedule_tab.component.LessonComponent
import uzb.smt.presenter.screens.lesson_schedule_tab.component.LessonComponentWeek
import uzb.smt.presenter.theme.Montserrat
import java.util.Calendar
import uzb.smt.common.R as commonR


@Composable
internal fun LessonScheduleScreen(
    state: LessonScheduleState,
    onAction: (LessonScheduleIntent) -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        (context as ComponentActivity).enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                scrim = android.graphics.Color.TRANSPARENT,
                darkScrim = android.graphics.Color.TRANSPARENT
            )
        )
    }
    val buttonsWidth = (LocalConfiguration.current.screenWidthDp - 115) / 3
    val now = remember {
        Calendar.getInstance()
    }
    val isNow = now[Calendar.DAY_OF_YEAR] == state.selectedDay[Calendar.DAY_OF_YEAR] && now[Calendar.YEAR] == state.selectedDay[Calendar.YEAR]
    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 8.dp, top = 4.dp, bottom = 4.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(commonR.string.lesson_schedule), style = TextStyle(
                    fontSize = 30.sp, lineHeight = 32.sp, color = Color(0xFF000000), fontWeight = FontWeight.W700, fontFamily = Montserrat
                )
            )
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 20.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(state.days) {
                DayItem(
                    calendarDay = it, selectedDay = state.selectedDay
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
                    modifier = Modifier.size(40.dp), colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF1F2937), contentColor = Color.White
                    ), onClick = {
                        if (state.isDay) {
                            onAction(LessonScheduleIntent.PreviousDay)
                        } else {
                            onAction(LessonScheduleIntent.PreviousWeek)
                        }
                    }) {
                    Box(
                        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Left"
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .width(buttonsWidth.dp)
                        .height(40.dp), colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF0077FF), contentColor = Color.White
                    ), onClick = {
                        onAction(LessonScheduleIntent.CurrentDay)
                    }) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(commonR.string.today), style = TextStyle(
                                fontSize = 16.sp, lineHeight = 16.sp, color = Color.White, fontWeight = FontWeight.W500, fontFamily = Montserrat
                            )
                        )
                    }
                }

                Card(
                    modifier = Modifier.size(40.dp), colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF1F2937), contentColor = Color.White
                    ), onClick = {
                        if (state.isDay) {
                            onAction(LessonScheduleIntent.NextDay)
                        } else {
                            onAction(LessonScheduleIntent.NextWeek)
                        }
                    }) {
                    Box(
                        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "Right"
                        )
                    }
                }
            }
            Row(modifier = Modifier.align(Alignment.CenterEnd), horizontalArrangement = Arrangement.spacedBy(3.dp)) {
                Card(
                    modifier = Modifier
                        .width(buttonsWidth.dp)
                        .height(40.dp), colors = CardDefaults.cardColors(
                        containerColor = if (state.isDay) Color(0xFF1F2937) else Color.White, contentColor = if (state.isDay) Color.White else Color(0xFF3A405A)
                    ), border = BorderStroke(width = 1.dp, color = Color(0xFF3A405A)), onClick = {
                        onAction(LessonScheduleIntent.ChangeToDay)
                    }) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(
                            text = stringResource(commonR.string.day), style = TextStyle(
                                fontSize = 16.sp, lineHeight = 16.sp, fontWeight = FontWeight.W500, fontFamily = Montserrat
                            )
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .width(buttonsWidth.dp)
                        .height(40.dp), colors = CardDefaults.cardColors(
                        containerColor = if (state.isDay) Color.White else Color(0xFF1F2937), contentColor = if (state.isDay) Color(0xFF3A405A) else Color.White
                    ), border = BorderStroke(
                        width = 1.dp, color = Color(0xFF3A405A)
                    ), onClick = {
                        onAction(LessonScheduleIntent.ChangeToWeek)
                    }) {
                    Box(
                        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(commonR.string.week), style = TextStyle(
                                fontSize = 16.sp, lineHeight = 16.sp, fontWeight = FontWeight.W500, fontFamily = Montserrat
                            )
                        )
                    }
                }
            }
        }
        Spacer(Modifier.height(12.dp))
        if (state.lessons.isNotEmpty()) {
            if (state.isDay) {
                LessonComponent(
                    lessons = state.lessons, now = now, isNow = isNow, onClick = {})
            } else {
                LessonComponentWeek(
                    lessons = state.weeksLesson,
                    now = now,
                    times = state.times,
                    onClick = {})
            }

        } else {
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f), contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.size(130.dp), painter = painterResource(id = R.drawable.img_lesson_schedule_empty), contentDescription = "empty"
                )
            }
        }

    }
}


