import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LevelHamburger16974 {
    static int N;
    static long X;
    static long[] h; //각 레벨에서의 햄버거 길이
    static long[] p; //각 레벨에서의 패티 개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken());
        h = new long[N + 1];
        p = new long[N + 1];
        h[0] = 1;
        p[0] = 1;
        for (int i = 1; i <= N; i++) {
            h[i] = h[i - 1] * 2 + 3;
            p[i] = p[i - 1] * 2 + 1;
        }
        System.out.println(solve(X, N));
    }

    static long solve(long x, int n) {
        if (n == 0) {
            if (x == 0) return 0;
            return 1;
        }
        if (x == 1) {//패티 없음.
            return 0;
        } else if (x <= h[n] / 2) { //중간 패티보다 작으면
            return solve(x - 1, n - 1);
        } else if (x == h[n] / 2) { //중간 패티-1
            return p[n - 1];
        } else if (x == h[n] / 2 + 1) { //중간 패티
            return p[n - 1] + 1;
        } else if (x > h[n] / 2) { //중간 패티보다 크면
            return solve(x - (h[n - 1] + 2), n - 1) + p[n - 1] + 1;
        } else {//(x == h[n])
            return p[n];
        }
    }
}
