import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14731 {
    private static final int DIV = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long c = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            long nc = (c * k) % DIV;
            long nk = k - 1;
            if (nk >= 1) {
                sum += (nc * pow(nk)) % DIV;
            } else {
                sum += nc;
            }
            sum %= DIV;
        }
        System.out.println(sum);
    }

    private static long pow(long k) {
        if (k == 1) {
            return 2;
        }
        long tmp = pow(k / 2);
        if (k % 2 == 0) {
            return tmp * tmp % DIV;
        } else {
            return (tmp * tmp % DIV) * 2 % DIV;
        }
    }
}
