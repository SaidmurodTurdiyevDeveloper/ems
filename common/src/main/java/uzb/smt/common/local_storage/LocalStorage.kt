package uzb.smt.common.local_storage

interface LocalStorage {
    fun clear()
    var appLanguage: String
    var studentId: String
    var studentPassword: String
    var isRegistered: Boolean
    var isOpenedFirstTime: Boolean
}