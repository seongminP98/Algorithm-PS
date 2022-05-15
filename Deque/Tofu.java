import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Tofu {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = M; i <= N; i++) {
            dq.add(i);
        }
        for (int i = 1; i < M; i++) {
            dq.add(i);
        }
        int cnt = 3 - K;
        if (cnt < 0) { // 증가
            cnt = Math.abs(cnt);
            cnt %= N;
            while (cnt-- > 0) {
                dq.addLast(dq.pollFirst());
            }
            System.out.println(dq.pollFirst());
        } else if (cnt > 0) { // 감소
            cnt = Math.abs(cnt);
            cnt %= N;
            while (cnt-- > 1) {
                dq.addFirst(dq.pollLast());
            }
            System.out.println(dq.pollLast());
        } else {
            System.out.println(M);
        }
    }
}
