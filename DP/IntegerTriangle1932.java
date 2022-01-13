import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntegerTriangle1932 {
    static int n;
    static int[][] arr;
    static int[][] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        d = new int[n + 1][n + 1];
        d[0][0] = 0;
        d[1][1] = arr[1][1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i + 1; j++) {
                d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + arr[i][j];
            }
        }
        int answer = 0;
        for (int[] ints : d) {
            for (int anInt : ints) {
                answer = Math.max(answer, anInt);
            }
        }
        System.out.println(answer);
    }

}
