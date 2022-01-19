import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Cheese2638 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cheeseNum;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        cheeseNum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    cheeseNum++;
                }
            }
        }
        visited = new boolean[N][M];
        int answer = 0;
        while (cheeseNum != 0) {
            airCheck();
            visited = new boolean[N][M];
            cheese();
            answer++;
        }

        System.out.println(answer);
    }

    static void airCheck() {
        visited[0][0] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        while (!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.poll().y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && arr[nx][ny] != 1) {
                    visited[nx][ny] = true;
                    arr[nx][ny] = -1;
                    q.add(new Node(nx, ny));

                }
            }
        }
    }

    static void cheese() {
        Queue<Node> q = new LinkedList<>();
        int check = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (arr[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == -1) {
                            check++;
                        }
                    }
                    if (check >= 2) {
                        q.add(new Node(i, j));
                    }
                    check = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.poll().y;
            arr[cx][cy] = -1;
            cheeseNum--;
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
