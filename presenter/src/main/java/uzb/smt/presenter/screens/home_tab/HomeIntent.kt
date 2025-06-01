package uzb.smt.presenter.screens.home_tab

internal sealed interface HomeIntent {
    data object LoadData : HomeIntent
}