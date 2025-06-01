package uzb.smt.presenter.screens.subject_tab

import dagger.hilt.android.lifecycle.HiltViewModel
import uzb.smt.presenter.navigator.AppNavigatorImpl
import uzb.smt.presenter.utils.BaseViewModel
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
internal class SubjectViewModel @Inject constructor(
    navigatorImpl: AppNavigatorImpl
) : BaseViewModel<SubjectState, SubjectIntent>(
    initializeData = SubjectState(),
    appNavigator = navigatorImpl
) {
    override fun onAction(intent: SubjectIntent) {

    }


}