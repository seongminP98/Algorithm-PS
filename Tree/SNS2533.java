import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SNS2533 {
    static int N;
    static List<ArrayList<Integer>> edges;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int n) {
        visited[n] = true;
        dp[n][0] = 0; // 얼리어답터 x
        dp[n][1] = 1; // 얼리어답터 o

        for (Integer child : edges.get(n)) {
            if(visited[child]) continue;
            dfs(child); // 자식부터 확인
            dp[n][0] += dp[child][1]; //내가 얼리어답터가 아니니 자식은 무조건 얼리어답터.
            dp[n][1] += Math.min(dp[child][1], dp[child][0]); //내가 얼리어답터니 자식은 상관없음.
        }
    }
}
