package uzb.smt.common.local_storage

import android.content.Context
import uzb.smt.common.local_storage.helper.BooleanPreference
import uzb.smt.common.local_storage.helper.StringPreference

class LocalStorageImpl(context: Context) : LocalStorage {

    private val pref = context.getSharedPreferences("ems_cache", Context.MODE_PRIVATE)
    override fun clear() {
        pref.edit().apply {
            clear()
            apply()
        }
    }

    override var appLanguage by StringPreference(pref)
    override var studentId by StringPreference(pref)
    override var studentPassword by StringPreference(pref)
    override var isRegistered by BooleanPreference(pref)
    override var isOpenedFirstTime by BooleanPreference(pref, true)
}