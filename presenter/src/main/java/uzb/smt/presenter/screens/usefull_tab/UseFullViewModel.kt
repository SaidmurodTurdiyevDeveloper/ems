package uzb.smt.presenter.screens.usefull_tab

import dagger.hilt.android.lifecycle.HiltViewModel
import uzb.smt.presenter.navigator.AppNavigatorImpl
import uzb.smt.presenter.screens.subject_tab.SubjectIntent
import uzb.smt.presenter.screens.subject_tab.SubjectState
import uzb.smt.presenter.utils.BaseViewModel
import javax.inject.Inject

@HiltViewModel
internal class UseFullViewModel @Inject constructor(
    navigatorImpl: AppNavigatorImpl
) : BaseViewModel<UseFullState, UseFullIntent>(
    initializeData = UseFullState(),
    appNavigator = navigatorImpl
) {
    override fun onAction(intent: UseFullIntent) {

    }
}