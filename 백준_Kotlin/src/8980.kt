import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (N, C) = readLine().split(" ").map { it.toInt() }
    val M = readLine().toInt()
    val boxes = mutableListOf<Triple<Int, Int, Int>>()
    val capacity = IntArray(N + 1) { C }
    var answer = 0

    repeat(M) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        boxes.add(Triple(a, b, c))
    }
    boxes.sortWith(compareBy({ it.second }, { it.first }))

    for ((start, end, count) in boxes) {
        var min = C
        for (i in start..<end) {
            if (min > min(capacity[i], count)) {
                min = min(capacity[i], count)
            }
        }
        for (i in start..<end) {
            capacity[i] -= min
        }
        answer += min
    }
    println(answer)
}