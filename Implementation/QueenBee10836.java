import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QueenBee10836 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = 1;
            }
        }
        for (int i = 0; i < N; i++) {
            int r = M - 1;
            int c = 0;
            st = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            while (zero-- > 0) {
                if (r > 0) {
                    r--;
                } else {
                    c++;
                }
            }
            while (one-- > 0) {
                arr[r][c] += 1;
                if (r > 0) {
                    r--;
                } else {
                    c++;
                }
            }
            while (two-- > 0) {
                arr[r][c] += 2;
                if (r > 0) {
                    r--;
                } else {
                    c++;
                }
            }
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < M; j++) {
                arr[i][j] = Math.max(arr[i - 1][j - 1], Math.max(arr[i][j - 1], arr[i - 1][j]));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] ints : arr) {
            for (int anInt : ints) {
                sb.append(anInt).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
