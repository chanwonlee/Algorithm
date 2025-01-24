import java.util.*

data class State(val x: Int, val y: Int, val k: Int, val distance: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M, K) = readLine().split(" ").map { it.toInt() }
    val map = Array(N) {
        val line = readLine()
        IntArray(M) { i -> line[i] - '0' }
    }
    val visited = Array(N) { Array(M) { BooleanArray(K + 1) } }
    val queue: Queue<State> = LinkedList()
    queue.offer(State(0, 0, 0, 1))
    visited[0][0][0] = true

    while (queue.isNotEmpty()) {
        val (x, y, k, distance) = queue.poll()

        if (x == N - 1 && y == M - 1) {
            println(distance)
            return
        }

        for ((dx, dy) in listOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))) {
            val nx = x + dx
            val ny = y + dy
            if (nx !in 0..<N || ny !in 0..<M) continue
            if (map[nx][ny] == 0) {
                if (!visited[nx][ny][k]) {
                    visited[nx][ny][k] = true
                    queue.offer(State(nx, ny, k, distance + 1))
                }
            } else {
                if (k < K && !visited[nx][ny][k + 1]) {
                    visited[nx][ny][k + 1] = true
                    queue.offer(State(nx, ny, k + 1, distance + 1))
                }
            }
        }
    }
    println(-1)
}
