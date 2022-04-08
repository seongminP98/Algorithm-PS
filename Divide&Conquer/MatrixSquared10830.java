import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MatrixSquared10830 {
    static int N;
    static long B;
    static long[][] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        A = new long[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Long.parseLong(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        long[][] solve = solve(B);
        for (long[] longs : solve) {
            for (long aLong : longs) {
                aLong %= 1000;
                sb.append(aLong).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static long[][] solve(long b) {
        if (b == 1) {
            return A;
        }
        long[][] temp = solve(b / 2);
        long[][] result = new long[N][N];
        if (b % 2 == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int p = 0; p < N; p++) {
                        result[i][j] += (temp[i][p] * temp[p][j]);
                    }
                    result[i][j] %= 1000;
                }
            }
            return result;
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int p = 0; p < N; p++) {
                        result[i][j] += (temp[i][p] * temp[p][j]);
                    }
                    result[i][j] %= 1000;
                }
            }
            long[][] result2 = new long[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int p = 0; p < N; p++) {
                        result2[i][j] += (result[i][p] * A[p][j]);
                    }
                    result2[i][j] %= 1000;
                }
            }
            return result2;
        }
    }
}
