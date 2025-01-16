fun main() = with(System.`in`.bufferedReader()) {
    val tree = mutableListOf<Int>()
    while (true) {
        val input = readLine() ?: break
        tree.add(input.toInt())
    }

    postOrderTraversal(tree, 0, tree.size - 1).forEach { println(it) }
}

fun postOrderTraversal(tree: List<Int>, start: Int, end: Int): List<Int> {
    if (start > end) return emptyList()

    val root = tree[start]
    var rightStart = start + 1

    while (rightStart <= end && tree[rightStart] < root) {
        rightStart++
    }

    val leftSubtree = postOrderTraversal(tree, start + 1, rightStart - 1)
    val rightSubtree = postOrderTraversal(tree, rightStart, end)
    return leftSubtree + rightSubtree + root
}