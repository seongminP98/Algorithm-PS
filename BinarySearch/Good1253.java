import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Good1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) { // '좋다' 확인 할 수
            loop:
            for (int j = 0; j < N; j++) { // 다른 두 수 중 첫번째
                if (i == j) {
                    continue;
                }
                int left = j + 1;
                int right = N - 1;
                while (left <= right) {
                    int mid = (left + right) / 2; // 다른 두 수 중 두번째 수의 인덱스
                    if (arr[j] + arr[mid] == arr[i] && mid != i) {
                        answer++;
                        break loop;
                    }
                    if (arr[j] + arr[mid] <= arr[i]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        System.out.println(answer);

    }
}
