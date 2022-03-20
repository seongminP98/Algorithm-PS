import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfFactors17425 {
    static int MAX = 1000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] fx = new long[MAX]; // 각 인덱스의 모든 약수를 더한 값.
        long[] dp = new long[MAX];

        Arrays.fill(fx, 1);

        for (int i = 2; i < MAX; i++) { //MAX 이하 i의 배수에 i를 다 더해줌.
            for (int j = 1; i * j < MAX; j++) {
                fx[i * j] += i;
            }
        }

        for (int i = 1; i < MAX; i++) {
            dp[i] = dp[i - 1] + fx[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.print(sb);
    }
}
