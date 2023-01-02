import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OrderOfPermutations1722 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        long[] fac = new long[N + 1];
        fac[0] = fac[1] = 1;
        for (int i = 1; i < N + 1; i++) {
            fac[i] = fac[i - 1] * i;
        }
        int[] arr = new int[N];

        if (num == 1) {
            long k = Long.parseLong(st.nextToken());
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (visited[j]) continue;
                    if (fac[N - i - 1] < k) {
                        k -= fac[N - i - 1];
                    } else {
                        arr[i] = j;
                        visited[j] = true;
                        break;
                    }
                }
            }
            for (int i : arr) {
                System.out.print(i + " ");
            }
        } else {
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long answer = 1L;
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < arr[i]; j++) {
                    if (visited[j]) continue;
                    answer += fac[N - i - 1];
                }
                visited[arr[i]] = true;
            }
            System.out.println(answer);

        }

    }

}
