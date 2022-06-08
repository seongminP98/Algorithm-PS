import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CommonMeasure2436 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken()); // 최대공약수
        long B = Long.parseLong(st.nextToken()); // 최소공배수
        long mul = A * B; // == x*y
        long x = A;
        long y = B;

        // 최대공약수(A)의 배수 확인(x,y 는 A를 무조건 A를 공약수로 가져야 함). mul % i == 0 인 수 확인.
        for (int i = (int) A; i <= Math.sqrt(mul); i += A) {
            if (mul % i == 0 && gcd(i, mul / i) == A) {
                x = i;
                y = mul / i;
            }
        }
        System.out.println(x + " " + y);
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
