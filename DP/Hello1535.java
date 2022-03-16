import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hello1535 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] health = new int[N];
        int[] pleasure = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pleasure[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[100]; //현재 체력에서의 행복의 최대
        for (int i = 0; i < N; i++) {
            for (int j = 99; j >= 0; j--) {
                int cHealth = j + health[i]; //지금 체력에서 i번째 사람과 인사할 시 체력
                if (cHealth < 100) {
                    dp[cHealth] = Math.max(dp[cHealth], dp[j] + pleasure[i]); //i번째 사람과 인사한 후 기쁨이 더 크면 갱신
                }
            }
        }
        System.out.println(dp[99]);
    }
}
