package uzb.smt.presenter.screens.chat_tab

import dagger.hilt.android.lifecycle.HiltViewModel
import uzb.smt.presenter.navigator.AppNavigatorImpl
import uzb.smt.presenter.navigator.AppScreens
import uzb.smt.presenter.utils.BaseViewModel
import javax.inject.Inject

@HiltViewModel
internal class ChatViewModel @Inject constructor(
    appNavigatorImpl: AppNavigatorImpl
) : BaseViewModel<ChatState, ChatIntent>(
    initializeData = ChatState(),
    appNavigator = appNavigatorImpl
) {
    override fun onAction(intent: ChatIntent) {
        when (intent) {
            is ChatIntent.OpenChat -> navigate(AppScreens.ChatDetails(intent.id))
        }
    }
}