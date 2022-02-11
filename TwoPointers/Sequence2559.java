import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sequence2559 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int len = N - K + 1;
        int[] sum = new int[len];
        for (int i = 0; i < K; i++) {
            sum[0] += arr[i];
        }
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + arr[K + i - 1] - arr[i - 1];
        }
        int answer = sum[0];
        for (int i : sum) {
            answer = Math.max(answer, i);
        }
        System.out.println(answer);
    }
}
