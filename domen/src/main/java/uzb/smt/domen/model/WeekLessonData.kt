package uzb.smt.domen.model

import java.util.Calendar

data class WeekLessonData(
    val day: Calendar,
    val lessons: List<LessonScheduleData>
)
