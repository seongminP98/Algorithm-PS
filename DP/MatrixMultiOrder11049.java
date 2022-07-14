import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MatrixMultiOrder11049 {
    static int N;
    static int[][] arr;
    static int[][] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        d = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    d[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        System.out.println(dp(0, N - 1));
    }

    private static int dp(int s, int e) {
        if (d[s][e] != Integer.MAX_VALUE) {
            return d[s][e];
        }

        for (int i = s; i < e; i++) {
            d[s][e] = Math.min(d[s][e], dp(s, i) + dp(i + 1, e) + (arr[s][0] * arr[i][1] * arr[e][1]));
        }
        return d[s][e];
    }
}
