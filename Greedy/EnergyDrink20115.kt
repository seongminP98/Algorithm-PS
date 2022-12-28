import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val arr = Array<Double>(N) { 0.0 }
    val st = StringTokenizer(readLine())
    for (i in 0 until N) {
        arr[i] = st.nextToken().toDouble()
    }

    arr.sortDescending()
    var sum = arr[0]
    for (i in 1 until N) {
        sum += arr[i] / 2
    }
    print(sum)
}