import java.io.BufferedReader;
import java.io.InputStreamReader;


public class GoldBachConjecture9020 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[10001]; //false 면 소수
        for (int i = 2; i * i < 10001; i++) {
            if (!isPrime[i]) {
                for (int j = i * 2; j < 10001; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int p = n/2;
            int q = n/2;
            while(true) {
                if(!isPrime[p] && !isPrime[q]) {
                    sb.append(p).append(" ").append(q).append('\n');
                    break;
                }
                p--;
                q++;
            }
        }
        System.out.println(sb);
    }
}
