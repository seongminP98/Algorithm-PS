import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Picnic2026 {
    static int K, N, F;
    static List<List<Integer>> list;
    static Set<Integer> answer;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < F; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        check = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (list.get(i).size() >= K - 1) {
                Collections.sort(list.get(i));
                check[i] = true;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (check[i]) {
                answer = new TreeSet<>();
                answer.add(i);
                dfs(i, 1, list.get(i).size());
            }
        }
        System.out.println(-1);
    }

    private static void dfs(int n, int size, int remain) {
        if (answer.size() == K) {
            for (Integer integer : answer) {
                System.out.println(integer);
            }
            System.exit(0);
        }
        if (remain + size < K) {
            return;
        }
        loop:
        for (Integer i : list.get(n)) {
            if (!check[i]) continue;
            for (Integer f : answer) {
                if (!list.get(i).contains(f)) {
                    remain--;
                    continue loop;
                }
            }
            answer.add(i);
            dfs(n, size + 1, remain - 1);
        }
    }
}
