import java.util.*
import kotlin.math.max

var N = 0
var M = 0
var tree = mutableListOf<MutableList<Int>>()
var visited = Array(5) { Array(5) { false } }
var max = 0
val dx = mutableListOf<Int>(1, 1, -1, -1)
val dy = mutableListOf<Int>(1, -1, 1, -1)
fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    for (i in 0 until N) {
        val line = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
        tree.add(line)
    }
    sol(0, 0)
    print(max)
}

fun sol(idx: Int, sum: Int) {
    if (idx == N * M) {
        max = max(max, sum)
        return
    }
    val x = idx / M
    val y = idx % M

    if (!visited[x][y]) {
        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0 until N && ny in 0 until M && !visited[nx][y] && !visited[x][ny]) {
                visited[x][y] = true
                visited[nx][y] = true
                visited[x][ny] = true
                sol(idx + 1, sum + tree[x][y] * 2 + tree[nx][y] + tree[x][ny])
                visited[x][y] = false
                visited[nx][y] = false
                visited[x][ny] = false
            }
        }
    }
    sol(idx + 1, sum)
}