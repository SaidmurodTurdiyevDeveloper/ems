package uzb.smt.domen.model

data class TaskData(
    val id: String,
    val title: String,
    val description: String
)

fun getEmptyTaskData() = TaskData("id", "title", "description")
