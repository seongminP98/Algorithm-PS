import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 신발끈 공식
// https://ko.wikipedia.org/wiki/%EC%8B%A0%EB%B0%9C%EB%81%88_%EA%B3%B5%EC%8B%9D
public class AreaOfPolygon2166 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        double answer = Math.abs(sum1 - sum2) / 2.0;
        System.out.printf("%.1f%n", answer);
    }
}
