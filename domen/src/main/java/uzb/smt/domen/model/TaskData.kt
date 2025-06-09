package uzb.smt.domen.model

data class TaskData(
    val id: String,
    val title: String,
    val subject: String,
    val score: Byte,
    val isFinished: Boolean,
    val finishingTime: String,
    val description: String
)

fun getEmptyTaskData() = TaskData(
    "id",
    "title",
    "Matematika",
    0,
    false,
    "2025-06-14 12:12",
    "description"
)

fun getTaskDataList() = listOf(
    TaskData(
        "id",
        "Topshiriq 1",
        "Matematika",
        5,
        true,
        "2025-06-14 12:12",
        "20 ta kitobdan test tuzish"
    ),
    TaskData(
        "id",
        "Topshiriq 2",
        "Matematika",
        0,
        false,
        "2025-06-14 12:12",
        "description"
    )
)
