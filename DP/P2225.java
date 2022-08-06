import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2225 {
    static int N, K;
    static int[][] d;
    static final int DIV = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        d = new int[K + 1][N + 1];
        for (int i = 1; i <= K; i++) {
            d[i][1] = i;
        }

        System.out.println(dp(K,N));
    }

    private static int dp(int k, int n) {
        if (d[k][n] != 0) {
            return d[k][n];
        }
        if(k==0 || n==0) return 0;
        return d[k][n] = (dp(k - 1,n) + dp(k,n - 1)) % DIV;
    }
}
