package uzb.smt.domen.model

data class SubjectDetailsData(
    val id: String,
    val rating: Double,
    val subjectGroup: String,
    val name: String,
    val image: String,
    val mainColorHex: Int,
    val tasks: List<TaskData>,
    val teachers: List<TeacherData>
)
