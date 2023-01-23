import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val X = st.nextToken().toInt()
    st = StringTokenizer(readLine())
    val arr = Array(N + 1) { 0 }

    for (i in 1..N) {
        arr[i] = arr[i - 1] + st.nextToken().toInt()
    }
    var max = 0
    var cnt = 0
    for (i in X..N) {
        val c = arr[i] - arr[i - X]

        if (max < c) {
            cnt = 1
            max = c
        } else if (max == c) {
            cnt++
        }
    }
    if (max == 0) print("SAD") else print("$max\n$cnt")
}