package uzb.smt.presenter.screens.lesson_schedule_tab

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uzb.smt.presenter.navigator.AppNavigatorImpl
import uzb.smt.presenter.utils.BaseViewModel
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
internal class LessonScheduleViewModel @Inject constructor(
    appNavigatorImpl: AppNavigatorImpl
) : BaseViewModel<LessonScheduleState, LessonScheduleIntent>(
    initializeData = LessonScheduleState(),
    appNavigator = appNavigatorImpl
) {
    private var isDay = false
    private val loadDayCalendar = Calendar.getInstance()
    private val loadWeekCalendar = Calendar.getInstance()

    init {
        loadDayCalendar.set(Calendar.DAY_OF_MONTH, 1)
        loadWeekCalendar.set(Calendar.DAY_OF_WEEK, 1)
        uiState.filter {
            it.isDay != isDay
        }.onEach {
            isDay = it.isDay
            update(
                state.copy(
                    selectedDay = Calendar.getInstance()
                )
            )
            loadDays()
        }.launchIn(viewModelScope)
    }

    override fun onAction(intent: LessonScheduleIntent) {
        when (intent) {
            LessonScheduleIntent.ChangeToDay -> update(state.copy(isDay = true))
            LessonScheduleIntent.ChangeToWeek -> update(state.copy(isDay = false))
            LessonScheduleIntent.NextDay -> nextDay()
            LessonScheduleIntent.NextWeek -> nextWeek()
            LessonScheduleIntent.PreviousDay -> previousDay()
            LessonScheduleIntent.PreviousWeek -> previousWeek()
            is LessonScheduleIntent.SelectDate -> update(state.copy(selectedDay = intent.date))
        }
    }

    private fun nextDay() {
        val selectedDay = (state.selectedDay.clone() as Calendar)
        val oldMonth = selectedDay.get(Calendar.MONTH)
        selectedDay.add(Calendar.DAY_OF_MONTH, 1)
        val newMonth = selectedDay.get(Calendar.MONTH)
        if (oldMonth != newMonth) {
            loadDayCalendar.add(Calendar.MONTH, 1)
            loadDays()
        }
        update(state.copy(selectedDay = selectedDay))
    }

    private fun previousDay() {
        val selectedDay = (state.selectedDay.clone() as Calendar)
        val oldMonth = selectedDay.get(Calendar.MONTH)
        selectedDay.add(Calendar.DAY_OF_MONTH, -1)
        val newMonth = selectedDay.get(Calendar.MONTH)
        if (oldMonth != newMonth) {
            loadDayCalendar.add(Calendar.MONTH, -1)
            loadDays()
        }
        update(state.copy(selectedDay = selectedDay))
    }

    private fun nextWeek() {
        val selectedDay = (state.days.first().clone() as Calendar)
        selectedDay.add(Calendar.DAY_OF_MONTH, 7)
        loadWeekCalendar.add(Calendar.DAY_OF_MONTH, 7)
        loadDays()
        update(state.copy(selectedDay = selectedDay))
    }

    private fun previousWeek() {
        val selectedDay = (state.days.first().clone() as Calendar)
        selectedDay.add(Calendar.DAY_OF_MONTH, -7)
        loadWeekCalendar.add(Calendar.DAY_OF_MONTH, -7)
        loadDays()
        update(state.copy(selectedDay = selectedDay))
    }

    private fun loadDays() {
        val ls = if (isDay) {
            generateMonthListList(loadDayCalendar)
        } else {
            generateWeekListList(loadWeekCalendar)
        }
        update(state.copy(days = ls))
    }

    private fun generateMonthListList(centerDate: Calendar): List<Calendar> {
        val newList = mutableListOf<Calendar>()
        val startDate = centerDate.clone() as Calendar
        startDate.set(Calendar.DAY_OF_MONTH, 1)
        val endDate = startDate.clone() as Calendar
        endDate.add(Calendar.MONTH, 1)

        while (startDate.before(endDate)) {
            newList.add(startDate.clone() as Calendar)
            startDate.add(Calendar.DAY_OF_MONTH, 1)
        }
        return newList
    }

    private fun generateWeekListList(centerDate: Calendar): List<Calendar> {
        val newList = mutableListOf<Calendar>()
        val startDate = centerDate.clone() as Calendar
        startDate.set(Calendar.DAY_OF_WEEK, 1)
        val endDate = startDate.clone() as Calendar
        endDate.add(Calendar.DAY_OF_WEEK, 7)

        while (startDate.before(endDate)) {
            newList.add(startDate.clone() as Calendar)
            startDate.add(Calendar.DAY_OF_WEEK, 1)
        }
        return newList
    }
}