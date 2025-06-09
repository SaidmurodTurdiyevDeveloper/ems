package uzb.smt.presenter.screens.home_tab

internal sealed interface HomeIntent {
    data object LoadData : HomeIntent
    data object OpenNotification : HomeIntent
    data object AllScores : HomeIntent
    data object AllJadids : HomeIntent
    data class OpenSubjectDetailScreen(val id: String) : HomeIntent
}