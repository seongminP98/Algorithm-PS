import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommonSubstring5582 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] dp = new int[str1.length()][str2.length()];
        int max = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (j == 0 || i == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}
