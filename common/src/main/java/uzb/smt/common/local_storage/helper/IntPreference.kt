package uzb.smt.common.local_storage.helper

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal class IntPreference(
    private val pref: SharedPreferences,
    private val defValue: Int = 0
) : ReadWriteProperty<Any, Int> {
    override fun getValue(thisRef: Any, property: KProperty<*>) =
        pref.getInt(property.name, defValue)

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) =
        pref.edit { putInt(property.name, value).apply() }
}