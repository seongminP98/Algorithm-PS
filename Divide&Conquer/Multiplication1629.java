import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Multiplication1629 {
    static long A, B, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.println(solve(B));

    }

    static long solve(long b) {
        if (b == 1) {
            return A % C;
        }
        long temp = solve(b / 2);
        if (b % 2 == 0) {
            return temp * temp % C;
        } else {
            return (temp * temp % C) * A % C;
        }
    }
}
