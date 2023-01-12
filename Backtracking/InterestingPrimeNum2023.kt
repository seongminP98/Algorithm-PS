import java.lang.StringBuilder
import kotlin.math.sqrt

private var N = 0
private val sb = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    N = readLine().toInt()
    dfs(0, StringBuilder())
    print(sb)
}

private fun dfs(depth: Int, num: StringBuilder) {
    if (depth == N) {
        sb.append(num).append('\n')
        return
    }
    for (i in 0..9) {
        num.append(i)
        if (isPrime(num.toString().toInt())) {
            dfs(depth + 1, num)
        }
        num.deleteCharAt(num.length - 1)
    }
}

private fun isPrime(num: Int): Boolean {
    if (num == 0 || num == 1) return false
    for (i in 2..sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}