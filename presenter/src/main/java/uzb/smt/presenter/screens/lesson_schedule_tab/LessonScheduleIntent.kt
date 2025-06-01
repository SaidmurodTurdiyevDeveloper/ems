package uzb.smt.presenter.screens.lesson_schedule_tab

import java.util.Calendar

internal sealed interface LessonScheduleIntent {
    data class SelectDate(val date: Calendar) : LessonScheduleIntent
    data object NextDay : LessonScheduleIntent
    data object PreviousDay : LessonScheduleIntent
    data object NextWeek : LessonScheduleIntent
    data object PreviousWeek : LessonScheduleIntent
    data object ChangeToDay: LessonScheduleIntent
    data object ChangeToWeek: LessonScheduleIntent
}