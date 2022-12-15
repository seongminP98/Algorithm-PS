import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val arr = Array(N) { 0 }
    val st = StringTokenizer(readLine())
    for (i in 0 until N) {
        arr[i] = st.nextToken().toInt()
    }
    arr.sortDescending()
    var answer = 0

    if (N == 1) {
        answer = arr[0]
        arr[0] = 0
    }
    while (arr[0] > 0) {
        if (answer > 1440) break
        if (arr[1] > 0) {
            arr[0]--
            arr[1]--
            answer++;
        } else break
        arr.sortDescending()
    }
    answer += arr[0]
    if (answer > 1440) print(-1)
    else print(answer)
}