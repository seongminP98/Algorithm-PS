import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CupRamen1781 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        Homework[] homework = new Homework[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            homework[i] = new Homework(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }
        Arrays.sort(homework);
        PriorityQueue<Homework> pq = new PriorityQueue<>(((o1, o2) -> Long.compare(o1.cupNum, o2.cupNum)));
        for (int i = 0; i < N; i++) {
            if (pq.size() < homework[i].deadLine) {
                pq.add(homework[i]);
            } else {
                if (pq.peek().cupNum < homework[i].cupNum) {
                    pq.poll();
                    pq.add(homework[i]);
                }
            }

        }
        while (!pq.isEmpty()) {
            answer += pq.poll().cupNum;
        }
        System.out.println(answer);
    }

    private static class Homework implements Comparable<Homework> {
        long deadLine, cupNum;

        @Override
        public String toString() {
            return "Homework{" +
                    "deadLine=" + deadLine +
                    ", cupNum=" + cupNum +
                    '}';
        }

        public Homework(long deadLine, long cupNum) {
            this.deadLine = deadLine;
            this.cupNum = cupNum;
        }

        @Override
        public int compareTo(Homework o) {
            if (deadLine == o.deadLine) {
                return Long.compare(o.cupNum, cupNum);
            }
            return Long.compare(deadLine, o.deadLine);
        }
    }
}
