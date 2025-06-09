package uzb.smt.domen.model


data class MessageData(
    val id: String,
    val text: String,
    val ownerImage: String,
    val date: String,
    val seen: Boolean,
    val isYour: Boolean = false
)

fun getMessageData(
    isYour: Boolean
): MessageData = MessageData(
    id = "id",
    ownerImage = "",
    text = "Assalomu aleykum ustoz yaxshimisiz?",
    date = "2025-04-30 12:12",
    seen = true,
    isYour = isYour
)
