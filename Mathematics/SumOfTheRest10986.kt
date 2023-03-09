package p10986

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { 0 }
    val st = StringTokenizer(readLine())
    arr[0] = st.nextToken().toInt() % m
    for (i in 1 until n) {
        arr[i] = (st.nextToken().toInt() % m + arr[i - 1]) % m
    }
    var count = 0
    val rest = Array(m) { 0L }
    for (i in arr) {
        rest[i]++
        if (i == 0) count++
    }
    var answer = 0L

    answer += count
    for (i in 0 until m) {
        answer += rest[i] * (rest[i] - 1) / 2
    }
    print(answer)
}
