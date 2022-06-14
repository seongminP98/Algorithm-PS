public class SharedTaxiFare {
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution(n, s, a, b, fares));
    }

    private static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 100000000;
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else {
                    dist[i][j] = 100000000;
                }
            }
        }

        for (int[] fare : fares) {
            dist[fare[0]][fare[1]] = fare[2];
            dist[fare[1]][fare[0]] = fare[2];
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int k = 1; k <= n; k++) {
            if (answer > dist[s][k] + dist[k][a] + dist[k][b]) {
                answer = dist[s][k] + dist[k][a] + dist[k][b];
            }
        }

        return answer;
    }
}
