package uzb.smt.presenter.screens.subject_details

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.domen.model.TaskData
import uzb.smt.domen.model.TeacherData
import uzb.smt.domen.model.getTaskDataList
import uzb.smt.domen.model.getTeacherList
import uzb.smt.presenter.R
import uzb.smt.presenter.theme.Montserrat
import java.util.Calendar
import uzb.smt.common.R as commonR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SubjectDetailsScreen(
    state: SubjectDetailsState,
    onAction: (SubjectDetailsIntent) -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        (context as ComponentActivity).enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                scrim = android.graphics.Color.TRANSPARENT
            )
        )
    }
    Scaffold(
        contentWindowInsets = WindowInsets(0),
        topBar = {
            SubjectToolBar(
                name = state.subjectData?.name ?: "",
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(

                onClick = {

                },
                modifier = Modifier
                    .windowInsetsPadding(WindowInsets.navigationBars)
                    .border(
                        color = Color.White,
                        shape = RoundedCornerShape(25.dp),
                        width = 1.dp
                    ),
                shape = RoundedCornerShape(25.dp),
                containerColor = Color(0xFF00226B)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(commonR.string.resurs),
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            color = Color(0xFFFFFFFF),
                            fontWeight = FontWeight.W500,
                            fontFamily = Montserrat
                        )
                    )
                    Spacer(Modifier.width(5.dp))
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .background(
                                color = Color.White,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_resurce),
                            contentDescription = "icon resurse",
                            tint = Color(0xFF00226B)
                        )
                    }
                }
            }
        }) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-25).dp)
                .background(color = Color(0xFFDFDfE7))
                .padding(innerPadding)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(colors = listOf(Color(0xFF00226B), Color.Transparent))
                    )
                    .height(150.dp)
            )
            ScrollContent(
                modifier = Modifier.fillMaxSize(),
                state = state,
            )
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SubjectToolBar(
    modifier: Modifier = Modifier,
    name: String
) {

    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(275.dp)
                .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)),
            painter = painterResource(R.drawable.img_math),
            contentScale = ContentScale.Crop,
            contentDescription = "image"
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp, horizontal = 8.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            ToolBarItem(
                modifier = Modifier.weight(1f),
                icon = painterResource(R.drawable.ic_rating),
                text = stringResource(commonR.string.rating)
            ) {

            }
            ToolBarItem(
                modifier = Modifier.weight(1f),
                icon = painterResource(R.drawable.ic_check_lesson),
                text = stringResource(commonR.string.lesson_absent)
            ) {

            }
            ToolBarItem(
                modifier = Modifier.weight(1f),
                icon = painterResource(R.drawable.ic_chat_tab_on),
                text = stringResource(commonR.string.subject_chat)
            ) {

            }
            ToolBarItem(
                modifier = Modifier.weight(1f),
                icon = painterResource(R.drawable.ic_calculator),
                text = stringResource(commonR.string.calculator)
            ) {

            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsPadding(WindowInsets.statusBars)
                .align(Alignment.TopCenter)
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .border(1.dp, Color.White.copy(0.7f), shape = CircleShape)
                    .clip(CircleShape)
                    .clickable(
                        onClick = {},
                        indication = ripple(),
                        interactionSource = remember { MutableInteractionSource() }
                    )
                    .background(color = Color(0x5CFFFFFF)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "icBack",
                    tint = Color(0xFFFFFFFF)
                )
            }

        }
    }


}

@Composable
internal fun ToolBarItem(
    modifier: Modifier = Modifier,
    icon: Painter,
    text: String,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(15.dp))
            .clickable(
                indication = ripple(),
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick
            )
            .background(
                color = Color(0x94FFFFFF),
                shape = RoundedCornerShape(15.dp)
            )
            .height(82.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(47.dp),
            painter = icon,
            tint = Color.White,
            contentDescription = text
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = text,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 12.sp,
                color = Color(0xFFFFFFFF),
                fontWeight = FontWeight.W600,
                fontFamily = Montserrat
            )
        )
    }
}

@Composable
private fun ScrollContent(
    modifier: Modifier = Modifier,
    state: SubjectDetailsState
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(top = 40.dp, bottom = 100.dp)
    ) {
        item(key = "title") {
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = state.subjectData?.name ?: "Matematika",
                style = TextStyle(
                    fontSize = 30.sp,
                    lineHeight = 30.sp,
                    color = Color(0xFFFFFFFF),
                    fontWeight = FontWeight.W700,
                    fontFamily = Montserrat
                )
            )
        }
        item(key = "teachers") {
            TeacherContent(
                color = Color(0xFF00226B),
                teacher = getTeacherList()
            )
        }
        item(key = "task title") {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(commonR.string.tasks),
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Color(0xFF1F2937),
                        fontFamily = Montserrat,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.W600
                    )
                )
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_filter),
                        tint = Color(0xFF1F2937),
                        contentDescription = ""
                    )
                }
            }
        }
        items(items = getTaskDataList()) {
            TaskItem(
                modifier = Modifier.padding(horizontal = 8.dp),
                task = it
            )
        }
    }
}

@Composable
internal fun TeacherContent(
    modifier: Modifier = Modifier,
    color: Color,
    teacher: List<TeacherData>
) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .background(
                color = Color(0x632E1461),
                shape = RoundedCornerShape(12.dp)
            )
            .border(1.dp, color = Color.White, shape = RoundedCornerShape(12.dp))
            .padding(top = 6.dp, start = 9.dp, end = 7.dp, bottom = 7.dp)
    ) {
        teacher.forEachIndexed { index, item ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = item.workingType,
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.White.copy(0.6f),
                            fontFamily = Montserrat,
                            lineHeight = 12.sp,
                            fontWeight = FontWeight.W600
                        )
                    )
                    Text(
                        text = item.name,
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.White,
                            fontFamily = Montserrat,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight.W600
                        )
                    )
                }
                Card(
                    modifier = Modifier
                        .height(42.dp),
                    onClick = {},
                    colors = CardDefaults.cardColors(
                        containerColor = color,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .height(42.dp)
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(16.dp),
                            painter = painterResource(R.drawable.ic_chat_tab_on),
                            contentDescription = "icon",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = stringResource(commonR.string.connect),
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White,
                                fontFamily = Montserrat,
                                lineHeight = 14.sp,
                                fontWeight = FontWeight.W600
                            )
                        )
                    }

                }
            }
            if (index != teacher.lastIndex) {
                Spacer(modifier = Modifier.height(10.dp))
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 6.dp, end = 8.dp),
                    thickness = 1.dp, color = Color.White
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
internal fun TaskItem(
    modifier: Modifier = Modifier,
    task: TaskData
) {
    val context = LocalContext.current
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Box(
                Modifier
                    .align(Alignment.TopEnd)
                    .background(
                        color = if (task.isFinished) Color(0xFFD3FFE0) else Color(0xFFFFD3CF),
                        shape = RoundedCornerShape(
                            topEnd = 14.dp,
                            bottomStart = 14.dp
                        )
                    )
                    .requiredWidthIn(min = 115.dp)
                    .height(30.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = if (task.isFinished) stringResource(commonR.string.scored) else getFinishingTime(context = context, lastDate = task.finishingTime),
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = if (task.isFinished) Color(0xFF1AC65C) else Color(0xFFFF0000),
                        fontFamily = Montserrat,
                        lineHeight = 12.sp,
                        fontWeight = FontWeight.W700
                    )
                )
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.padding(top = 13.dp, start = 14.dp)) {
                    Icon(
                        painter = painterResource(R.drawable.ic_task),
                        contentDescription = "icon task",
                        tint = Color(0xFF1F2937)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = task.title,
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color(0xFF1F2937),
                            fontFamily = Montserrat,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight.W700
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, bottom = 10.dp, top = 8.dp)
                ) {
                    Box(
                        Modifier
                            .border(
                                1.dp,
                                color = Color(0xFFD9D9D9),
                                shape = RoundedCornerShape(14.dp)
                            )
                            .fillMaxWidth(0.75f)
                            .requiredHeightIn(min = 55.dp)
                            .padding(vertical = 10.dp, horizontal = 8.dp)
                    ) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color(0x99000000),
                                        fontFamily = Montserrat,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.W700
                                    )
                                ) {
                                    append(stringResource(commonR.string.task_descriptions))
                                }
                                append(task.description)
                            },
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color(0x99000000),
                                fontFamily = Montserrat,
                                lineHeight = 14.sp,
                                fontWeight = FontWeight.W400
                            )
                        )
                    }
                    Box(
                        Modifier
                            .weight(1f)
                            .requiredWidthIn(min = 55.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .border(
                                    1.dp,
                                    color = if (task.score.toInt() == 5) Color(0xFF1AC65C) else Color(0xFF3A405A),
                                    shape = RoundedCornerShape(12.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = task.score.toString(),
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    color = if (task.score.toInt() == 5) Color(0xFF1AC65C) else Color(0xFF3A405A),
                                    fontFamily = Montserrat,
                                    lineHeight = 20.sp,
                                    fontWeight = FontWeight.W700
                                )
                            )
                        }
                    }
                }
                if (!task.isFinished) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, bottom = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedButton(
                            onClick = { },
                            modifier = Modifier
                                .weight(1f)
                                .height(42.dp),
                            shape = RoundedCornerShape(10.dp),
                            border = BorderStroke(1.dp, color = Color(0xFF00226B)),
                            colors = ButtonDefaults.outlinedButtonColors(
                                containerColor = Color.White,
                                contentColor = Color(0xFF00226B)
                            )
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_task_),
                                contentDescription = "icon skip",
                                tint = Color(0xFF00226B)
                            )
                            Spacer(Modifier.width(5.dp))
                            Text(
                                text = task.title,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    color = Color(0xFF00226B),
                                    fontFamily = Montserrat,
                                    lineHeight = 16.sp,
                                    fontWeight = FontWeight.W600
                                )
                            )
                        }
                        Button(
                            onClick = { },
                            modifier = Modifier
                                .weight(1f)
                                .height(42.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF00226B),
                                contentColor = Color.White
                            )
                        ) {

                            Icon(
                                painter = painterResource(R.drawable.ic_upload_file),
                                contentDescription = "icon skip",
                                tint = Color.White
                            )
                            Spacer(Modifier.width(5.dp))
                            Text(
                                text = stringResource(commonR.string.task_upload),
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    color = Color.White,
                                    fontFamily = Montserrat,
                                    lineHeight = 16.sp,
                                    fontWeight = FontWeight.W600
                                )
                            )
                        }

                    }
                }
            }
        }
    }
}

fun getFinishingTime(context: Context, lastDate: String): String {
    val calendar = Calendar.getInstance()
    val temp = lastDate.split(" ")
    val dates = temp[0].split("-")
    val times = temp[1].split(":")
    if (calendar.get(Calendar.YEAR) <= Integer.parseInt(dates[0])) {
        if (calendar.get(Calendar.MONTH) <= Integer.parseInt(dates[1])) {
            if (calendar.get(Calendar.DAY_OF_MONTH) < Integer.parseInt(dates[2])) {
                val dayCount = Integer.parseInt(dates[2]) - calendar.get(Calendar.DAY_OF_MONTH)
                return context.getString(commonR.string.days_left, dayCount)
            } else if (calendar.get(Calendar.DAY_OF_MONTH) == Integer.parseInt(dates[2])) {
                if (calendar.get(Calendar.HOUR_OF_DAY) < Integer.parseInt(times[0])) {
                    val hoursCount = Integer.parseInt(times[1]) - calendar.get(Calendar.HOUR_OF_DAY)
                    return context.getString(commonR.string.hourss_left, hoursCount)
                } else if (calendar.get(Calendar.HOUR_OF_DAY) == Integer.parseInt(times[0])) {
                    if (calendar.get(Calendar.MINUTE) < Integer.parseInt(times[1])) {
                        val minutesCount = Integer.parseInt(times[1]) - calendar.get(Calendar.MINUTE)
                        return context.getString(commonR.string.minutes_left, minutesCount)
                    }
                }
            }
        }
    }
    return context.getString(commonR.string.finished)
}