import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WhyCowCrossRoad14465 {
    static int N, K, B;
    static int[] arr;
    static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        for (int i = 0; i < B; i++) {
            arr[Integer.parseInt(br.readLine())] = 1;
        }
        answer = new int[N - K + 2];
        for (int i = 1; i <= K; i++) {
            answer[1] += arr[i];
        }
        int min = answer[1];
        for (int i = 2; i < answer.length; i++) {
            answer[i] = answer[i - 1] - arr[i - 1] + arr[i + K - 1];
            min = Math.min(min, answer[i]);
        }
        System.out.println(min);
    }
}
