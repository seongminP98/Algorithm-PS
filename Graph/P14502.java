import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P14502 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    static int[][] arr;
    static List<Node> blank;
    static List<Node> virus;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        blank = new ArrayList<>();
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    virus.add(new Node(i, j));
                }
                if (arr[i][j] == 0) {
                    blank.add(new Node(i, j));
                }
            }
        }
        int size = blank.size();
        answer = 0;
        solution(0, 0, new int[3], new boolean[size], size);
        System.out.println(answer);
    }

    static void solution(int depth, int start, int[] output, boolean[] check, int size) {
        if (depth == 3) { // BFS시작
            int blankSize = size - 3;
            boolean[][] visited = new boolean[N][M];
            for (int i : output) {
                visited[blank.get(i).x][blank.get(i).y] = true;
            }

            Queue<Node> q = new LinkedList<>();
            for (Node node : virus) {
                q.add(new Node(node.x, node.y));
            }

            while (!q.isEmpty()) {
                Node c = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = c.x + dx[i];
                    int ny = c.y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && arr[nx][ny] == 0) {
                        q.add(new Node(nx, ny));
                        blankSize--;
                        visited[nx][ny] = true;
                    }
                }
            }
            answer = Math.max(answer, blankSize);

            return;
        }

        for (int i = start; i < size; i++) {
            if (!check[i]) {
                check[i] = true;
                output[depth] = i;
                solution(depth + 1, i + 1, output, check, size);
                check[i] = false;
            }
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
