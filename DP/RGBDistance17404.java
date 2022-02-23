import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBDistance17404 {
    static int N;
    static int[][] arr;
    static int[][] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            d = new int[N][3];
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    d[0][i] = arr[0][i]; //첫번째 집에서 i 색 선택함. (012 RGB) 선택 안한 집은 무한대로 설정. 왜? 두번째 집에서 i 색을 선택하지 않으려고.
                } else {
                    d[0][j] = Integer.MAX_VALUE;
                }
            }

            for (int k = 0; k < 3; k++) {
                if (i != k) { //마지막 집은 첫번째 집과 색이 달라야함.
                    answer = Math.min(answer, dp(N - 1, k));
                }
            }
        }
        System.out.println(answer);


    }

    static int dp(int x, int color) {

        if (d[x][color] == 0) {
            if (color == 0) {
                int before = Math.min(dp(x - 1, 1), dp(x - 1, 2));
                if (before == Integer.MAX_VALUE)
                    d[x][0] = Integer.MAX_VALUE;
                else
                    d[x][0] = arr[x][0] + before;
            } else if (color == 1) {
                int before = Math.min(dp(x - 1, 0), dp(x - 1, 2));
                if (before == Integer.MAX_VALUE)
                    d[x][1] = Integer.MAX_VALUE;
                else
                    d[x][1] = arr[x][1] + before;
            } else {
                int before = Math.min(dp(x - 1, 0), dp(x - 1, 1));
                if (before == Integer.MAX_VALUE)
                    d[x][2] = Integer.MAX_VALUE;
                else
                    d[x][2] = arr[x][2] + before;
            }
        }


        return d[x][color];
    }
}
