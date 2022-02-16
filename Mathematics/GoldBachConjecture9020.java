import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= 10000; i++) {
            if (!isPrime[i])
                primes.add(i);
        }
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int value1 = 0;
            int value2 = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < primes.size(); i++) {
                if (primes.get(i) > n)
                    break;
                for (int j = i; j < primes.size(); j++) {
                    if (primes.get(j) > n)
                        break;

                    if (primes.get(i) + primes.get(j) == n) {
                        if (min > primes.get(j) - primes.get(i)) {
                            value1 = primes.get(i);
                            value2 = primes.get(j);
                        }
                    }
                }
            }
            sb.append(value1).append(" ").append(value2).append('\n');
        }
        System.out.println(sb);
    }
}
