import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ThreeSolutions2473 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long diff = Math.abs(arr[0] + arr[1] + arr[2]);
        long left = arr[1];
        long right = arr[2];
        long first = arr[0];
        for (int i = 0; i < N; i++) { // 첫번째 용액
            for (int j = i + 1; j < N; j++) { // 두번째 용액
                int l = j + 1;
                int r = N - 1;
                while (l <= r) {
                    int mid = (l + r) / 2; // 세번째 용액은 이분탐색으로
                    long sum = arr[i] + arr[j] + arr[mid];
                    if (Math.abs(sum) < diff) {
                        diff = Math.abs(sum);
                        first = arr[i];
                        left = arr[j];
                        right = arr[mid];
                    }
                    if (sum > 0) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }
        }
        System.out.println(first + " " + left + " " + right);
    }
}
