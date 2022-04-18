import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Thief13422 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            for (int i = 0; i < M; i++) {
                sum += arr[i];
            }
            int ans = sum < K ? 1 : 0;
            int j = M;
            j %= N;
            if (N > M) {
                for (int i = 0; i < N - 1; i++) {
                    sum -= arr[i];
                    sum += arr[j++];
                    j %= N;
                    if (sum < K) ans++;
                }
            }
            /*
             * N == M 일 때 예외
             * 1
             * 3 3 5
             * 1 1 1
             */

            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
