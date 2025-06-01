package uzb.smt.presenter.screens.home_tab.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.domen.model.CurrentLesson
import uzb.smt.domen.model.getCurrentLesson
import uzb.smt.presenter.R
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.presenter.utils.calculateTimePercent

@Composable
internal fun CurrentLessonItem(
    modifier: Modifier = Modifier, item: CurrentLesson
) {
    Card(
        modifier = modifier, shape = RoundedCornerShape(21.dp), colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .requiredWidthIn(min = 161.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(), painter = painterResource(R.drawable.img_bg_subject_item), contentDescription = "img subject", contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0x991495FF), Color(0x80000000)
                            )
                        )
                    )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 14.dp, end = 14.dp)
            ) {
                Text(
                    modifier = Modifier.weight(1f), text = item.name, style = TextStyle(
                        fontSize = 20.sp, lineHeight = 22.sp, color = Color(0xFFFFFFFF), fontWeight = FontWeight.W600, fontFamily = Montserrat
                    )
                )
                Text(
                    modifier = Modifier
                        .background(color = Color(0xFF3BD576), shape = androidx.compose.foundation.shape.RoundedCornerShape(14.dp))
                        .padding(horizontal = 15.dp, vertical = 1.dp),
                    text = stringResource(uzb.smt.common.R.string.now),
                    style = TextStyle(
                        fontSize = 12.sp, lineHeight = 14.sp, color = Color(0xFFFFFFFF), fontWeight = FontWeight.W600, fontFamily = Montserrat
                    )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter), verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 14.dp, end = 14.dp), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.weight(1f), text = item.teacher, style = TextStyle(
                            fontSize = 12.sp, lineHeight = 14.sp, color = Color(0xFFFFFFFF), fontWeight = FontWeight.W600, fontFamily = Montserrat
                        )
                    )
                    Text(
                        text = stringResource(uzb.smt.common.R.string.room, item.room), style = TextStyle(
                            fontSize = 12.sp, lineHeight = 14.sp, color = Color(0xFFFFFFFF), fontWeight = FontWeight.W600, fontFamily = Montserrat
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, bottom = 12.dp, end = 8.dp), verticalAlignment = Alignment.Bottom
                ) {
                    Box(
                        modifier = Modifier
                            .requiredWidthIn(min = 210.dp)
                            .requiredHeightIn(min = 51.dp)
                            .clip(androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
                    ) {
                        Box(
                            modifier = Modifier
                                .matchParentSize()
                                .blur(20.dp)
                                .background(Color.White.copy(alpha = 0.3f))
                        )
                        Column(
                            modifier = Modifier
                                .matchParentSize()
                                .padding(vertical = 7.5.dp, horizontal = 13.dp), verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    modifier = Modifier, text = item.startTime, maxLines = 1, style = TextStyle(
                                        fontSize = 16.sp, lineHeight = 18.sp, color = Color(0xFFFFFFFF), fontWeight = FontWeight.W500, fontFamily = Montserrat
                                    )
                                )
                                Spacer(Modifier.weight(5f))
                                repeat(16) {
                                    Icon(
                                        modifier = Modifier.size(4.dp), painter = painterResource(R.drawable.ic_dot), contentDescription = "dot", tint = Color(0xFFD9D9D9)
                                    )
                                    Spacer(Modifier.weight(2f))
                                }
                                Spacer(Modifier.weight(3f))
                                Text(
                                    modifier = Modifier, text = item.endTime, maxLines = 1, style = TextStyle(
                                        fontSize = 16.sp, lineHeight = 18.sp, color = Color(0xFFFFFFFF), fontWeight = FontWeight.W500, fontFamily = Montserrat
                                    )
                                )
                            }
                            Box(
                                Modifier
                                    .width(184.dp)
                                    .height(8.dp)
                                    .clip(androidx.compose.foundation.shape.RoundedCornerShape(10.dp))
                                    .background(Color(0xFFD9D9D9))
                                    .padding(1.dp)
                            ) {
                                val percent = calculateTimePercent(item.startTime, item.endTime)
                                Box(
                                    Modifier
                                        .fillMaxWidth(1 - percent)
                                        .height(6.dp)
                                        .clip(androidx.compose.foundation.shape.RoundedCornerShape(10.dp))
                                        .background(
                                            brush = Brush.linearGradient(listOf(Color(0xFFE2FFED), Color(0xFF3BD576)))
                                        )
                                )
                            }
                        }
                    }
                    Spacer(Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .width(142.dp)
                            .height(54.dp)
                            .clip(androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
                    ) {
                        Box(
                            modifier = Modifier
                                .matchParentSize()
                                .blur(20.dp)
                                .background(Color.White.copy(alpha = 0.3f))
                        )
                        Column(
                            modifier = Modifier
                                .border(1.dp, Color(0xFFD9D9D9), androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
                                .padding(horizontal = 7.dp, vertical = 6.dp),
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.Top
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_send_up), contentDescription = "Calendar", tint = Color(0xFF1495FF), modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = stringResource(uzb.smt.common.R.string.next_lesson, item.nextLesson), style = TextStyle(
                                        fontSize = 10.sp, lineHeight = 12.sp, color = Color(0xFFFFFFFF), fontWeight = FontWeight.W600, fontFamily = Montserrat
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = item.nextLessonStartTime, style = TextStyle(
                                        fontSize = 16.sp, lineHeight = 18.sp, color = Color(0xFFFFFFFF), fontWeight = FontWeight.W600, fontFamily = Montserrat
                                    )
                                )
                                Text(
                                    text = item.nextLessonEndTime, style = TextStyle(
                                        fontSize = 16.sp, lineHeight = 18.sp, color = Color(0xFFFFFFFF), fontWeight = FontWeight.W600, fontFamily = Montserrat
                                    )
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}

@Preview
@Composable
private fun SubjectItemPrev() {
    CurrentLessonItem(
        modifier = Modifier
            .fillMaxWidth()
            .requiredWidthIn(min = 161.dp),
        item = getCurrentLesson()
    )
}