import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PickNumber2230 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int i = 0;
        int j = 0;
        int answer = Integer.MAX_VALUE;
        while (true) {
            if (j >= N || i > j) {
                break;
            }
            if (arr[j] - arr[i] > M) {
                answer = Math.min(answer, arr[j] - arr[i]);
                i++;
            } else if (arr[j] - arr[i] == M) {
                answer = M;
                break;
            } else {
                j++;
            }
        }
        System.out.println(answer);

    }
}
