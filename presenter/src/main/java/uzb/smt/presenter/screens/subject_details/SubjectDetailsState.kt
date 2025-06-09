package uzb.smt.presenter.screens.subject_details

import uzb.smt.domen.model.SubjectDetailsData

internal data class SubjectDetailsState(
    val isLoading: Boolean = false,
    val subjectData: SubjectDetailsData?=null,
)
