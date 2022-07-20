import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EscapeTheMaze17090 {
    static int N, M;
    static char[][] arr;
    static int[][] check;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        check = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (check[i][j] == 0) {
                    go(i, j);
                }
            }
        }
        System.out.println(answer);

    }

    private static void go(int x, int y) {
        int count = 0;
        List<Node> list = new ArrayList<>();
        while (isIn(x, y)) {
            count++;
            list.add(new Node(x, y));
            check[x][y] = 1; // 일단 지나간 자리 체크
            if (arr[x][y] == 'U') {
                x--;
            } else if (arr[x][y] == 'R') {
                y++;
            } else if (arr[x][y] == 'D') {
                x++;
            } else if (arr[x][y] == 'L') {
                y--;
            }
            if (isIn(x, y) && check[x][y] == 1) {
                return;
            } else if (isIn(x, y) && check[x][y] == 2) {
                for (Node node : list) {
                    check[node.x][node.y] = 2; // 탈출할 수 있는 곳
                }
                answer += count;
                return;
            }
        }
        answer += count;
        for (Node node : list) {
            check[node.x][node.y] = 2; // 탈출할 수 있는 곳
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
