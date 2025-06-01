package uzb.smt.domen.model

import androidx.annotation.DrawableRes

data class SubjectData(
    val id: String,
    val absent: Float,
    val learning: Float,
    val name: String,
    val firstTeacher: String,
    val secondTeacher: String,
    val isNight: Boolean,
    @DrawableRes
    val logo: Int
)

fun getEmptySubjectData(
    @DrawableRes
    imageLogo: Int
): SubjectData = SubjectData(
    name = "Fizika",
    id = "id",
    absent = 0.8f,
    learning = 0.8f,
    isNight = false,
    firstTeacher = "Jahongirov Olim",
    secondTeacher = "Erkinov Sarvar",
    logo = imageLogo
)
