import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Friend1058 {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'Y') {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 9999;
                }
            }
        }

        for (int k = 0; k < n; k++) { //기준
            for (int i = 0; i < n; i++) { //시작
                for (int j = 0; j < n; j++) { //도착
                    if (k == i || i == j || j == k)
                        continue;

                    if (arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] <= 2)
                    sum++;
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}
