import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var T = 0
    val tetris = arrayOf(
            arrayOf(arrayOf(0, 0, 0, 0), arrayOf(0, 1, 2, 3)),
            arrayOf(arrayOf(0, 1, 2, 3), arrayOf(0, 0, 0, 0)),
            arrayOf(arrayOf(0, 0, 1, 1), arrayOf(0, 1, 1, 2)),
            arrayOf(arrayOf(0, 1, 1, 2), arrayOf(0, 0, -1, -1)),
            arrayOf(arrayOf(0, 0, 0, 1), arrayOf(0, 1, 2, 2)),
            arrayOf(arrayOf(0, 1, 2, 2), arrayOf(0, 0, 0, -1)),
            arrayOf(arrayOf(0, 1, 1, 1), arrayOf(0, 0, 1, 2)),
            arrayOf(arrayOf(0, 0, 1, 2), arrayOf(0, 1, 0, 0)),
            arrayOf(arrayOf(0, 1, 1, 1), arrayOf(0, -1, 0, 1)),
            arrayOf(arrayOf(0, 1, 1, 2), arrayOf(0, 0, 1, 0)),
            arrayOf(arrayOf(0, 0, 0, 1), arrayOf(0, 1, 2, 1)),
            arrayOf(arrayOf(0, 1, 1, 2), arrayOf(0, -1, 0, 0)),
            arrayOf(arrayOf(0, 0, 1, 1), arrayOf(0, 1, 1, 0))
    )
    while (true) {
        T++
        val N = readLine().trim().toInt()
        if (N == 0) break
        val arr = Array(N) { Array(N) { 0 } }
        for (i in 0 until N) {
            val st = StringTokenizer(readLine())
            for (j in 0 until N) {
                arr[i][j] = st.nextToken().trim().toInt()
            }
        }

        var max = Integer.MIN_VALUE
        for (i in 0 until N) {
            for (j in 0 until N) {
                for (t in tetris.indices) {
                    var sum = 0
                    var flag = true

                    for (k in 0 until 4) {
                        val nx = i + tetris[t][0][k]
                        val ny = j + tetris[t][1][k]
                        if (nx in 0 until N && ny in 0 until N) {
                            sum += arr[nx][ny]
                        } else {
                            flag = false
                            break
                        }
                    }
                    if (flag) {
                        max = max.coerceAtLeast(sum)
                    }
                }
            }
        }
        println("$T. $max")
    }
}