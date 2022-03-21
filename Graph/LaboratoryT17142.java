import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class LaboratoryT17142 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static List<Node> virus;
    static int answer = Integer.MAX_VALUE;
    static int empty = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    empty++;
                }
                if (arr[i][j] == 2) {
                    virus.add(new Node(i, j, 0));
                }
            }
        }
        Node[] input = new Node[M];
        combination(0, M, input);
//        System.out.println("check = " + check);
//        System.out.println("impossibleCheck = " + impossibleCheck);
        if (empty == 0) {
            System.out.println(0);
        } else {
            combination(0, M, input);
            System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        }

    }

    static void combination(int start, int depth, Node[] input) {
        if (depth == 0) {
            bfs(input, empty);
            return;
        }
        for (int i = start; i < virus.size(); i++) {
            input[M - depth] = virus.get(i);
            combination(i + 1, depth - 1, input);
        }
    }

    static void bfs(Node[] nodes, int empty) {
        Queue<Node> q = new LinkedList<>(Arrays.asList(nodes));

        boolean[][] visited = new boolean[N][N];
        for (Node node : nodes) {
            visited[node.x][node.y] = true;
        }
        while (!q.isEmpty()) {
            Node c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    if (arr[nx][ny] == 1) continue;

                    if (arr[nx][ny] == 0) {
                        empty--;
                    }
                    if (empty == 0) {
                        answer = Math.min(answer, c.time + 1);
                        return;
                    }
                    q.add(new Node(nx, ny, c.time + 1));
                    visited[nx][ny] = true;
                }
            }
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
