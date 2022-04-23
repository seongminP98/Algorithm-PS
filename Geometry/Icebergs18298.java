import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 신발끈 공식. 볼록한 다각형, 오목한 다각형 모두에서 사용가능.
public class Icebergs18298 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        double answer = 0;
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long[] x = new long[N + 1];
            long[] y = new long[N + 1];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
            }
            x[N] = x[0];
            y[N] = y[0];
            long sum1 = 0;
            long sum2 = 0;

            for (int i = 0; i < N; i++) {
                sum1 += x[i] * y[i + 1];
                sum2 += x[i + 1] * y[i];
            }

            answer += Math.abs(sum1 - sum2) / 2.0;
        }
        
        System.out.println((long) answer);
    }
}
