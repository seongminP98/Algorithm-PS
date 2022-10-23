import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class FriendNetwork {
    static int[] parent;
    static int[] cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            parent = new int[N * 2];
            cnt = new int[N * 2];
            Arrays.fill(cnt, 1);
            for (int i = 0; i < N * 2; i++) {
                parent[i] = i;
            }
            Map<String, Integer> map = new HashMap<>();
            int idx = 0;
            while (N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();
                if (!map.containsKey(s1)) {
                    map.put(s1, idx++);
                }
                if (!map.containsKey(s2)) {
                    map.put(s2, idx++);
                }

                union(map.get(s1), map.get(s2));
                System.out.println(cnt[getParent(map.get(s1))]);
            }
        }
    }

    private static int getParent(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = getParent(parent[x]);
    }

    private static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a != b) {
            parent[b] = a;
            cnt[a] += cnt[b];
        }
    }
}
