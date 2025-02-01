fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }

    val A = Array(N) {
        val line = readLine()
        IntArray(M) { i -> line[i] - '0' }
    }

    val B = Array(N) {
        val line = readLine()
        IntArray(M) { i -> line[i] - '0' }
    }

    var answer = 0
    for (i in 0..<N - 2) {
        for (j in 0..<M - 2) {
            if (A[i][j] != B[i][j]) {
                switch(A, i, j)
                answer += 1
            }
        }
    }

    if (A.contentDeepEquals(B)) println(answer) else println(-1)
}

fun switch(array: Array<IntArray>, x: Int, y: Int) {
    for (i in 0..<3) {
        for (j in 0..<3) {
            array[x + i][y + j] = if (array[x + i][y + j] == 0) 1 else 0
        }
    }
}