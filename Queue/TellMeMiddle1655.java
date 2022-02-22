import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class TellMeMiddle1655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(((o1, o2) -> {
            return o2 - o1;
        }));
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int next = Integer.parseInt(br.readLine());
            if (i % 2 == 1) {
                if (!minPq.isEmpty() && minPq.peek() < next) {
                    maxPq.offer(minPq.poll());
                    minPq.offer(next);
                } else {
                    maxPq.offer(next);
                }
            } else {
                if (!maxPq.isEmpty() && maxPq.peek() > next) {
                    minPq.offer(maxPq.poll());
                    maxPq.offer(next);
                } else {
                    minPq.offer(next);
                }
            }
            sb.append(maxPq.peek()).append('\n');
        }
        System.out.print(sb);
    }
}
