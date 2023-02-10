import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n + 1) { Array(n + 1) { n } }
    while (true) {
        val st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        if (a == -1) break
        arr[a][b] = 1
        arr[b][a] = 1
    }
    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                arr[i][j] = arr[i][j].coerceAtMost(arr[i][k] + arr[k][j])
            }
        }
    }
    var min = n
    val result = Array(n + 1) { n }
    for (i in 1..n) {
        var max = 0
        for (j in 1..n) {
            if (i == j) continue
            max = max.coerceAtLeast(arr[i][j])
        }
        min = min.coerceAtMost(max)
        result[i] = max
    }
    var count = 0
    for (i in result) {
        if (i == min) count++
    }
    println("$min $count")
    for (i in 1..n) {
        if (result[i] == min) print("$i ")
    }
}
