import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HappyKindergarten13164 {
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

        int[] difference = new int[N - 1];
        for (int i = 1; i < N; i++) {
            difference[i - 1] = arr[i] - arr[i - 1];
        }
        Arrays.sort(difference);

        int sum = 0;
        /*
        N개 각각을 하나의 그룹이라고 생각하면
        1번 합치면 N-1개의 그룹이 되고,
        N-K번 합치면 K개의 그룹이 된다.
        */
        for (int i = 0; i < N - K; i++) {
            sum += difference[i];
        }
        System.out.println(sum);
    }
}
