package p10282

import java.util.PriorityQueue

data class Node(val index: Int, val dis: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.dis.compareTo(other.dis)
    }
}

lateinit var graph: ArrayList<ArrayList<Node>>
lateinit var distance: Array<Int>
fun main() = with(System.`in`.bufferedReader()) {
    var t = readLine().toInt()
    val answer = StringBuilder()
    while (t-- > 0) {
        val (n, d, c) = readLine().split(" ").map { it.toInt() }

        graph = ArrayList()

        for (i in 0..n) {
            graph.add(ArrayList())
        }

        for (i in 0 until d) {
            val (a, b, s) = readLine().split(" ").map { it.toInt() }
            graph[b].add(Node(a, s))
        }
        distance = Array(10001) { Int.MAX_VALUE }

        dijkstra(c)
        var cnt = 0
        var result = 0

        for (i in 1..n) {
            if (distance[i] != Int.MAX_VALUE) {
                cnt++
                result = result.coerceAtLeast(distance[i])
            }
        }
        answer.append("$cnt $result\n")
    }
    print(answer)
}

private fun dijkstra(start: Int) {
    val pq = PriorityQueue<Node>()
    pq.add(Node(start, 0))
    distance[start] = 0
    while (!pq.isEmpty()) {
        val node = pq.poll()
        val dis = node.dis
        val c = node.index
        if (distance[c] < dis) {
            continue
        }
        for (i in 0 until graph[c].size) {
            val cost = distance[c] + graph[c][i].dis

            if (cost < distance[graph[c][i].index]) {
                distance[graph[c][i].index] = cost
                pq.add(Node(graph[c][i].index, cost))
            }
        }
    }
}
