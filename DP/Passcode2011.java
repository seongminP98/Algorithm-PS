import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Passcode2011 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pwd = br.readLine();
        int[] dp = new int[pwd.length() + 1];
        dp[0] = dp[1] = 1;
        if (pwd.charAt(0) == '0') {
            System.out.println(0);
            return;
        }
        if (pwd.length() < 2) {
            System.out.println(1);
            return;
        } else {
            for (int i = 1; i < pwd.length(); i++) {
                if (pwd.charAt(i) == '0') {
                    if (pwd.charAt(i - 1) != '1' && pwd.charAt(i - 1) != '2') {
                        System.out.println(0);
                        return;
                    }
                }
                if (pwd.charAt(i - 1) == '1') {
                    if (pwd.charAt(i) == '0') {
                        dp[i + 1] = dp[i - 1] % 1000000;
                    } else {
                        dp[i + 1] = (dp[i] + dp[i - 1]) % 1000000;
                    }
                } else if (pwd.charAt(i - 1) == '2') {
                    if (pwd.charAt(i) - '0' <= 6 && pwd.charAt(i) != '0') {
                        dp[i + 1] = (dp[i] + dp[i - 1]) % 1000000;
                    } else {
                        dp[i + 1] = dp[i - 1] % 1000000;
                    }
                } else {
                    dp[i + 1] = dp[i] % 1000000;
                }
            }
        }
        System.out.println(dp[pwd.length()]);
    }
}
