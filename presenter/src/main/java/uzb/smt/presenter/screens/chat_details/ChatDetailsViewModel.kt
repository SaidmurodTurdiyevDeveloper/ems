package uzb.smt.presenter.screens.chat_details

import dagger.hilt.android.lifecycle.HiltViewModel
import uzb.smt.domen.model.MessageData
import uzb.smt.presenter.navigator.AppNavigatorImpl
import uzb.smt.presenter.utils.BaseViewModel
import javax.inject.Inject

@HiltViewModel
internal class ChatDetailsViewModel @Inject constructor(
    appNavigatorImpl: AppNavigatorImpl
) : BaseViewModel<ChatDetailsState, ChatDetailsIntent>(
    initializeData = ChatDetailsState(),
    appNavigator = appNavigatorImpl
) {
    override fun onAction(intent: ChatDetailsIntent) {
        when (intent) {
            is ChatDetailsIntent.ChangeMessage -> update(state.copy(message = intent.message))
            ChatDetailsIntent.Back -> back()
            ChatDetailsIntent.SendMessage -> sendMessage(state.message)
        }
    }

    private fun sendMessage(message: String) {
        val newList = state.messages.toMutableList()
        newList.add(
            MessageData(
                id = "id",
                text = message,
                date = "2025-04-30 12:12",
                seen = false,
                ownerImage = "",
                isYour = true
            )
        )
        update(state.copy(messages = newList, message = ""))
    }
}