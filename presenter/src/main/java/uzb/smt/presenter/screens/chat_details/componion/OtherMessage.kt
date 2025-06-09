package uzb.smt.presenter.screens.chat_details.componion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.domen.model.MessageData
import uzb.smt.domen.model.getMessageData
import uzb.smt.presenter.theme.Gray
import uzb.smt.presenter.theme.GrayBlue
import uzb.smt.presenter.theme.Montserrat

@Composable
internal fun OtherMessage(
    modifier: Modifier = Modifier,
    message: MessageData
) {
    val width = (LocalConfiguration.current.screenWidthDp - 16) * 0.8f
    val time = message.date.split(" ")[1]
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Bottom
    ) {
        Box(
            modifier = Modifier
                .size(27.dp)
                .background(
                    color = Gray, shape = CircleShape
                )
        )
        Spacer(modifier = Modifier.width(4.dp))
        Column(
            modifier = Modifier
                .requiredWidthIn(max = width.dp)
                .padding(bottom = 4.dp)
                .background(
                    color = GrayBlue.copy(0.85f),
                    shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomEnd = 20.dp
                    )
                )
                .padding(start = 8.dp, top = 11.dp, end = 12.dp, bottom = 4.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = message.text,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 13.sp,
                    color = Color.White,
                    fontWeight = FontWeight.W500,
                    fontFamily = Montserrat
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = time,
                style = TextStyle(
                    fontSize = 9.sp,
                    lineHeight = 10.sp,
                    color = Color.White.copy(0.6f),
                    fontWeight = FontWeight.W500,
                    fontFamily = Montserrat
                )
            )
        }
    }

}


@Preview
@Composable
private fun OtherMessagePrev() {
    OtherMessage(
        message = getMessageData(isYour = false)
    )
}