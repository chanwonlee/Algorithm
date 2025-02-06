fun main() = with(System.`in`.bufferedReader()) {
    val (M, N) = readLine().split(" ").map { it.toInt() }
    val grid = Array(M) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val dp = Array(M) { IntArray(N) { -1 } }

    fun dfs(x: Int, y: Int): Int {
        if (x == M - 1 && y == N - 1) return 1
        if (dp[x][y] != -1) return dp[x][y]

        dp[x][y] = 0
        for ((dx, dy) in listOf(Pair(1, 0), Pair(-1, 0), Pair(0, -1), Pair(0, 1))) {
            val nx = dx + x
            val ny = dy + y
            if (nx in 0..<M && ny in 0..<N && grid[nx][ny] < grid[x][y]) {
                dp[x][y] += dfs(nx, ny)
            }
        }
        return dp[x][y]
    }

    println(dfs(0, 0))
}