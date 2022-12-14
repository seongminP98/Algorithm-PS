import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val q: Queue<Int> = LinkedList()
    for (i in 1..N) {
        q.add(i)
    }
    val sb = StringBuilder()
    while (q.size > 1) {
        sb.append(q.poll()).append(' ')
        q.add(q.poll())
    }
    sb.append(q.poll())
    print(sb)
}