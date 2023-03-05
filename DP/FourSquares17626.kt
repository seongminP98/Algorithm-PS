import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = Array(n + 1) { 0 }
    dp[1] = 1
    for (i in 1..n) {
        var min = 50000
        for (j in 1..sqrt(i.toDouble()).toInt()) {
            min = min.coerceAtMost(dp[i - j * j] + 1)
        }
        dp[i] = min
    }
    print(dp[n])
}
