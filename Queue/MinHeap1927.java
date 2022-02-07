import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MinHeap1927 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(br.readLine());
            if (next == 0) {
                if (pq.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(pq.poll());
                }
                sb.append('\n');
            } else {
                pq.add(next);
            }
        }
        System.out.print(sb);
    }
}
