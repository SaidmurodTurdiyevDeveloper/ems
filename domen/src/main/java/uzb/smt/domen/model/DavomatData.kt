package uzb.smt.domen.model

data class DavomatData(
    val id: Int,
    val date: Long,
    val isWithRequest: Boolean,
    val themeTitle: String,
    val themeDescription: String,
    val subject: String,
    val subjectType: SubjectType
)
