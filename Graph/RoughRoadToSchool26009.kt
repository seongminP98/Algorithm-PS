import java.util.*
import kotlin.system.exitProcess

private var N: Int = 0
private var M: Int = 0
private var arr: Array<BooleanArray>? = null
private val dx = arrayOf(1, -1, 0, 0)
private val dy = arrayOf(0, 0, 1, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    arr = Array(N + 1) { BooleanArray(M + 1) }

    var K = readLine().toInt()
    while (K-- > 0) {
        val (r, c, d) = readLine().split(" ")
        trafficJam(r.toInt(), c.toInt(), d.toInt())
    }
    bfs()
    print("NO")
}

private fun bfs() {
    val q = LinkedList<Node>()
    q.add(Node(1, 1, 0))
    while (!q.isEmpty()) {
        val c = q.poll()
        if (c.x == N && c.y == M) {
            println("YES")
            print(c.cnt)
            exitProcess(0)
        }
        for (i in 0 until 4) {
            val nx = c.x + dx[i]
            val ny = c.y + dy[i]
            if (nx in 1..N && ny in 1..M && !arr!![nx][ny]) {
                arr!![nx][ny] = true
                q.add(Node(nx, ny, c.cnt + 1))
            }
        }
    }
}

private fun trafficJam(r: Int, c: Int, d: Int) {
    arr!![r][c] = true
    var x = 0
    for (i in r - d..r) {
        if (i in 1..N && c - x in 1..M) arr!![i][c - x] = true
        if (i in 1..N && c + x in 1..M) arr!![i][c + x] = true
        x++
    }
    x -= 2
    for (i in r + 1..r + d) {
        if (i in 1..N && c - x in 1..M) arr!![i][c - x] = true
        if (i in 1..N && c + x in 1..M) arr!![i][c + x] = true
        x--
    }
}

private data class Node(var x: Int, var y: Int, var cnt: Int)
