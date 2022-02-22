import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LetsTravel1976 {
    static int[] parent;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        for (int i = 1; i < M; i++) {
            if (!(isSameParent(start, Integer.parseInt(st.nextToken())))) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }

    static int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    static boolean isSameParent(int x, int y) {
        return findParent(x) == findParent(y);
    }

    static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        if (x != y) {
            parent[y] = x;
        }
    }
}
