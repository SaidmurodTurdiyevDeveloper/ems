package uzb.smt.presenter.screens.chat_tab.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.domen.model.ChatData
import uzb.smt.domen.model.getEmptyChatData
import uzb.smt.presenter.R
import uzb.smt.presenter.theme.DarkBlue
import uzb.smt.presenter.theme.DarkPurple
import uzb.smt.presenter.theme.Gray
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.presenter.theme.Purple
import java.util.Calendar

@Composable
internal fun ChatItem(
    modifier: Modifier = Modifier,
    chatData: ChatData,
    isLast: Boolean,
    onAction: () -> Unit
) {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = chatData.lastMessageSeenDate
    val time = calendar.get(Calendar.HOUR_OF_DAY).toString() + ":" + calendar.get(Calendar.MINUTE).toString()
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = onAction,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ), elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 12.dp)
        ) {
            Row(
                modifier = Modifier.padding(vertical = 14.dp),
                verticalAlignment = Alignment.Top
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_avatar),
                    contentDescription = "avatar", modifier = Modifier
                        .size(46.dp)
                        .clip(CircleShape)
                )
                Spacer(
                    modifier = Modifier.width(10.dp)
                )
                Column(
                    modifier = Modifier
                        .requiredHeightIn(min = 45.dp)
                        .weight(1f), verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = chatData.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            color = DarkPurple,
                            fontWeight = FontWeight.W600,
                            fontFamily = Montserrat
                        )
                    )
                    Text(
                        text = chatData.description,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            color = DarkPurple.copy(0.6f),
                            fontWeight = FontWeight.W600,
                            fontFamily = Montserrat
                        )
                    )
                }
                if (chatData.lastMessageSeen) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_seen),
                        contentDescription = "arrow right",
                        tint = DarkBlue,
                        modifier = Modifier.padding(end = 10.dp)
                    )
                }

                Text(
                    text = time,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        color = Purple.copy(0.6f),
                        fontWeight = FontWeight.W600,
                        fontFamily = Montserrat
                    )
                )
            }
            if (!isLast) {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Gray
                )
            }
        }
    }
}

@Preview
@Composable
private fun ChatItemPrev() {
    ChatItem(
        chatData = getEmptyChatData(),
        isLast = true,
        onAction = {}
    )
}