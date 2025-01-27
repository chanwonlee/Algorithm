import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M, K) = readLine().split(" ").map { it.toInt() }
    val array = Array(N) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    val layers = min(N, M) / 2

    for (layer in 0..<layers) {
        rotateLayer(array, layer, K)
    }

    for (row in array) {
        println(row.joinToString(" "))
    }
}

fun rotateLayer(array: Array<IntArray>, start: Int, K: Int) {
    val N = array.size
    val M = array[0].size

    val ring = mutableListOf<Int>()

    for (col in start..<M - start) {
        ring.add(array[start][col])
    }

    for (row in start + 1..<N - start - 1) {
        ring.add(array[row][M - start - 1])
    }

    if (N - start - 1 > start) {
        for (col in (M - start - 1) downTo start) {
            ring.add(array[N - start - 1][col])
        }
    }

    if (start < M - start - 1) {
        for (row in (N - start - 2) downTo (start + 1)) {
            ring.add(array[row][start])
        }
    }

    val len = ring.size
    if (len == 0) return
    val rotate = K % len
    if (rotate == 0) return

    val rotated = ring.subList(rotate, len) + ring.subList(0, rotate)

    var idx = 0

    for (col in start..<M - start) {
        array[start][col] = rotated[idx++]
    }

    for (row in start + 1..<N - start - 1) {
        array[row][M - start - 1] = rotated[idx++]
    }

    if (N - start - 1 > start) {
        for (col in (M - start - 1) downTo start) {
            array[N - start - 1][col] = rotated[idx++]
        }
    }

    if (start < M - start - 1) {
        for (row in (N - start - 2) downTo (start + 1)) {
            array[row][start] = rotated[idx++]
        }
    }
}