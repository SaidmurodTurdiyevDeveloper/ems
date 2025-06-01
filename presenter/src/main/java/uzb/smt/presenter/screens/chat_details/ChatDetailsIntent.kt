package uzb.smt.presenter.screens.chat_details

internal sealed interface ChatDetailsIntent {
    data object Back : ChatDetailsIntent
    data object SendMessage : ChatDetailsIntent
    data class ChangeMessage(val message: String) : ChatDetailsIntent
}