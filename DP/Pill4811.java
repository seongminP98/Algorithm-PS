import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pill4811 {
    static long[][] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        d = new long[31][31];
        d[1][0] = 1;
        dp(30, 0);
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            System.out.println(d[n][0]);
        }
    }

    private static long dp(int one, int half) {
        if (d[one][half] != 0) {
            return d[one][half];
        } else if (half == 0) {
            return d[one][half] = dp(one - 1, half + 1);
        } else if (one == 0) {
            return 1;
        } else {
            return d[one][half] = dp(one - 1, half + 1) + dp(one, half - 1);
        }

    }
}
