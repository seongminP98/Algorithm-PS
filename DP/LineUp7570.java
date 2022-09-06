import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LineUp7570 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[num] = arr[num - 1] + 1;
        }
        Arrays.sort(arr);
        System.out.println(N - arr[N]);
//        dp[n] = n번호일때까지 연속된 증가수열의 개수
//        => dp[n] = dp[n - 1] + 1
    }
}
