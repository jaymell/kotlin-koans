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

///// copied straight from website b/c what? instructions make no fucking sense
operator fun MyDate.plus(timeInterval: TimeInterval) = addTimeIntervals(timeInterval, 1)

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)

operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this, number)

operator fun MyDate.plus(timeIntervals: RepeatedTimeInterval) =
        this.addTimeIntervals(timeIntervals.timeInterval, timeIntervals.number)
////