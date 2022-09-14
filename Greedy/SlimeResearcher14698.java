import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SlimeResearcher14698 {
    static final long DIV = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long answer = 1;
            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();
                long mul = a * b;
                pq.add(mul);
                mul %= DIV;
                answer *= mul;
                answer %= DIV;
            }
            System.out.println(answer);
        }
    }
}
