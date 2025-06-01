package uzb.smt.presenter.screens.chat_tab

internal sealed interface ChatIntent {
    data class OpenChat(val id: String) : ChatIntent
}