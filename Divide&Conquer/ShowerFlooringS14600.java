import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ShowerFlooringS14600 {
    static int waterspoutY, waterspoutX;
    static int[][] arr;
    static int cnt = 1;
    static int check = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        waterspoutY = Integer.parseInt(st.nextToken()) - 1;
        waterspoutX = (int) Math.pow(2, K) - Integer.parseInt(st.nextToken());
        arr = new int[(int) Math.pow(2, K)][(int) Math.pow(2, K)];
        solve(K, 0, 0);
        if (K == 2) {
            for (int i = 1; i <= 2; i++) {
                for (int j = 1; j <= 2; j++) {
                    if (arr[i][j] != check && arr[i][j] != -1) {
                        arr[i][j] = 5;
                    }
                }
            }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void solve(int K, int sx, int sy) {
        if (K == 1) {
            for (int i = sx; i < sx + 2; i++) {
                for (int j = sy; j < sy + 2; j++) {
                    if (i == waterspoutX && j == waterspoutY) {
                        arr[i][j] = -1;
                        check = cnt;
                    } else {
                        arr[i][j] = cnt;
                    }
                }
            }
            cnt++;
            return;
        }
        int d = (int) Math.pow(2, K - 1);
        solve(K-1, sx, sy);
        solve(K-1, sx, sy + d);
        solve(K-1, sx + d, sy);
        solve(K-1, sx + d, sy + d);
    }
}
