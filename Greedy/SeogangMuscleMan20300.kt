import java.util.*
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val arr = Array<Long>(N) { 0 }
    val st = StringTokenizer(readLine())
    for (i in 0 until N) {
        arr[i] = st.nextToken().toLong()
    }

    arr.sort()
    var answer = 0L

    if (N % 2 == 1) {
        answer = arr[N - 1]
        for (i in 0..N / 2) {
            answer = max(answer, arr[i] + arr[N - 2 - i])
        }
    } else {
        for (i in 0..N / 2) {
            answer = max(answer, arr[i] + arr[N - 1 - i])
        }
    }
    print(answer)
}