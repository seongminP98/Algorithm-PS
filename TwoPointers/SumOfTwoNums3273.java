import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumOfTwoNums3273 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int s = 0;
        int e = N - 1;

        int answer = 0;

        while (s < e) {
            int sum = arr[s] + arr[e];
            if (sum == X) {
                answer++;
                s++;
                e--;
            } else if (sum < X) {
                s++;
            } else {
                e--;
            }
        }
        System.out.println(answer);
        
    }
}
