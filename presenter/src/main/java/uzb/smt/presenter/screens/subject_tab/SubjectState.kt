package uzb.smt.presenter.screens.subject_tab

import uzb.smt.domen.model.SubjectData
import uzb.smt.domen.model.getEmptySubjectData
import uzb.smt.presenter.R

internal data class SubjectState(
    val isLoading: Boolean = false,
    val favourites: List<SubjectData> = listOf(
        getEmptySubjectData(
            imageLogo = R.drawable.img_subject_math
        ),
        getEmptySubjectData(
            imageLogo = R.drawable.img_subject_math
        )
    ),
    val subjects: List<SubjectData> = listOf(
        getEmptySubjectData(
            imageLogo = R.drawable.img_phithic
        ),
        getEmptySubjectData(
            imageLogo = R.drawable.img_phithic
        )
    )
)
