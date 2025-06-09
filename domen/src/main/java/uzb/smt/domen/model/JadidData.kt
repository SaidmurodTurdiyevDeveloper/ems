package uzb.smt.domen.model

data class JadidData(
    val id: String,
    val name: String,
    val info: String,
    val image: String
)

fun getEmptyJadidData() = JadidData(
    "id",
    "Mahmudxoʻja Behbudiy",
    "Mahmudxoʻja Behbudiy 1875-yil 20-yanvarda Samarqand yaqinidagi Siyob volostining Baxshitepa qishlogʻida imom-xatib Behbudxoʻja Solihxoʻja oʻgʻli xonadonida tugʻilgan",
    ""
)

fun getListJadidData() = listOf(
    JadidData(
        "id",
        "Mahmudxoʻja Behbudiy",
        "Mahmudxoʻja Behbudiy 1875-yil 20-yanvarda Samarqand yaqinidagi Siyob volostining Baxshitepa qishlogʻida imom-xatib Behbudxoʻja Solihxoʻja oʻgʻli xonadonida tugʻilgan",
        ""
    ),
    JadidData(
        "id_2",
        "Abdulla Avloniy",
        "Abdulla Avloniy (1878-yil 12-iyul, Toshkent – 1934-yil 25-avgust, Toshkent) – XIX asr oxiri XX asr boshidagi oʻzbek milliy madaniyatining mashhur vakillaridan biri, maʼrifatparvar shoir, dramaturg, jurnalist, olim, davlat va jamoat arbobi.",
        ""
    ),
)
