package uzb.smt.domen.validator

import uzb.smt.domen.model.DavomatData
import uzb.smt.domen.model.SubjectType

enum class DavomatFilter {
    ALL,
    WithReason,
    WithoutReason,
    DATE,
    MARUZA,
    AMALIYOT
}

fun filterDavomatList(
    davomatList: List<DavomatData>,
    davomatFilter: DavomatFilter
): List<DavomatData> {
    return when (davomatFilter) {
        DavomatFilter.ALL -> davomatList
        DavomatFilter.DATE -> {
            davomatList.sortedBy { it.date }
        }

        DavomatFilter.MARUZA -> {
            davomatList.filter { it.subjectType == SubjectType.Maruza }
        }

        DavomatFilter.AMALIYOT -> {
            davomatList.filter { it.subjectType == SubjectType.Amaliyot }
        }

        DavomatFilter.WithReason -> davomatList.filter { it.isWithRequest }
        DavomatFilter.WithoutReason -> davomatList.filter { !it.isWithRequest }
    }
}