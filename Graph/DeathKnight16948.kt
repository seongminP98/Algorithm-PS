package P16948

import java.util.LinkedList
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val start = Node(st.nextToken().toInt(), st.nextToken().toInt(), 0)
    val goal = Node(st.nextToken().toInt(), st.nextToken().toInt(), 0)

    val dx = arrayOf(-2, -2, 0, 0, 2, 2)
    val dy = arrayOf(-1, 1, -2, 2, -1, 1)
    val visited = Array(n) { BooleanArray(n) }
    visited[start.x][start.y] = true

    val q = LinkedList<Node>()
    q.add(start)
    while (!q.isEmpty()) {
        val c = q.poll()
        if (c.x == goal.x && c.y == goal.y) {
            print(c.move)
            return
        }
        for (i in 0 until 6) {
            val nx = c.x + dx[i]
            val ny = c.y + dy[i]
            if (nx in 0 until n && ny in 0 until n && !visited[nx][ny]) {
                visited[nx][ny] = true
                q.add(Node(nx, ny, c.move + 1))
            }
        }
    }
    print(-1)

}

data class Node(val x: Int, val y: Int, val move: Int)
