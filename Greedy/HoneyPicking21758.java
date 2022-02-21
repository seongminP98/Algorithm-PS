import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HoneyPicking21758 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sum = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i == 0)
                sum[i] = arr[i];
            else {
                sum[i] = sum[i - 1] + arr[i];
            }
        }
        //벌 통 벌
        int maxT = 0;
        for (int i = 1; i < N - 1; i++) {
            maxT = Math.max(maxT, arr[i]);
        }
        int answer = sum[N - 2] - arr[0] + maxT;

        //벌 벌 통
        int tmp = sum[N - 1] - arr[0];
        for (int i = 1; i < N; i++) {
            answer = Math.max((tmp - arr[i]) + (sum[N - 1] - sum[i]), answer);
        }

        //통 벌 벌
        tmp = sum[N - 1] - arr[N - 1];
        for (int i = 1; i < N - 1; i++) {
            answer = Math.max((tmp - arr[i]) + (sum[i - 1]), answer);
        }
        System.out.println(answer);
    }
}
