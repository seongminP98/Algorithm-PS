import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinDistribution1943 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        loop:
        for (int t = 0; t < 3; t++) {
            int N = Integer.parseInt(br.readLine());
            Coin[] coin = new Coin[N];

            int sum = 0;
            boolean[] dp = new boolean[100001]; // 만들 수 있는 금액
            dp[0] = true;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                coin[i] = new Coin(value, cnt);
                sum += (value * cnt);
                for (int j = 1; j <= cnt; j++) {
                    dp[value * j] = true;
                }
            }
            if (sum % 2 == 1) { // 합계가 홀수면 반으로 나눌 수 없음.
                System.out.println(0);
                continue;
            }
            if (dp[sum / 2]) { // 합계의 절반을 만들 수 있다면, 절반으로 나눌 수 있음.
                System.out.println(1);
                continue;
            }

            int goal = sum / 2;

            for (int i = 0; i < N; i++) {
                boolean[] check = new boolean[100001]; // 현재 돈으로 만들 수 있는 금액 체크.
                for (int j = 0; j <= goal; j++) {
                    if (dp[j] && !check[j]) { // 현재 돈으로 만든 금액이 아니라, 다른 돈들로 만든 금액에서만 체크.
                        for (int k = 1; k <= coin[i].cnt; k++) {
                            if (!check[j + coin[i].value * k]) {
                                dp[j + coin[i].value * k] = true;
                                check[j + coin[i].value * k] = true;
                                if (dp[goal]) {
                                    System.out.println(1);
                                    continue loop;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(dp[goal] ? 1 : 0);
        }

    }

    static class Coin {
        int value, cnt;

        public Coin(int value, int cnt) {
            this.value = value;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Coin{" +
                    "value=" + value +
                    ", cnt=" + cnt +
                    '}';
        }
    }
}
