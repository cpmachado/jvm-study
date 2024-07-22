import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = this.addTimeIntervals(timeInterval, 1)

data class MultipleTimeInterval(val timeInterval: TimeInterval, val amount: Int)

operator fun TimeInterval.times(n: Int): MultipleTimeInterval = MultipleTimeInterval(this, n)

operator fun MyDate.plus(multipleTimeInterval: MultipleTimeInterval): MyDate =
    this.addTimeIntervals(multipleTimeInterval.timeInterval, multipleTimeInterval.amount)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
