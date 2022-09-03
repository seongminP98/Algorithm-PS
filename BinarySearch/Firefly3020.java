import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Firefly3020 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] stalagmite = new int[H + 1]; // 석순
        int[] stalactite = new int[H + 1]; // 종유석
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            if (i % 2 == 0) { // 석순
                stalagmite[h]++;
            } else { // 종유석
                stalactite[H - h + 1]++;
            }
        }
        int[] accStalagmite = new int[H + 2];
        int[] accStalactite = new int[H + 1];
        for (int i = H; i > 0; i--) {
            accStalagmite[i] = accStalagmite[i + 1] + stalagmite[i];
        }
        for (int i = 1; i <= H; i++) {
            accStalactite[i] = accStalactite[i - 1] + stalactite[i];
        }

        int[] result = new int[H + 1];
        for (int i = 1; i <= H; i++) {
            result[i] = accStalagmite[i] + accStalactite[i];
        }
        int min = N / 2;
        int cnt = 0;
        for (int i = 1; i <= H; i++) {
            min = Math.min(min, result[i]);
        }
        for (int i = 1; i <= H; i++) {
            if (result[i] == min) {
                cnt++;
            }
        }
        System.out.println(min + " " + cnt);
    }
}
