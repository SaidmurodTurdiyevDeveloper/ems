package uzb.smt.domen.model

data class ChatData(
    val id: String,
    val name: String,
    val image: String,
    val description: String,
    val lastMessageSeen: Boolean,
    val lastMessageSeenDate: String
)

fun getEmptyChatData(): ChatData = ChatData(
    id = "id",
    name = "Karimova Malika",
    image = "image",
    description = "Assalomu aleykum ustoz yaxshimisiz?",
    lastMessageSeen = false,
    lastMessageSeenDate = "2025-04-30 12:12"
)
