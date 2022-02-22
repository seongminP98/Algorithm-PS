import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FindMedian2696 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            PriorityQueue<Integer> maxPq = new PriorityQueue<>(((o1, o2) -> {
                return o2 - o1;
            }));
            PriorityQueue<Integer> minPq = new PriorityQueue<>();

            int N = Integer.parseInt(br.readLine());

            sb.append(N / 2 + 1).append('\n');

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                if (i != 1 && i % 10 == 1) {
                    st = new StringTokenizer(br.readLine());
                }
                int next = Integer.parseInt(st.nextToken());
                if (i != 1 && i % 20 == 1) {
                    sb.append('\n');
                }
                if (i % 2 == 1) {
                    if (!minPq.isEmpty() && next > minPq.peek()) {
                        maxPq.offer(minPq.poll());
                        minPq.offer(next);
                    } else {
                        maxPq.offer(next);
                    }
                    sb.append(maxPq.peek()).append(" ");
                } else {
                    if (!maxPq.isEmpty() && next < maxPq.peek()) {
                        minPq.offer(maxPq.poll());
                        maxPq.offer(next);
                    } else {
                        minPq.offer(next);
                    }
                }
            }
            sb.append('\n');

        }
        System.out.print(sb);
    }
}
