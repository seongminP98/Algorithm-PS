import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class InfiniteSequence1351 {
    static long N, P, Q;
    static Map<Long, Long> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        map = new HashMap<>();
        map.put(0L, 1L);
        map.put(1L, 2L);

        System.out.println(dp(N));

    }

    private static long dp(long i) {
        if (!map.containsKey(i)) {
            map.put(i, dp(i / P) + dp(i / Q));
        }
        return map.get(i);
    }
}
