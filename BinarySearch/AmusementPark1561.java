import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AmusementPark1561 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] time = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        if (N <= M) {
            System.out.println(N);
            return;
        }
        long right = 60000000000L; // 20억명 놀이기구 1개 운행시간30분
        long left = 1L;
        N -= M;
        long beforeTime = 0;
        long afterTime = 0;
        long count = 0;
        while (left < right) {
            long mid = (left + right) / 2;
            long t = mid - 1;
            long sumBefore = 0L;
            long sumAfter = 0L;

            for (int i : time) {
                sumBefore += (t / i);
                sumAfter += (mid / i);
            }

            if (sumBefore < N && N <= sumAfter) {
                beforeTime = t;
                afterTime = mid;
                count = N - sumBefore;
                break;
            }

            if (sumBefore < N) {
                left = mid;
            } else {
                right = mid;
            }
        }
        for (int i = 0; i < M; i++) {
            if (afterTime / time[i] > beforeTime / time[i]) {
                count--;
                if (count == 0) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
    }
}
