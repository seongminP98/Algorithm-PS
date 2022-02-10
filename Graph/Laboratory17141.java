import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Laboratory17141 {
    static int N, M;
    static int[][] arr;
    static List<Node> virus;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;
    static int check = 0;
    static int impossibleCheck = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        virus = new ArrayList<>();
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    arr[i][j] = -2; //벽
                }
                if (arr[i][j] == 2) {
                    arr[i][j] = 0;
                    virus.add(new Node(i, j, 0));
                }
            }
        }
        Node[] input = new Node[M];
        combination(0, M, input);
        if (check == impossibleCheck) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static void combination(int start, int depth, Node[] input) {
        if (depth == 0) {
            check++;
            bfs(input);
            return;
        }
        for (int i = start; i < virus.size(); i++) {
            input[M - depth] = virus.get(i);
            combination(i + 1, depth - 1, input);
        }
    }

    static void bfs(Node[] nodes) {
        Queue<Node> q = new LinkedList<>(Arrays.asList(nodes));
        visited = new boolean[N][N];
        for (Node node : q) {
            visited[node.x][node.y] = true;
        }
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(arr[i], 0, temp[i], 0, N);
        }

        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
//            visited[x][y] = true;
            int time = q.poll().time;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && temp[nx][ny] == 0) {
                    q.add(new Node(nx, ny, time + 1));
                    temp[nx][ny] = time + 1;
                    visited[nx][ny] = true;
                }

            }
        }
        int zeroCheck = 0;
        int max = 0;

        for (int[] ints : temp) {
            for (int anInt : ints) {
                max = Math.max(max, anInt);
                if (anInt == 0) {
                    zeroCheck++;
                }
            }
        }
        if (zeroCheck != M) {
            impossibleCheck++;
        } else {
            answer = Math.min(max, answer);
        }
    }

    static class Node {
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", time=" + time +
                    '}';
        }
    }
}
