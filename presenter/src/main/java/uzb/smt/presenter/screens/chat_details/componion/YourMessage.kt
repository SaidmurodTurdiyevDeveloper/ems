package uzb.smt.presenter.screens.chat_details.componion

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.domen.model.MessageData
import uzb.smt.domen.model.getMessageData
import uzb.smt.presenter.R
import uzb.smt.presenter.theme.Blue
import uzb.smt.presenter.theme.Montserrat

@Composable
internal fun YourMessage(
    modifier: Modifier = Modifier,
    message: MessageData
) {
    val width = (LocalConfiguration.current.screenWidthDp - 16) * 0.8f
    val time = message.date.split(" ")[1]
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Column(
            modifier = modifier
                .requiredWidthIn(max = width.dp)
                .background(
                    color = Blue,
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 20.dp)
                )
                .padding(start = 10.dp, top = 11.dp, end = 8.dp),
            horizontalAlignment = Alignment.End
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
            Row(
                modifier = Modifier.requiredHeightIn(min = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (message.seen) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_seen),
                        contentDescription = "avatar",
                        tint = Color.White,
                        modifier = Modifier
                            .size(16.dp)
                            .clip(CircleShape)
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
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

}

@Preview
@Composable
private fun YourMessagePrev() {
    Box(modifier = Modifier.fillMaxSize()) {
        YourMessage(
            message = getMessageData(isYour = true)
        )
    }
}