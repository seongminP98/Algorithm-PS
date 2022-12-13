fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val M = readLine().toInt()
    print(combination(M - 1, M - N))
}

fun combination(n: Int, r: Int): Int {
    if (n == r) return 1
    if (r == 0) return 1
    return combination(n - 1, r) + combination(n - 1, r - 1)
}