import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MineCraft18111 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum += arr[i][j];
            }
        }
        int time = sum * 2;
        int height = 0;
        sum += B;
        int avg = sum / (N * M);

        for (int h = 1; h <= avg; h++) {
            int t = 0;
            for (int[] ints : arr) {
                for (int anInt : ints) {
                    if (anInt < h) { // 심기 1초
                        t += (h - anInt);
                    } else { // 제거 2초
                        t += ((anInt - h) * 2);
                    }
                }
            }
            if (t <= time) {
                time = t;
                height = h;
            }
        }
        System.out.println(time + " " + height);

    }
}
