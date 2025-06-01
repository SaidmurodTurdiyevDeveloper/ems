package uzb.smt.presenter.screens.lesson_schedule_tab

import uzb.smt.domen.model.LessonScheduleData
import uzb.smt.domen.model.getEmptyLessonScheduleDataList
import java.util.Calendar


internal data class LessonScheduleState(
    val isLoading: Boolean = false,
    val isDay: Boolean = true,
    val days: List<Calendar> = emptyList(),
    val selectedDay: Calendar = Calendar.getInstance(),
    val lessons: List<LessonScheduleData> = getEmptyLessonScheduleDataList()
)
