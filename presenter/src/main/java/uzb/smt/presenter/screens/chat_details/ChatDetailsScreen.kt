package uzb.smt.presenter.screens.chat_details

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import uzb.smt.presenter.theme.Montserrat


@Composable
internal fun ChatDetailsScreen(
    state: ChatDetailsState,
    onAction: (ChatDetailsIntent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_avatar),
                contentDescription = "avatar",
                modifier = Modifier
                    .size(46.dp)
                    .clip(CircleShape)
            )
            Spacer(
                modifier = Modifier.width(8.dp)
            )
            Text(
                text = state.chatData?.name ?: "",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 22.sp,
                    color = Color(0xFF1F2937),
                    fontWeight = FontWeight.W600,
                    fontFamily = Montserrat
                )
            )
            Spacer(Modifier.weight(1f))
            IconButton(
                modifier = Modifier.size(30.dp),
                onClick = {
                    onAction(ChatDetailsIntent.Back)
                }
            ) {
                Icon(
                    modifier = Modifier.size(22.dp),
                    imageVector = Icons.Default.Close,
                    contentDescription = "close",
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(vertical = 20.dp, horizontal = 8.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(
                    items = state.messages
                ) {
                    if (it.isYour) {
                        YourMessage(message = it)
                    } else {
                        OtherMessage(message = it)
                    }
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.navigationBars)
                    .padding(horizontal = 8.dp, vertical = 16.dp)
                    .height(54.dp)
                    .align(Alignment.BottomCenter),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(26.dp)
            ) {


                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxSize(),
                    value = state.message,
                    onValueChange = {
                        onAction(ChatDetailsIntent.ChangeMessage(it))
                    },
                    shape = RoundedCornerShape(26.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Transparent
                    ),
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 14.sp,
                        color = Color(0xFF3A405A),
                        fontWeight = FontWeight.W500,
                        fontFamily = Montserrat
                    ),
                    leadingIcon = {
                        IconButton(
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .size(30.dp),
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_sticker),
                                contentDescription = "smile",
                                tint = Color(0xFF00226B)
                            )
                        }
                    },
                    trailingIcon = {
                        Row(modifier = Modifier.padding(end = 16.dp)) {
                            AnimatedVisibility(
                                visible = state.message.isEmpty(),
                                enter = fadeIn(),
                                exit = fadeOut()
                            ) {
                                Row {
                                    IconButton(
                                        modifier = Modifier.size(30.dp),
                                        onClick = {}
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_file),
                                            contentDescription = "files",
                                            tint = Color(0xFF00226B)
                                        )
                                    }
                                    Spacer(Modifier.width(7.dp))
                                    IconButton(
                                        modifier = Modifier.size(30.dp),
                                        onClick = {}
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_micraphone),
                                            contentDescription = "record",
                                            tint = Color(0xFF00226B)
                                        )
                                    }
                                }
                            }
                            AnimatedVisibility(
                                visible = state.message.isNotEmpty(),
                                enter = fadeIn(),
                                exit = fadeOut()
                            ) {
                                IconButton(
                                    modifier = Modifier.size(30.dp),
                                    onClick = {
                                        onAction(ChatDetailsIntent.SendMessage)
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_send),
                                        contentDescription = "ic_send",
                                        tint = Color(0xFF3E7BFF)
                                    )
                                }
                            }

                        }
                    },
                    placeholder = {
                        Text(
                            text = "Xabar yuborish",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 14.sp,
                                color = Color(0x803A405A),
                                fontWeight = FontWeight.W500,
                                fontFamily = Montserrat
                            )
                        )
                    },
                    singleLine = false
                )
            }

        }

    }
}

@Composable
private fun YourMessage(
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
                    color = Color(0xFF0077FF),
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
                    color = Color(0xFFFFFFFF),
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
                        tint = Color(0xFFFFFFFF),
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
                        color = Color(0xFFFFFFFF),
                        fontWeight = FontWeight.W500,
                        fontFamily = Montserrat
                    )
                )
            }
        }
    }

}

@Composable
private fun OtherMessage(
    modifier: Modifier = Modifier,
    message: MessageData
) {
    val width = (LocalConfiguration.current.screenWidthDp - 16) * 0.8f
    val time = message.date.split(" ")[1]
    Column(
        modifier = modifier
            .requiredWidthIn(max = width.dp)
            .background(
                color = Color(0xD969879F),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomEnd = 20.dp)
            )
            .padding(start = 8.dp, top = 11.dp, end = 12.dp, bottom = 4.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = message.text,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 13.sp,
                color = Color(0xFFFFFFFF),
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
                color = Color(0xFFFFFFFF),
                fontWeight = FontWeight.W500,
                fontFamily = Montserrat
            )
        )
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

@Preview
@Composable
private fun OtherMessagePrev() {

    OtherMessage(
        message = getMessageData(isYour = false)
    )
}