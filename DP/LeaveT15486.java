import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LeaveT15486 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Consulting[] arr = new Consulting[N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Consulting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        arr[N] = new Consulting(0, 0);
        int[] dp = new int[N + 1];
        int max = 0;
        for (int i = 0; i <= N; i++) {
            int day = i + arr[i].T;
            if (dp[i] > max) {
                max = dp[i];
            }
            if (day < N + 1)
                dp[day] = Math.max(dp[day], arr[i].P + max);
        }

        System.out.println(max);

    }

    static class Consulting {
        int T, P;

        public Consulting(int t, int p) {
            T = t;
            P = p;
        }
    }
}
