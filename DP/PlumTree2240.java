import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PlumTree2240 {
    static int T, W;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[T + 1][W + 1];

        for (int i = 1; i <= T; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j <= W; j++) {
                if (j == 0) { // 1번 나무 (처음 위치가 1번 나무)
                    if (num == 1) { // 먹을 수 있으니
                        arr[i][j] = arr[i - 1][j] + 1;
                    } else { // 못먹으니
                        arr[i][j] = arr[i - 1][j];
                    }
                    continue;
                }

                if (j % 2 == 1) { // 2번 나무
                    if (num == 1) {
                        arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - 1] + 1);
                    } else {
                        arr[i][j] = Math.max(arr[i - 1][j] + 1, arr[i - 1][j - 1]);
                    }
                } else { // 1번 나무
                    if (num == 1) {
                        arr[i][j] = Math.max(arr[i - 1][j] + 1, arr[i - 1][j - 1]);

                    } else {
                        arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - 1] + 1);

                    }
                }
            }
        }

        int answer = 0;
        for (int i : arr[T]) {
            if (answer < i) answer = i;
        }
        System.out.println(answer);


    }

}
