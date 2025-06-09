package uzb.smt.presenter.screens.subject_details

import dagger.hilt.android.lifecycle.HiltViewModel
import uzb.smt.presenter.navigator.AppNavigatorImpl
import uzb.smt.presenter.utils.BaseViewModel
import javax.inject.Inject

@HiltViewModel
internal class SubjectDetailsViewModel @Inject constructor(
    navigatorImpl: AppNavigatorImpl
) : BaseViewModel<SubjectDetailsState, SubjectDetailsIntent>(
    initializeData = SubjectDetailsState(),
    appNavigator = navigatorImpl
) {
    override fun onAction(intent: SubjectDetailsIntent) {

    }
}