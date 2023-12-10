fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf { line: String ->
            val innerList: List<Int> = line.toList()
                .map { char: Char -> char.digitToIntOrNull() }
                .filterIsInstance<Int>()
                .toList()
            (innerList.first().toString() + innerList.last().toString()).toInt()
        }
    }

    val stringIntMap = mapOf(
        "one" to 1,
        "1" to 1,
        "two" to 2,
        "2" to 2,
        "three" to 3,
        "3" to 3,
        "four" to 4,
        "4" to 4,
        "five" to 5,
        "5" to 5,
        "six" to 6,
        "6" to 6,
        "seven" to 7,
        "7" to 7,
        "eight" to 8,
        "8" to 8,
        "nine" to 9,
        "9" to 9,
    )

    fun extractNumbers(line: String): MutableList<Int> {
        val numberList = mutableListOf<Int>()

        for (i in 1..line.length) {
            val reducedLine = line.drop(i - 1)
            for ((k, v) in stringIntMap) {
                if (reducedLine.startsWith(k, true)) {
                    numberList.addLast(v)
                }
            }
        }

        return numberList
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { line: String ->
            val numberList = extractNumbers(line)
            (numberList.first().toString() + numberList.last().toString()).toInt()
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day01Part2Test")
    check(part2(testInput) == 281)

    val input = readInput("day01")
    part1(input).println()
    part2(input).println()
}
