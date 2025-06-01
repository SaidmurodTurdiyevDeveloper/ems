package uzb.smt.presenter.utils

import android.content.Context
import uzb.smt.common.utils.changeInt
import uzb.smt.common.utils.getMonthRes
import java.util.Calendar
import uzb.smt.common.R as commonR

internal fun calculateTimePercent(startTime: String, endTime: String): Float {
    try {
        val (startH, startM) = startTime.split(":").map { it.trim().changeInt() }
        val (endH, endM) = endTime.split(":").map { it.trim().changeInt() }

        val startTotal = startH * 60 + startM
        val endTotal = endH * 60 + endM

        val now = Calendar.getInstance()
        val nowHour = if (now.get(Calendar.HOUR_OF_DAY) < 12 || startH > 11 || endH > 11) now.get(Calendar.HOUR_OF_DAY) else {
            now.get(Calendar.HOUR_OF_DAY) - 12
        }

        val currentTotal = nowHour * 60 + now.get(Calendar.MINUTE)

        val isCrossingMidnight = startTotal > endTotal

        val totalDuration = if (isCrossingMidnight) (1440 - startTotal) + endTotal else endTotal - startTotal
        val remainingTime = if (isCrossingMidnight) {
            if (currentTotal >= startTotal) {
                (1440 - currentTotal) + endTotal
            } else {
                endTotal - currentTotal
            }
        } else {
            endTotal - currentTotal
        }

        return remainingTime.toFloat() / totalDuration.toFloat()
    } catch (_: Exception) {
        return 1f
    }
}


fun Context.getUntilTimeCount(lastDate: String): String {
    try {
        val (date, time) = lastDate.split(" ")
        val (year, month, day) = date.split("-").map { it.trim().changeInt() }
        val (hour, minute) = time.split(":").map { it.trim().changeInt() }

        val now = Calendar.getInstance()
        val nowYear = now.get(Calendar.YEAR)
        val nowMonth = now.get(Calendar.MONTH) + 1
        val nowDay = now.get(Calendar.DAY_OF_MONTH)
        val nowHour = now.get(Calendar.HOUR_OF_DAY)
        val nowMinute = now.get(Calendar.MINUTE)
        if (nowYear > year) return getString(commonR.string.until_year, nowYear - year)
        if (nowMonth > month) return getString(commonR.string.until_month, nowMonth - month)
        if (nowDay > day) return getString(commonR.string.until_day, nowDay - day)
        if (nowHour > hour) return getString(commonR.string.until_hour, nowHour - hour)
        if (nowMinute > minute) return getString(commonR.string.until_minute, nowMinute - minute)
        return ""
    } catch (_: Exception) {
        return ""
    }
}

fun Context.getMonthDate(lastDate: String): String {
    try {
        val (date, _) = lastDate.split(" ")
        val (_, month, day) = date.split("-").map { it.trim().changeInt() }
        val monthRes = (month + 1).getMonthRes()
        return "$day-${getString(monthRes)}"
    } catch (_: Exception) {
        return ""
    }
}