package uzb.smt.presenter.screens.davomat

import dagger.hilt.android.lifecycle.HiltViewModel
import uzb.smt.presenter.navigator.AppNavigatorImpl
import uzb.smt.presenter.utils.BaseViewModel
import javax.inject.Inject

@HiltViewModel
internal class DavomatViewModel @Inject constructor(
    appNavigator: AppNavigatorImpl
) : BaseViewModel<DavomatState, DavomatIntent>(
    initializeData = DavomatState(),
    appNavigator = appNavigator
) {
    override fun onAction(intent: DavomatIntent) {

    }
}