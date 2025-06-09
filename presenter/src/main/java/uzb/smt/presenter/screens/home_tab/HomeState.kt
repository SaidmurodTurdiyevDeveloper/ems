package uzb.smt.presenter.screens.home_tab

import uzb.smt.domen.model.CurrentLesson
import uzb.smt.domen.model.JadidData
import uzb.smt.domen.model.SubjectScoreData
import uzb.smt.domen.model.TaskData
import uzb.smt.domen.model.UserData
import uzb.smt.domen.model.emptyUserData
import uzb.smt.domen.model.getCurrentLesson
import uzb.smt.domen.model.getEmptyTaskData
import uzb.smt.domen.model.getListJadidData
import uzb.smt.domen.model.getSubjectScoreDataList

internal data class HomeState(
    val isLoading: Boolean = false,
    val existNotification: Boolean = false,
    val user: UserData? = emptyUserData(),
    val currentLesson: CurrentLesson? = getCurrentLesson(),
    val tasks: List<TaskData> = listOf(getEmptyTaskData()),
    val subjectScores: List<SubjectScoreData> = getSubjectScoreDataList(),
    val jadids: List<JadidData> = getListJadidData()
)
