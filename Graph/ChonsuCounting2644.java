import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ChonsuCounting2644 {
    static int[][] arr;
    static int h1;
    static int h2;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        h1 = Integer.parseInt(st.nextToken());
        h2 = Integer.parseInt(st.nextToken());
        int rel = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        visited = new boolean[n + 1];
        for (int i = 0; i < rel; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        System.out.println(bfs(h1));
    }

    static int bfs(int h) {
        Queue<Chonsu> q = new LinkedList<>();
        q.add(new Chonsu(h, 0));
        visited[h] = true;
        while (!q.isEmpty()) {
            int human = q.peek().h;
            int c = q.peek().c;
            q.poll();
            if (human == h2) {
                return c;

            }
            for(int i=1; i<=n; i++) {
                if(!visited[i] && arr[human][i] == 1) {
                    visited[i] = true;
                    q.add(new Chonsu(i, c+1));
                }
            }
        }
        return -1;

    }

    static class Chonsu {
        int h, c;

        public Chonsu(int h, int c) {
            this.h = h;
            this.c = c;
        }
    }
}
