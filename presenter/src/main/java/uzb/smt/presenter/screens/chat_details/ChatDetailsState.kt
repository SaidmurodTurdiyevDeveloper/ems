package uzb.smt.presenter.screens.chat_details

import uzb.smt.domen.model.ChatData
import uzb.smt.domen.model.MessageData
import uzb.smt.domen.model.getEmptyChatData
import uzb.smt.domen.model.getMessageData

data class ChatDetailsState(
    val isLoading: Boolean = false,
    val chatData: ChatData? = getEmptyChatData(),
    val message: String = "",
    val messages: List<MessageData> = listOf(
        getMessageData(isYour = false),
        getMessageData(isYour = true)
    ),
)
