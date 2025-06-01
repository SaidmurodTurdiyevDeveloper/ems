package uzb.smt.common.local_storage.helper

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal class LongPreference(
    private val pref: SharedPreferences,
    private val defValue: Long = 0L
) : ReadWriteProperty<Any, Long> {
    override fun getValue(thisRef: Any, property: KProperty<*>) =
        pref.getLong(property.name, defValue)

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Long) =
        pref.edit { putLong(property.name, value).apply() }
}