fun main() = with(System.`in`.bufferedReader()) {
    val (L, R) = readLine().split(" ").map { it }
    var answer = 0
    if (L.length == R.length) {
        for (i in L.indices) {
            if (L[i] != R[i]) break
            if (L[i] == '8') answer++

        }
    }
    println(answer)
}