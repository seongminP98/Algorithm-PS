import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BuildSnowman20366 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int answer = 2_000_000_000;
        for (int i = 0; i <= N - 4; i++) { // 겉 왼쪽
            for (int j = N - 1; j >= i + 3; j--) { // 겉 오른쪽
                int h1 = arr[i] + arr[j];
                int x = i + 1;
                int y = j - 1;

                while (x < y) {
                    int h2 = arr[x] + arr[y];
                    answer = Math.min(answer, Math.abs(h1 - h2));
                    if (h1 < h2) {
                        y--;
                    } else {
                        x++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
