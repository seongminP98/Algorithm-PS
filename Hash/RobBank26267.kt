fun main() = with(System.`in`.bufferedReader()) {
    var N = readLine().toInt()
    val map = HashMap<Int, Long>()
    var answer: Long = 0
    while (N-- > 0) {
        val (X, T, C) = readLine().split(' ').map { it.toInt() }
        map[X - T] = map.getOrDefault(X - T, 0) + C
        answer = map[X - T]?.coerceAtLeast(answer)!!
    }
    print(answer)
}