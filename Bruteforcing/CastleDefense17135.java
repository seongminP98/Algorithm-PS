import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CastleDefense17135 {
    static int N, M, D;
    static int[][] arr;
    static Node[] archer = new Node[3];
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] visited = new boolean[M];
        combination(3, 0, visited);
        System.out.println(answer);
    }

    static void solution() {
        int result = 0;
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            if (M >= 0) System.arraycopy(arr[i], 0, temp[i], 0, M);
        }
        while (!endGame(temp)) {
            List<Node> kill = new ArrayList<>();
            List<Node> near = new ArrayList<>();
            for (int a = 0; a < 3; a++) {
                int min = Integer.MAX_VALUE;
                int x = 100;
                int y = 100;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (temp[i][j] == 1) {
                            int dis = distance(i, j, a);
                            if (dis <= D) { //공격가능
                                if (dis < min) {//가장 가까운적 찾기
                                    min = dis;
                                    x = i;
                                    y = j;
                                } else if (dis == min) {// 가장 가까운 거리랑 같다면 왼쪽걸 선택
                                    if (j <= y) {
                                        x = i;
                                        y = j;
                                    }
                                }
                            }
                        }
                    }
                }
                if (x != 100)
                    kill.add(new Node(x, y));

            }
            for (Node node : kill) {
                if (temp[node.x][node.y] == 1) {
                    temp[node.x][node.y] = 0;
                    result++;
                }
            }
            afterTurn(temp);
        }
        answer = Math.max(answer, result);
    }

    static void combination(int depth, int start, boolean[] visited) {
        if (depth == 0) {
            int idx = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    archer[idx++] = new Node(N, i);
                }
            }
            solution();

            return;
        }
        for (int i = start; i < M; i++) {
            visited[i] = true;
            combination(depth - 1, i + 1, visited);
            visited[i] = false;
        }
    }

    static void afterTurn(int[][] arr) {
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = arr[i - 1][j];
            }
        }
        for (int i = 0; i < M; i++) {
            arr[0][i] = 0;
        }
    }

    static int distance(int x, int y, int idx) {
        return Math.abs(x - archer[idx].x) + Math.abs(y - archer[idx].y);
    }

    static boolean endGame(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
