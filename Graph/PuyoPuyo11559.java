import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PuyoPuyo11559 {
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[13][7]; //12, 6 하니 런타임 에러 (ArrayIndexOutOfBounds) 뜸. 그래서 그냥 13 7 로 바꿨더니 통과..
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        boolean flag = true;
        int answer = -1;
        while (flag) {
            answer++;
            flag = false;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    visited = new boolean[13][7];
                    if (arr[i][j] == '.')
                        continue;

                    visited[i][j] = true;

                    //한번 터져서 true 가 되면 바뀌지 않게.
                    //flag 가 true 가 되더라도 더 터질지 확인해야함.
                    flag |= bfs(i, j, arr[i][j]);
                }
            }
            down();
        }

        System.out.println(answer);
    }

    static boolean bfs(int x, int y, char color) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        int cnt = 1;
        List<Node> list = new ArrayList<>();
        list.add(new Node(x, y));
        while (!q.isEmpty()) {
            Node current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && nx < 12 && ny >= 0 && ny < 12 && arr[nx][ny] == color && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                    list.add(new Node(nx, ny));
                    cnt++;
                }
            }
        }
        if (cnt >= 4) {
            explode(list);
            return true;
        } else {
            return false;
        }
    }

    static void explode(List<Node> list) {
        for (Node node : list) {
            arr[node.x][node.y] = '.';
        }
    }

    static void down() {
        for (int i = 10; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                if (arr[i][j] == '.')
                    continue;
                int cnt = 0;
                for (int k = i + 1; k < 12; k++) {
                    if (arr[k][j] == '.') {
                        cnt++;
                    } else {
                        break;
                    }
                }
                if (cnt > 0) {
                    arr[i + cnt][j] = arr[i][j];
                    arr[i][j] = '.';
                }

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
