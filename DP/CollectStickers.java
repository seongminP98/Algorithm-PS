import java.util.Arrays;

public class CollectStickers {
    static int[][] dp;
    static int[][] dp2;

    public static void main(String[] args) {
        int[] sticker = {1};
        System.out.println(solution(sticker));
    }

    private static int solution(int[] sticker) {
        if (sticker.length == 1) {
            return sticker[0];
        }
        dp = new int[sticker.length][2];

        dp[0][0] = sticker[0];
        for (int i = 1; i < sticker.length; i++) {
            dp[i][0] = sticker[i] + dp[i - 1][1]; // i번째 뽑
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]); // i번째 안뽑
        }

        dp2 = new int[sticker.length][2];
        for (int i = 1; i < sticker.length; i++) {
            dp2[i][0] = sticker[i] + dp2[i - 1][1]; // i번째 뽑
            dp2[i][1] = Math.max(dp2[i - 1][0], dp2[i - 1][1]); // i번째 안뽑
        }

        return Math.max(dp2[sticker.length - 1][0], dp[sticker.length - 1][1]);
    }
}
