package uzb.smt.presenter.screens.subject_tab

internal sealed interface SubjectIntent {
    data class OpenSubjectDetails(val subjectId: String) : SubjectIntent
}