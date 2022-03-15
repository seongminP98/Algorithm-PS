import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheaterSeats2302 {
    static int N, M;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dp = new int[41];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < 41; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int answer = 1;
        int num = 0;
        for (int i : arr) {
            int diff = i - num - 1;
            num = i;
            if(diff != 0)
                answer *= dp[diff];
        }
        if (num != N) {

            int diff = N - num;
            answer *= dp[diff];
        }

        System.out.println(answer);
    }
}
