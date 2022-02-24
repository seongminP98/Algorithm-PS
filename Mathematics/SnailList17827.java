import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SnailList17827 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < M; t++) {
            int K = Integer.parseInt(br.readLine());
            if (K >= N) {
                int c = N - V + 1; //반복되는 부분 길이
                K -= (V - 1); //반복되지 않는 크기만큼 빼줌.
                K = K % c + V - 1; //V-1부터 반복되니까.
            }

            sb.append(arr[K]).append('\n');
        }
        System.out.print(sb);

    }
}
