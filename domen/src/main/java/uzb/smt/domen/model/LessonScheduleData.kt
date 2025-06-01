package uzb.smt.domen.model

data class LessonScheduleData(
    val id: String,
    val name: String,
    val startTime: String,
    val endTime: String,
    val room: String,
    val teacher: String,
    val lessonType: String,
    val homeWorkId: String
)

fun getEmptyLessonScheduleData() = LessonScheduleData(
    id = "id",
    name = "Matematika",
    startTime = "08:30",
    endTime = "10:00",
    room = "E102",
    teacher = "Karimova Jasmina",
    lessonType = "Ma’ruza",
    homeWorkId = "home work id"
)

fun getEmptyLessonScheduleDataList() = listOf(
    LessonScheduleData(
        id = "id",
        name = "Matematika",
        startTime = "08:30",
        endTime = "10:00",
        room = "E102",
        teacher = "Karimova Jasmina",
        lessonType = "Ma’ruza",
        homeWorkId = "home work id"
    ),
    LessonScheduleData(
        id = "id",
        name = "Fizika",
        startTime = "10:00",
        endTime = "11:30",
        room = "A303",
        teacher = "Malikova Kamila",
        lessonType = "Ma’ruza",
        homeWorkId = "home work id"
    ),
    LessonScheduleData(
        id = "id",
        name = "Ingliz tili",
        startTime = "11:30",
        endTime = "13:00",
        room = "F800",
        teacher = "Erkinova Malika",
        lessonType = "Ma’ruza",
        homeWorkId = "home work id"
    ),
)
