package uzb.smt.common.utils

import uzb.smt.common.R


fun Int.getMonthRes(): Int = when (this) {
    1 -> R.string.yanvar
    2 -> R.string.fevral
    3 -> R.string.mart
    4 -> R.string.aprel
    5 -> R.string.may
    6 -> R.string.iyun
    7 -> R.string.iyul
    8 -> R.string.avgust
    9 -> R.string.sentabr
    10 -> R.string.oktabr
    11 -> R.string.noyabr
    12 -> R.string.dekabr
    else -> R.string.yanvar
}

fun Int.getWeekDayRes(): Int = when (this) {
    1 -> R.string.sunday
    2 -> R.string.monday
    3 -> R.string.tuesday
    4 -> R.string.wednesday
    5 -> R.string.thursday
    6 -> R.string.friday
    7 -> R.string.saturday
    else -> R.string.monday
}