import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5607 {
    static final int MOD = 1234567891;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long[] factorial = new long[1000001];
        factorial[0] = 1;
        for (int i = 1; i < 1000001; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            long A = factorial[N];
            long B = factorial[N - R] * factorial[R] % MOD;

            long pow = pow(B, MOD - 2);
            sb.append(A * pow % MOD).append('\n');
        }
        System.out.print(sb);
    }

    static long pow(long A, long B) {
        if (B == 1) return A % MOD;

        long temp = pow(A, B / 2);
        if (B % 2 == 0) {
            return temp * temp % MOD;
        } else {
            return (temp * temp % MOD) * A % MOD;
        }
    }
}
