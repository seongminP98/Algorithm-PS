import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SeeStoreShiru {
    static int N, M, K;
    static int[][] arr;
    static List<Node> mannequins;
    static Node start;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        mannequins = new ArrayList<>();
        /*
        빈 칸 0
        기둥 1 - 갈 수 없음
        의자 2 - 목적지
        마네킹 3 - K만큼 떨어져야 함
        시작 위치 4
         */
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 3) {


                    mannequins.add(new Node(i, j));
                } else if (arr[i][j] == 4) {
                    start = new Node(i, j, 0);
                }
            }
        }

        setNearMane();

        bfs();
        System.out.println(-1);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            Node c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] == 0) {
                        q.add(new Node(nx, ny, c.health + 1));
                        arr[nx][ny] = 1;
                    } else if (arr[nx][ny] == 2) {
                        System.out.println(c.health + 1);
                        System.exit(0);
                    }
                }
            }
        }
    }

    private static void setNearMane() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0 || arr[i][j] == 2) {
                    for (Node mannequin : mannequins) {
                        if (Math.abs(i - mannequin.x) + Math.abs(j - mannequin.y) <= K) {

                            arr[i][j] = 1;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static class Node {
        int x, y, health;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int health) {
            this.x = x;
            this.y = y;
            this.health = health;
        }
    }
}
