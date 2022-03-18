import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2467 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        long diff = Math.abs(arr[0] + arr[1]);
        long left = arr[0];
        long right = arr[1];
        for (int i = 0; i < N; i++) {
            int l = i + 1;
            int r = N - 1;

            while (l <= r) {
                int mid = (l + r) / 2;
                long sum = arr[i] + arr[mid];
                if (Math.abs(sum) < diff) {
                    diff = Math.abs(sum);
                    left = arr[i];
                    right = arr[mid];
                }
                if (sum > 0) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
                sum = arr[i] + arr[mid];
                diff = Math.min(diff, Math.abs(sum));
            }
        }
        System.out.println(left + " " + right);
    }
}
