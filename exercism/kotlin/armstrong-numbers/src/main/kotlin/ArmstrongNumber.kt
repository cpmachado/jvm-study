object ArmstrongNumber {

    fun check(input: Int): Boolean = when (input) {
        in 0..9 -> true
        else -> {
            val str = input.toString()
            val n = str.length
            val numbers = str.map(Character::getNumericValue).map(Int::toBigInteger)
            val sum = numbers.sumOf { it.pow(n) }
            sum == input.toBigInteger()
        }
    }

}
