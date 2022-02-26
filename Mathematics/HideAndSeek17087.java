import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HideAndSeek17087 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] dis = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dis[i] = Math.abs(S - Integer.parseInt(st.nextToken()));
        }

        int gcd = dis[0];
        for (int i = 1; i < N; i++) {
            gcd = GCD(gcd, dis[i]);
        }
        System.out.println(gcd);
    }

    static int GCD(int b, int s) { //큰 수, 작은 수 구별할 필요 없음. 작은수 큰수로 들어와도 한번 돌면 큰 수, 작은 수로 바뀜.
        int r = b % s;
        if (r == 0) {
            return s;
        }
        return GCD(s, r);
    }
}
