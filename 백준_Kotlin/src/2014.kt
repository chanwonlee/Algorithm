import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (K, N) = readLine().split(' ').map { it.toInt() }
    val numbers = readLine().split(' ').map { it.toLong() }
    val priorityQueue = PriorityQueue<Long>(numbers)

    repeat(N - 1) {
        val n = priorityQueue.poll()
        for (number in numbers) {
            val result = n * number
            if (result < Int.MAX_VALUE) {
                priorityQueue.add(result)
            }

            if (n % number == 0L) {
                break
            }
        }
    }
    print(priorityQueue.peek())
}