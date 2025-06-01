package uzb.smt.presenter.screens.chat_tab

import uzb.smt.domen.model.ChatData
import uzb.smt.domen.model.getEmptyChatData

internal data class ChatState(
    val isLoading: Boolean = false,
    val privateChats: List<ChatData> = listOf(
        getEmptyChatData(),
        getEmptyChatData(),
        getEmptyChatData(),
        getEmptyChatData(),
        getEmptyChatData()
    ),
    val groupChats: List<ChatData> = listOf(
        getEmptyChatData(),
        getEmptyChatData(),
        getEmptyChatData(),
        getEmptyChatData(),
        getEmptyChatData(),
        getEmptyChatData()
    )
)
