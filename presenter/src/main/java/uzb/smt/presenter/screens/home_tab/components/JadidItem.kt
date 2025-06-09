package uzb.smt.presenter.screens.home_tab.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.domen.model.JadidData
import uzb.smt.presenter.R
import uzb.smt.presenter.theme.BlackText
import uzb.smt.presenter.theme.Blue
import uzb.smt.presenter.theme.GrayThird
import uzb.smt.presenter.theme.Montserrat

@Composable
internal fun JadidItem(
    modifier: Modifier = Modifier,
    item: JadidData,
    onAction: () -> Unit
) {
    Card(
        modifier = modifier,
        border = BorderStroke(1.dp, GrayThird.copy(0.18f)),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        onClick = onAction
    ) {
        Row(
            modifier = Modifier
                .width(224.dp)
                .height(137.dp)
                .padding(top = 4.dp, bottom = 4.dp, end = 2.dp, start = 8.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = item.name,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 10.sp,
                        lineHeight = 10.sp,
                        color = BlackText,
                        fontWeight = FontWeight.W600,
                        fontFamily = Montserrat
                    )
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = item.info,
                    style = TextStyle(
                        fontSize = 10.sp,
                        lineHeight = 10.sp,
                        color = BlackText,
                        fontWeight = FontWeight.W400,
                        fontFamily = Montserrat
                    )
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.img_avatar),
                    contentDescription = "image jadids",
                    modifier = Modifier
                        .width(78.dp)
                        .height(94.dp)
                        .clip(androidx.compose.foundation.shape.RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.height(4.dp))
                TextButton(
                    modifier = Modifier
                        .width(97.dp)
                        .height(28.dp),
                    onClick = {}
                ) {
                    Text(
                        text = stringResource(uzb.smt.common.R.string.in_detail),
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 15.sp,
                            color = Blue,
                            fontWeight = FontWeight.W600,
                            fontFamily = Montserrat
                        )
                    )
                }
            }
        }
    }
}