package uzb.smt.presenter.screens.chat_tab.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uzb.smt.domen.model.ChatData
import uzb.smt.domen.model.getEmptyChatData
import uzb.smt.presenter.screens.chat_tab.ChatIntent

@Composable
internal fun ChatListScreen(
    list: List<ChatData>,
    onAction: (ChatIntent) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(list) { index, item ->
            ChatItem(
                chatData = item,
                isLast = index == list.lastIndex
            ) {
                onAction(ChatIntent.OpenChat(item.id))
            }
        }
    }
}

@Preview
@Composable
private fun ChatListScreenPrev() {
    ChatListScreen(
        list = listOf(
            getEmptyChatData(),
            getEmptyChatData(),
        )
    ) {}
}