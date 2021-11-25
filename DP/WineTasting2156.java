import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WineTasting2156 {
    static int[][] d;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        d = new int[n + 1][2];  //[i][0] : i번째 잔을 안마셨을 때, [i][1] : i번째 잔을 마셨을 때

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                d[1][1] = arr[1];
            } else {
                d[i][0] = Math.max(d[i - 1][0], d[i - 1][1]);
                d[i][1] = Math.max(d[i - 2][0] + arr[i - 1], d[i - 1][0]) + arr[i];
            }
        }

        System.out.println(Math.max(d[n][0], d[n][1]));
    }
}
/**
 * 1. n번째 잔을 마셨을 때 : n-2를 안마시고 n-1을 마심 or n-1를 안마심. 둘 중 큰 값 + n번째 잔
 * 2. n번째 잔을 안 마셨을 때 : n-1을 마심 or n-1를 안마심. 둘 중 큰 값.
 */
