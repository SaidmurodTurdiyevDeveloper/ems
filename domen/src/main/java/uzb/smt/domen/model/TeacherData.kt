package uzb.smt.domen.model

data class TeacherData(
    val id: String,
    val workingType: String,
    val name: String,
    val chatId: String
)

fun getTeacherList() = listOf(
    TeacherData(
        id = "",
        workingType = "Ma’ruza",
        name = "Karimova Mohira Abdug’ani qizi",
        chatId = ""
    ),
    TeacherData(
        id = "",
        workingType = "Amaliyot",
        name = "Murodova Aziza Abdug’ani qizi",
        chatId = ""
    ),
)
