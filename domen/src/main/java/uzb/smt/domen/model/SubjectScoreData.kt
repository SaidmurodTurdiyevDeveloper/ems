package uzb.smt.domen.model


data class SubjectScoreData(
    val id: String,
    val percent: Float,
    val lastScoreDate: String,
    val name: String,
    val score: Int,
    val description: String,
    val changeScore: Int,
    val lastScores: List<Int>
)

fun getEmptySubjectScoreData(): SubjectScoreData = SubjectScoreData(
    id = "subject_id",
    percent = 0.9f,
    lastScoreDate = "2025-04-30 12:12",
    name = "Matematika",
    score = 5,
    description = "3 ta ketma- ket 5 baho",
    changeScore = 2,
    lastScores = listOf(5, 5, 5)
)

fun getSubjectScoreDataList(): List<SubjectScoreData> = listOf(
    SubjectScoreData(
        id = "subject_id",
        percent = 0.9f,
        lastScoreDate = "2025-04-30 12:12",
        name = "Matematika",
        score = 5,
        description = "3 ta ketma- ket 5 baho",
        changeScore = 2,
        lastScores = listOf(5, 5, 5)
    ),
    SubjectScoreData(
        id = "subject_id_2",
        percent = 0.7f,
        lastScoreDate = "2025-04-28 12:12",
        name = "Fizika",
        score = 4,
        description = "Darsda faol emas!",
        changeScore = -1,
        lastScores = listOf(4, 3, 3)
    ),
)
