fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val distances = Array(N) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val road = Array(N) { BooleanArray(N) { true } }

    for (k in 0..<N) {
        for (i in 0..<N) {
            for (j in 0..<N) {
                if (i == k || j == k || i == j) continue

                if (distances[i][j] == distances[i][k] + distances[k][j]) {
                    road[i][j] = false
                }

                if (distances[i][j] > distances[i][k] + distances[k][j]) {
                    print(-1)
                    return
                }
            }
        }
    }

    var result = 0
    for (i in 0..<N) {
        for (j in i..<N) {
            if (road[i][j]) {
                result += distances[i][j]
            }
        }
    }
    print(result)
}