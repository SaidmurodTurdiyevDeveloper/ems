package uzb.smt.presenter.screens.home_tab.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.domen.model.TaskData
import uzb.smt.domen.model.getEmptyTaskData
import uzb.smt.presenter.R
import uzb.smt.presenter.theme.BlackText
import uzb.smt.presenter.theme.DarkPurple
import uzb.smt.presenter.theme.GraySecond
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.presenter.theme.OrangeSecond
import uzb.smt.presenter.theme.OrangeThird

@Composable
internal fun SubjectTaskItem(
    modifier: Modifier = Modifier,
    task: TaskData,
    onClick: () -> Unit,
    onDone: () -> Unit
) {
    val time = task.finishingTime.split(" ").getOrNull(1) ?: ""
    Card(
        modifier = modifier
            .width(219.dp)
            .requiredHeightIn(min = 135.dp),
        border = BorderStroke(1.dp, GraySecond),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp)
            ) {
                Text(
                    text = task.subject,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        color = BlackText,
                        fontWeight = FontWeight.W700,
                        fontFamily = Montserrat
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_time_outline),
                        contentDescription = "ic_time_outline",
                        tint = OrangeSecond,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.size(5.dp))
                    Text(
                        text = stringResource(uzb.smt.common.R.string.until_time, time),
                        style = TextStyle(
                            fontSize = 10.sp,
                            lineHeight = 10.sp,
                            color = DarkPurple,
                            fontWeight = FontWeight.W500,
                            fontFamily = Montserrat
                        )
                    )
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 4.dp),
            ) {
                Column {
                    Text(
                        text = stringResource(uzb.smt.common.R.string.task_descriptions),
                        style = TextStyle(
                            fontSize = 10.sp,
                            lineHeight = 11.sp,
                            color = Color.Black.copy(0.6f),
                            fontWeight = FontWeight.W700,
                            fontFamily = Montserrat
                        )
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_math_task),
                        contentDescription = "ic_task_logo",
                        modifier = Modifier.size(34.dp)
                    )
                }
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = task.description,
                    style = TextStyle(
                        fontSize = 10.sp,
                        lineHeight = 11.sp,
                        color = DarkPurple,
                        fontWeight = FontWeight.W400,
                        fontFamily = Montserrat
                    )
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_time_task),
                        contentDescription = "ic_task_time",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = stringResource(uzb.smt.common.R.string.duration),
                        style = TextStyle(
                            fontSize = 10.sp,
                            lineHeight = 11.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.W400,
                            fontFamily = Montserrat
                        )
                    )
                }
                Button(
                    modifier = Modifier.height(29.dp),
                    onClick = onDone,
                    shape = RoundedCornerShape(7.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = OrangeThird.copy(0.6f),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = stringResource(uzb.smt.common.R.string.done),
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 13.sp,
                            color = Color.White,
                            fontWeight = FontWeight.W600,
                            fontFamily = Montserrat
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun SubjectTaskItemPrev() {
    SubjectTaskItem(
        task = getEmptyTaskData(),
        onClick = {},
        onDone = {}
    )
}