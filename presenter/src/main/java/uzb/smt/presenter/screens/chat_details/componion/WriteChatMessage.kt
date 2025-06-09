package uzb.smt.presenter.screens.chat_details.componion

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uzb.smt.presenter.R
import uzb.smt.presenter.theme.BlueSecond
import uzb.smt.presenter.theme.DarkBlue
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.presenter.theme.Purple

@Composable
internal fun WriteChatMessage(
    modifier: Modifier = Modifier,
    message: String,
    onChange: (String) -> Unit,
    sendMessage: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.navigationBars)
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .requiredHeightIn(min = 54.dp, max = 64.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(26.dp)
    ) {


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = message,
            onValueChange = onChange,
            shape = androidx.compose.foundation.shape.RoundedCornerShape(26.dp),
            colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = Color.Transparent),
            textStyle = TextStyle(
                fontSize = 14.sp,
                lineHeight = 14.sp,
                color = Purple,
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
                        tint = DarkBlue
                    )
                }
            },
            trailingIcon = {
                Row(modifier = Modifier.padding(end = 16.dp)) {
                    AnimatedVisibility(
                        visible = message.isEmpty(),
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
                                    tint = DarkBlue
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
                                    tint = DarkBlue
                                )
                            }
                        }
                    }
                    AnimatedVisibility(
                        visible = message.isNotEmpty(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(
                            modifier = Modifier.size(30.dp),
                            onClick = sendMessage
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_send),
                                contentDescription = "ic_send",
                                tint = BlueSecond
                            )
                        }
                    }

                }
            },
            placeholder = {
                Text(
                    text = stringResource(uzb.smt.common.R.string.send_message),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 14.sp,
                        color = Purple,
                        fontWeight = FontWeight.W500,
                        fontFamily = Montserrat
                    )
                )
            },
            singleLine = false
        )
    }
}

@Preview
@Composable
private fun WriteChatMessagePrev() {
    WriteChatMessage(
        message = "",
        onChange = {},
        sendMessage = {}
    )
}