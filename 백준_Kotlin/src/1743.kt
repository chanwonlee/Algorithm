import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M, K) = readLine().split(" ").map { it.toInt() }
    val map = Array(N) { BooleanArray(M) { false } }
    var answer = 0

    repeat(K) {
        val (r, c) = readLine().split(" ").map { it.toInt() - 1 }
        map[r][c] = true
    }

    fun bfs(n: Int, m: Int): Int {
        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(Pair(n, m))
        map[n][m] = false
        val directions = listOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
        var size = 1

        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()
            for ((dx, dy) in directions) {
                val (nx, ny) = x + dx to y + dy
                if (nx in 0..<N && ny in 0..<M && map[nx][ny]) {
                    queue.offer(Pair(nx, ny))
                    map[nx][ny] = false
                    size++
                }
            }
        }
        return size
    }

    for (i in 0..<N) {
        for (j in 0..<M) {
            if (map[i][j]) {
                answer = maxOf(answer, bfs(i, j))
            }
        }
    }

    print(answer)
}