package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterator<MyDate> {
    var current: MyDate = start

    override fun next(): MyDate {
        val result = current
        current = current.nextDay()
        return result
    }

    override fun hasNext(): Boolean {
        if ( current <= endInclusive ) return true
        return false
    }
}

operator fun MyDate.compareTo(other: MyDate): Int {
    if ( year != other.year) return year - other.year
    if ( month != other.month) return month - other.month
    if ( dayOfMonth != other.dayOfMonth) return dayOfMonth - other.dayOfMonth
    return 0
}

operator fun DateRange.contains(date: MyDate): Boolean =
        start < date && endInclusive >= date

operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this, other)
}