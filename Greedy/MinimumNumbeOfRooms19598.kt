package P19598

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val meeting = PriorityQueue<IntArray>(compareBy { it[0] })
    repeat(readLine().toInt()) {
        val (s, e) = readLine().split(' ').map { it.toInt() }
        meeting.add(intArrayOf(s, e))
    }

    val pq = PriorityQueue<IntArray>(compareBy { it[1] })
    var answer = 0
    while (!meeting.isEmpty()) {
        while (!pq.isEmpty() && !meeting.isEmpty()) {
            if (pq.peek()[1] <= meeting.peek()[0]) {
                pq.poll();
                pq.add(meeting.poll());
            } else {
                break;
            }
        }
        if (!meeting.isEmpty()) pq.add(meeting.poll())

        answer = answer.coerceAtLeast(pq.size);
    }
    print(answer)
}
