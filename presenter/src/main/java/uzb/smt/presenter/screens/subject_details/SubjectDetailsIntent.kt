package uzb.smt.presenter.screens.subject_details

internal sealed interface SubjectDetailsIntent {
    data object Back : SubjectDetailsIntent
}