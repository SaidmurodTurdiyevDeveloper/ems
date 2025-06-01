package uzb.smt.domen.model

data class UserData(
    val id: String,
    val name: String,
    val image: String
)

fun emptyUserData() = UserData(
    id = "user_id",
    name = "O’rinboyev Yusufbek",
    image = "image link"
)
