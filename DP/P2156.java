import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2156 {
    static int N;
    static int[] arr;
    static int[][] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        d = new int[N + 1][2];
        d[1][0] = arr[1];
        for (int i = 2; i <= N; i++) {
            d[i][0] = Math.max(d[i - 2][0], d[i - 2][1] + arr[i - 1]) + arr[i]; // 먹었을 때
            d[i][1] = Math.max(d[i - 1][0], d[i - 1][1]); //안 먹었을 때
        }
        System.out.println(Math.max(d[N][0], d[N][1]));
    }
}
