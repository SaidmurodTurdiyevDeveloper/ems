package uzb.smt.presenter.screens.home_tab

import uzb.smt.domen.model.CurrentLesson
import uzb.smt.domen.model.SubjectScoreData
import uzb.smt.domen.model.TaskData
import uzb.smt.domen.model.UserData
import uzb.smt.domen.model.getCurrentLesson
import uzb.smt.domen.model.getEmptyTaskData
import uzb.smt.domen.model.getSubjectScoreDataList

data class HomeState(
    val isLoading: Boolean = false,
    val user: UserData? = null,
    val currentLesson: CurrentLesson? = getCurrentLesson(),
    val tasks: List<TaskData> = listOf(getEmptyTaskData()),
    val subjects: List<SubjectScoreData> = getSubjectScoreDataList()

)
