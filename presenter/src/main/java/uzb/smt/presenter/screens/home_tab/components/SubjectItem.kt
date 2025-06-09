package uzb.smt.presenter.screens.home_tab.components

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.domen.model.SubjectScoreData
import uzb.smt.domen.model.getEmptySubjectScoreData
import uzb.smt.domen.validator.DateUtil
import uzb.smt.presenter.R
import uzb.smt.presenter.theme.BlackText
import uzb.smt.presenter.theme.Gray
import uzb.smt.presenter.theme.GrayThird
import uzb.smt.presenter.theme.LightGreen
import uzb.smt.presenter.theme.LightOrange
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.common.R as commonR

@Composable
internal fun SubjectItem(
    modifier: Modifier = Modifier,
    subjectScoreData: SubjectScoreData,
    onAction: () -> Unit
) {
    val context = LocalContext.current
    val untilTime = DateUtil.getUntilTimeCount(context, subjectScoreData.lastScoreDate)
    val lasWatchMonth = DateUtil.getMonthDate(context, subjectScoreData.lastScoreDate)
    val color = if (subjectScoreData.score > 4) LightGreen else LightOrange
    Card(
        modifier = modifier,
        border = BorderStroke(1.dp, GrayThird.copy(0.18f)),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        onClick = onAction
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
                        color = BlackText,
                        fontWeight = FontWeight.W700,
                        fontFamily = Montserrat
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier
                        .background(
                            color = Gray,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(vertical = 3.5.dp, horizontal = 6.dp),
                    text = untilTime,
                    style = TextStyle(
                        fontSize = 9.sp,
                        lineHeight = 10.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.W500,
                        fontFamily = Montserrat
                    )
                )
            }
            Spacer(Modifier.height(4.dp))
            Row(modifier = Modifier.requiredWidthIn(min = 200.dp)) {
                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgress(
                        score = subjectScoreData.score,
                        percent = subjectScoreData.percent,
                        color = color
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Box(
                        modifier = Modifier
                            .background(
                                color = Gray,
                                shape = RoundedCornerShape(8.dp)
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
                                color = Color.Black,
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
                            text = if (subjectScoreData.changeScore > 0) stringResource(commonR.string.score_increase, subjectScoreData.changeScore)
                            else stringResource(commonR.string.score_decrease, subjectScoreData.changeScore),
                            style = TextStyle(
                                fontSize = 10.sp,
                                lineHeight = 12.sp,
                                color = color,
                                fontFamily = Montserrat,
                                fontWeight = FontWeight.W600
                            )
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Icon(
                            painter = painterResource(if (subjectScoreData.changeScore > 0) R.drawable.ic_score_up else R.drawable.ic_score_down),
                            contentDescription = "icon up",
                            tint = color
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Box(
                            modifier = Modifier
                                .height(32.dp)
                                .background(
                                    color = color,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(horizontal = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = subjectScoreData.lastScores.firstOrNull()?.toString() ?: "-",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 16.sp,
                                    color = Color.White,
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
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(horizontal = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = subjectScoreData.lastScores.getOrNull(1)?.toString() ?: "-",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 16.sp,
                                    color = Color.White,
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
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(horizontal = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = subjectScoreData.lastScores.getOrNull(2)?.toString() ?: "-",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 16.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.W600,
                                    fontFamily = Montserrat
                                )
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        text = subjectScoreData.description,
                        color = Color.Black.copy(0.6f),
                        textAlign = TextAlign.Center,
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

@Preview
@Composable
private fun SubjectItemPrev() {
    SubjectItem(
        modifier = Modifier
            .fillMaxWidth()
            .requiredWidthIn(min = 161.dp),
        subjectScoreData = getEmptySubjectScoreData()
    ) {}
}