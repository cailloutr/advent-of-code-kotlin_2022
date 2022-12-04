fun main() {

    fun part1(input: List<String>): Int {

        var sum = 0
        var mostCalories = 0

        for (i in input.indices) {
            if (input[i].isNotBlank()) {
                sum += input[i].toInt()
            } else {
                if (sum > mostCalories) {
                    mostCalories = sum
                }
                sum = 0
            }
        }
        return mostCalories
    }

    fun part2(input: List<String>): Int {

        val breaks = input.indices.filter { input[it].isBlank() }
        val elfs = mutableMapOf<Int, Int>()

        breaks.indices.forEach {
            when (it) {
                0 -> {
                    var sum = 0
                    for (i in 0 until breaks[0]) {
                        sum += input[i].toInt()
                    }
                    elfs[it] = sum
                }

                breaks.lastIndex -> {
                    var sum = 0
                    for (i in breaks[it] + 1..input.lastIndex) {
                        sum += input[i].toInt()
                    }
                    elfs[it + 1] = sum
                }

                in 1 until breaks.lastIndex -> {
                    var sum = 0
                    for (i in breaks[it] + 1 until breaks[it+1]) {
                        sum += input[i].toInt()
                    }
                    elfs[it] = sum
                }
            }
        }

        val sorted = elfs.values.sortedDescending()
        var result = 0
        for (i in 0..2) {
            result += sorted[i]
        }


        return result
    }

//    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 24000)

    val fileName =
        "Day01"
//        "Day01_test"

    val input = readInput(fileName)
    println(part1(input))
    println(part2(input))
}
