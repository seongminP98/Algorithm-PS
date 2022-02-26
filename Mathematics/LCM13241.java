import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LCM13241 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        if (A < B) {
            long tmp = A;
            A = B;
            B = tmp;
        }
        long gcd = GCD(A, B);
        System.out.println((A / gcd) * (B / gcd) * gcd);

    }

    static long GCD(long b, long s) {
        long r = b % s;
        if (r == 0) {
            return s;
        }
        return GCD(s, r);
    }
}
