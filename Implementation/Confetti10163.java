import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Confetti10163 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[1002][1002];
        for (int t = 1; t <= N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            for (int i = x; i < x + width; i++) {
                for (int j = y; j < y + len; j++) {
                    arr[i][j] = t;
                }
            }
        }
        int[] answer = new int[N + 1];
        StringBuilder sb = new StringBuilder();

        for (int[] ints : arr) {
            for (int anInt : ints) {
                for (int v = 1; v <= N; v++) {
                    if (anInt == v) {
                        answer[v]++;
                        break;
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.print(sb);
    }
}
