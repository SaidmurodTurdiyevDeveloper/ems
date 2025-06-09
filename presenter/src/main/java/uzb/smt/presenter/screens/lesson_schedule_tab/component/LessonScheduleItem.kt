package uzb.smt.presenter.screens.lesson_schedule_tab.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.domen.model.LessonScheduleData
import uzb.smt.presenter.R
import uzb.smt.presenter.theme.Montserrat
import kotlin.random.Random

@Composable
internal fun LessonScheduleItem(
    modifier: Modifier = Modifier, item: LessonScheduleData, onClick: (LessonScheduleData) -> Unit
) {
    val color = remember {
        Color(
            red = Random.Default.nextInt(256), green = Random.Default.nextInt(256), blue = Random.Default.nextInt(256)
        )
    }
    Card(
        modifier = modifier
            .height(100.dp)
            .fillMaxWidth(), colors = CardDefaults.cardColors(
            containerColor = Color.White
        ), elevation = CardDefaults.cardElevation(defaultElevation = 8.dp), shape = RoundedCornerShape(20.dp), onClick = {
            onClick(item)
        }) {
        Row(modifier = Modifier.fillMaxWidth()) {
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