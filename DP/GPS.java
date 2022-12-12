import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GPS {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int n = 7; // 거점 개수
        int m = 10; // 도로 개수
        int[][] edge_list = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}};
        int k = 6;
        int[] gps_log = {1, 2, 3, 3, 6, 7};
        System.out.println(solution(n, m, edge_list, k, gps_log));
    }

    private static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int[][] dp = new int[k][n + 1]; // t, 수정횟수

        for (int[] ints : dp) {
            Arrays.fill(ints, INF);
        }
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
            edges.get(i).add(i);
        }
        for (int[] edge : edge_list) {
            edges.get(edge[0]).add(edge[1]);
            edges.get(edge[1]).add(edge[0]);
        }

        int start = gps_log[0];
        dp[0][start] = 0;
        for (int i = 0; i < k - 1; i++) { // t가 i에서 i+1까지 갈 때 도로 찾기
            for (int j = 1; j < n; j++) { // 거점
                if (dp[i][j] == INF) continue;

                for (Integer next : edges.get(j)) {
                    dp[i + 1][next] = Math.min(dp[i + 1][next], gps_log[i + 1] == next ? dp[i][j] : dp[i][j] + 1);
                }

            }
        }

        return dp[k - 1][gps_log[k - 1]] == INF ? -1 : dp[k - 1][gps_log[k - 1]];
    }
}
