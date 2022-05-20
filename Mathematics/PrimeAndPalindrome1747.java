import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrimeAndPalindrome1747 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) N++;
        while (true) {
            if (isPrime(N) && isPalindrome(N)) {
                System.out.println(N);
                System.exit(0);
            }
            N++;
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(int n) {
        String s = Integer.toString(n);
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
