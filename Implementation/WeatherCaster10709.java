import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WeatherCaster10709 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[][] cloud = new char[H][W];
        int[][] arr = new int[H][W];
        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                cloud[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < H; i++) {
            Arrays.fill(arr[i], -1);
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (cloud[i][j] == 'c') {
                    arr[i][j] = 0;
                    int time = 1;
                    for (int k = j + 1; k < W; k++) {
                        arr[i][k] = time++;
                    }
                }
            }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
