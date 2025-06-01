package uzb.smt.domen.model

data class CurrentLesson(
    val id: String,
    val name: String,
    val teacher: String,
    val startTime: String,
    val endTime: String,
    val room: String,
    val nextLesson: String,
    val nextLessonStartTime: String,
    val nextLessonEndTime: String
)

fun getCurrentLesson(): CurrentLesson = CurrentLesson("1", "Matematika", "Karimova Mohira", "11:40", "12:50", "202", "Rus tili", "13:00", "14:20")
