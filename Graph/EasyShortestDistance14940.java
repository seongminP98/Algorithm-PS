import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EasyShortestDistance14940 {
    static int N, M;
    static int[][] arr;
    static int[][] answer;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        answer = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                answer[i][j] = -1;
                if (arr[i][j] == 2) {
                    q.add(new Node(i, j, 0));
                    answer[i][j] = 0;
                }
                if(arr[i][j] == 0) {
                    answer[i][j] = 0;
                }
            }
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int[] ints : answer) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int dis = q.poll().dis;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && answer[nx][ny] == -1 && arr[nx][ny] == 1) {
                    answer[nx][ny] = dis + 1;
                    q.add(new Node(nx, ny, dis + 1));
                }
            }
        }

    }

    static class Node {
        int x, y, dis;

        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
