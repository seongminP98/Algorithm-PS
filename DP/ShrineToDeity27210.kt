import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = Array(N) { 0 }
    for (i in 0 until N) {
        arr[i] = st.nextToken().toInt()
    }
    var max = 0
    var sum = 0
    for (i in arr) {
        val c = if (i == 1) 1 else -1
        sum += c
        max = max.coerceAtLeast(sum)
        if (sum < 0) sum = 0
    }

    sum = 0
    for (i in arr) {
        val c = if (i == 1) -1 else 1
        sum += c
        max = max.coerceAtLeast(sum)
        if (sum < 0) sum = 0
    }
    print(max)
}