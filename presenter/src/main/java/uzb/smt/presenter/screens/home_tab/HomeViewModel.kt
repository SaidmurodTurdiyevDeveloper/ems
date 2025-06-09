package uzb.smt.presenter.screens.home_tab

import dagger.hilt.android.lifecycle.HiltViewModel
import uzb.smt.presenter.navigator.AppNavigatorImpl
import uzb.smt.presenter.navigator.AppScreens
import uzb.smt.presenter.navigator.AppScreens.*
import uzb.smt.presenter.utils.BaseViewModel
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    navigator: AppNavigatorImpl
) : BaseViewModel<HomeState, HomeIntent>(initializeData = HomeState(), appNavigator = navigator) {
    override fun onAction(intent: HomeIntent) {
        when(intent){
            HomeIntent.LoadData -> {}
            is HomeIntent.OpenSubjectDetailScreen -> navigate(SubjectDetails(subjectId = intent.id))
            HomeIntent.AllScores -> {}
            HomeIntent.OpenNotification -> {}
            HomeIntent.AllJadids -> {}
        }
    }

}