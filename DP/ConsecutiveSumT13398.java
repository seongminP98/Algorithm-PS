import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ConsecutiveSumT13398 {
    static int N;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[2][N];
        dp[0][0] = arr[0];
        dp[1][0] = arr[0];
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < 2; i++) {
                //제거x
                dp[0][j] = Math.max(dp[0][j - 1] + arr[j], arr[j]);
                //제거o (제거 하는 것과 안하는 것 중 큰 것 선택)
                dp[1][j] = Math.max(dp[0][j - 1], dp[1][j - 1] + arr[j]);
            }
        }
        int answer = arr[0];
        for (int[] ints : dp) {
            for (int anInt : ints) {
                answer = Math.max(answer, anInt);
            }
        }
        System.out.println(answer);
    }
}
