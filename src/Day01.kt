import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        return input
            .map { it.split("   ") }
            .map { (first, last) -> first.toInt() to last.toInt() }
            .let { numbers ->
                val sortedByFirst = numbers.sortedBy { it.first }
                val sortedBySecond = numbers.sortedBy { it.second }
                sortedByFirst.zip(sortedBySecond)
            }
            .sumOf { (a, b) -> abs(a.first - b.second) }
    }

    fun part2(input: List<String>): Int {
        return input
            .map { it.split("   ") }
            .map { (first, last) -> first.toInt() to last.toInt() }
            .let { pairs ->
                val (lefts, rights) = pairs.unzip()
                lefts.sumOf { left -> rights.count { it == left } * left }
            }
    }

    part1(readInput("Day01")).println()
    part2(readInput("Day01")).println()
}