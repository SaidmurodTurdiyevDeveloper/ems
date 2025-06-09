package uzb.smt.presenter.screens.chat_details

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uzb.smt.presenter.screens.chat_details.componion.ChatDetailsToolbar
import uzb.smt.presenter.screens.chat_details.componion.OtherMessage
import uzb.smt.presenter.screens.chat_details.componion.WriteChatMessage
import uzb.smt.presenter.screens.chat_details.componion.YourMessage
import uzb.smt.presenter.theme.WhiteScreenFourth


@Composable
internal fun ChatDetailsScreen(
    state: ChatDetailsState,
    onAction: (ChatDetailsIntent) -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        (context as ComponentActivity).enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                scrim = android.graphics.Color.TRANSPARENT,
                darkScrim = android.graphics.Color.TRANSPARENT
            )
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color =WhiteScreenFourth
            )
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        ChatDetailsToolbar(
            name = state.chatData?.name ?: "",
            back = { onAction(ChatDetailsIntent.Back) }
        )
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
            WriteChatMessage(
                modifier = Modifier.align(Alignment.BottomCenter),
                message = state.message,
                onChange = { onAction(ChatDetailsIntent.ChangeMessage(it)) },
                sendMessage = { onAction(ChatDetailsIntent.SendMessage) }
            )
        }
    }
}

@Preview
@Composable
private fun ChatDetailsScreenPrev() {
    ChatDetailsScreen(
        state = ChatDetailsState(),
        onAction = {}
    )
}

