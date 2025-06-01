package uzb.smt.presenter.screens.home_tab.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.common.R as commonR
import uzb.smt.presenter.R
import uzb.smt.domen.model.SubjectScoreData
import uzb.smt.domen.model.getEmptySubjectScoreData
import uzb.smt.presenter.theme.Gray
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.presenter.utils.getMonthDate
import uzb.smt.presenter.utils.getUntilTimeCount

@Composable
internal fun SubjectItem(
    modifier: Modifier = Modifier,
    subjectScoreData: SubjectScoreData
) {
    val context = LocalContext.current
    val untilTime = context.getUntilTimeCount(subjectScoreData.lastScoreDate)
    val lasWatchMonth = context.getMonthDate(subjectScoreData.lastScoreDate)
    val color = if(subjectScoreData.score>4)Color(0xFF3BD576) else Color(0xFFE58A60)
    Card(
        border = BorderStroke(1.dp, Gray),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = modifier,
        onClick = {}
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            Row(
                modifier = Modifier
                    .requiredWidthIn(min = 200.dp)
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = subjectScoreData.name,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        color = Color(0xFF333438),
                        fontWeight = FontWeight.W700,
                        fontFamily = Montserrat
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier
                        .background(
                            color = Gray,
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                        )
                        .padding(vertical = 3.5.dp, horizontal = 6.dp),
                    text = untilTime,
                    style = TextStyle(
                        fontSize = 9.sp,
                        lineHeight = 10.sp,
                        color = Color(0xFF000000),
                        fontWeight = FontWeight.W500,
                        fontFamily = Montserrat
                    )
                )
            }
            Spacer(Modifier.height(4.dp))
            Row(modifier = Modifier.requiredWidthIn(min = 200.dp)) {
                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                    SubjectLearningTabCircularProgress(
                        modifier = Modifier,
                        score = subjectScoreData.score,
                        percent = subjectScoreData.percent,
                        color = color
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Box(
                        modifier = Modifier
                            .background(
                                color = Gray,
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                            )
                            .height(19.dp)
                            .width(71.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = lasWatchMonth,
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 12.sp,
                                color = Color(0xFF000000),
                                fontWeight = FontWeight.W500,
                                fontFamily = Montserrat
                            )
                        )
                    }

                }
                Spacer(modifier = Modifier.width(12.dp))
                Column(
                    modifier = Modifier.requiredWidthIn(min = 101.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        Text(
                            text = if (subjectScoreData.changeScore > 0) stringResource(commonR.string.score_increase, subjectScoreData.changeScore) else
                                stringResource(commonR.string.score_decrease, subjectScoreData.changeScore),
                            style = TextStyle(
                                fontSize = 10.sp,
                                lineHeight = 12.sp,
                                color = color,
                                fontFamily = Montserrat,
                                fontWeight = FontWeight.W600
                            )
                        )
                        Spacer(
                            modifier = Modifier
                                .width(6.dp)
                        )
                        Icon(
                            painter = painterResource(
                                if (subjectScoreData.changeScore > 0) R.drawable.ic_score_up else R.drawable.ic_score_down
                            ),
                            contentDescription = "icon up",
                            tint = color
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .height(6.dp)
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Box(
                            modifier = Modifier
                                .height(32.dp)
                                .background(
                                    color = color,
                                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                                )
                                .padding(horizontal = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = subjectScoreData.lastScores.firstOrNull()?.toString() ?: "-",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 16.sp,
                                    color = Color(0xFFFFFFFF),
                                    fontWeight = FontWeight.W600,
                                    fontFamily = Montserrat
                                )
                            )
                        }
                        Box(
                            modifier = Modifier
                                .height(32.dp)
                                .background(
                                    color = color,
                                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                                )
                                .padding(horizontal = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = subjectScoreData.lastScores.getOrNull(1)?.toString() ?: "-",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 16.sp,
                                    color = Color(0xFFFFFFFF),
                                    fontWeight = FontWeight.W600,
                                    fontFamily = Montserrat
                                )
                            )
                        }
                        Box(
                            modifier = Modifier
                                .height(32.dp)
                                .background(
                                    color = color,
                                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                                )
                                .padding(horizontal = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = subjectScoreData.lastScores.getOrNull(2)?.toString() ?: "-",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 16.sp,
                                    color = Color(0xFFFFFFFF),
                                    fontWeight = FontWeight.W600,
                                    fontFamily = Montserrat
                                )
                            )
                        }
                    }
                    Spacer(
                        modifier = Modifier
                            .height(6.dp)
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        text = subjectScoreData.description,
                        color = Color(0xCC000000),
                        style = TextStyle(
                            fontSize = 10.sp,
                            lineHeight = 12.sp,
                            fontFamily = Montserrat,
                            fontWeight = FontWeight.W500
                        )
                    )
                }
            }
        }
    }

}

@Composable
internal fun SubjectLearningTabCircularProgress(
    modifier: Modifier = Modifier,
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
        contentAlignment = Alignment.Center,
        modifier = modifier.size(56.dp)
    ) {
        Canvas(modifier = Modifier.size(56.dp)) {
            drawArc(
                color = Gray,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(8.dp.toPx(), cap = StrokeCap.Round)
            )

            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360f * animatedPercentage,
                useCenter = false,
                style = Stroke(8.dp.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = score.toString(),
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = color,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.W700,
                fontFamily = Montserrat
            )
        )
    }
}

@Preview
@Composable
private fun SubjectItemPrev() {
    SubjectItem(
        modifier = Modifier
            .fillMaxWidth()
            .requiredWidthIn(min = 161.dp),
        subjectScoreData = getEmptySubjectScoreData()
    )
}