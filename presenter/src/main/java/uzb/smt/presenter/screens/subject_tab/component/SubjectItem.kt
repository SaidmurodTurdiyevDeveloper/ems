package uzb.smt.presenter.screens.subject_tab.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.common.R
import uzb.smt.domen.model.SubjectData
import uzb.smt.presenter.theme.Montserrat

@Composable
internal fun SubjectItem(
    modifier: Modifier = Modifier,
    subjectData: SubjectData
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(
            width = 1.dp,
            color = Color(0xFFD9D9D9)
        ),
        onClick = {},
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEBF1FF))
    ) {
        Column(
            modifier = Modifier
                .padding(top = 7.dp, start = 14.dp, bottom = 6.dp, end = 13.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = subjectData.name,
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            color = Color(0xFF000000),
                            fontWeight = FontWeight.W600,
                            fontFamily = Montserrat
                        )
                    )
                    Spacer(Modifier.height(6.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = (subjectData.absent * 100).toString() + "%",
                            style = TextStyle(
                                fontSize = 10.sp,
                                lineHeight = 11.sp,
                                color = Color(0xFF000000),
                                fontWeight = FontWeight.W600,
                                fontFamily = Montserrat
                            )
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.48f)
                                .height(10.dp)
                                .background(
                                    color = Color(0xFFD9D9D9),
                                    shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp)
                                )
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(subjectData.absent)
                                    .height(10.dp)
                                    .background(
                                        color = Color(0xFF1AC65C),
                                        shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp)
                                    )
                            )
                        }
                        Spacer(Modifier.width(10.dp))
                        Text(
                            text = stringResource(R.string.absent),
                            style = TextStyle(
                                fontSize = 10.sp,
                                lineHeight = 11.sp,
                                color = Color(0xFF000000),
                                fontWeight = FontWeight.W600,
                                fontFamily = Montserrat
                            )
                        )
                    }
                    Spacer(Modifier.height(6.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = (subjectData.learning * 100).toString() + "%",
                            style = TextStyle(
                                fontSize = 10.sp,
                                lineHeight = 11.sp,
                                color = Color(0xFF000000),
                                fontWeight = FontWeight.W600,
                                fontFamily = Montserrat
                            )
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.48f)
                                .height(10.dp)
                                .background(
                                    color = Color(0xFFD9D9D9),
                                    shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp)
                                )
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(subjectData.learning)
                                    .height(10.dp)
                                    .background(
                                        color = Color(0xFF1AC65C),
                                        shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp)
                                    )
                            )
                        }
                        Spacer(Modifier.width(10.dp))
                        Text(
                            text = stringResource(R.string.learning),
                            style = TextStyle(
                                fontSize = 10.sp,
                                lineHeight = 11.sp,
                                color = Color(0xFF000000),
                                fontWeight = FontWeight.W600,
                                fontFamily = Montserrat
                            )
                        )
                    }
                }
                Image(
                    modifier = Modifier.requiredSizeIn(minWidth = 60.dp, minHeight = 60.dp, maxHeight = 70.dp, maxWidth = 70.dp),
                    painter = painterResource(subjectData.logo),
                    contentDescription = "img subject"
                )
            }
            Spacer(Modifier.height(5.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = subjectData.firstTeacher,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        color = Color(0xFF000000),
                        fontWeight = FontWeight.W600,
                        fontFamily = Montserrat
                    )
                )
                Text(
                    text = subjectData.secondTeacher,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        color = Color(0xFF000000),
                        fontWeight = FontWeight.W600,
                        fontFamily = Montserrat
                    )
                )
            }
        }


    }
}