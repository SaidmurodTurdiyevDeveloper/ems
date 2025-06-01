package uzb.smt.presenter.navigator

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import uzb.smt.presenter.R
import uzb.smt.common.R as commonR

internal sealed class TabScreen(val route: String, @StringRes val title: Int, @DrawableRes val icon: Int, @DrawableRes val selectedIcon: Int) {
    data object MainTab : TabScreen(route = "MainTab", title = commonR.string.tab_main, icon = R.drawable.ic_home_tab_off, selectedIcon = R.drawable.ic_home_tab_on)
    data object SubjectTab : TabScreen(route = "SubjectTab", title = commonR.string.tab_subject, icon = R.drawable.ic_subject_tab_off, selectedIcon = R.drawable.ic_subject_tab_on)
    data object LessonScheduleTab : TabScreen(route = "LessonScheduleTab", title = commonR.string.tab_lesson_schedule, icon = R.drawable.ic_lesson_tab_off, selectedIcon = R.drawable.ic_lesson_tab_on)
    data object ChatTab : TabScreen(route = "ChatTab", title = commonR.string.tab_chat, icon = R.drawable.ic_chat_tab_off, selectedIcon = R.drawable.ic_chat_tab_on)
    data object UseFullTab : TabScreen(route = "UseFullTab", title = commonR.string.tab_usefull, icon = R.drawable.ic_usefull_tab_off, selectedIcon = R.drawable.ic_usefull_tab_on)
}