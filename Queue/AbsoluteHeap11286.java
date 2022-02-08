import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class AbsoluteHeap11286 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> {
            if (Math.abs(o1) == (Math.abs(o2))) {
                return o1 - o2;
            }
            return Math.abs(o1) - Math.abs(o2);
        }));
        while (N-- > 0) {
            int cal = Integer.parseInt(br.readLine());
            if (cal == 0) {
                if (pq.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(pq.poll());
                }
                sb.append('\n');
            } else {
                pq.offer(cal);
            }
        }
        System.out.print(sb);
    }
}
