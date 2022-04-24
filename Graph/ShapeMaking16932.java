import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ShapeMaking16932 {
    static int N, M;
    static int[][][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Map<Integer, Integer> group;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (st.nextToken().equals("1"))
                    arr[i][j][0] = -1;
            }
        }

        group = new HashMap<>();
        int groupNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j][0] == -1) {
                    bfs(i, j, groupNum++);
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j][0] == 0) {
                    int sum = 1;
                    Set<Integer> check = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny][1] != 0) {
                            check.add(arr[nx][ny][1]);
                        }
                    }
                    for (Integer gn : check) {
                        sum += group.get(gn);
                    }
                    if (sum > answer) answer = sum;
                }
            }
        }
        System.out.println(answer);


    }

    static void bfs(int x, int y, int groupNum) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        int count = 1;
        arr[x][y][0] = count;
        arr[x][y][1] = groupNum;

        while (!q.isEmpty()) {
            Node c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny][0] == -1) {
                    arr[nx][ny][0] = ++count;
                    arr[nx][ny][1] = groupNum;
                    q.add(new Node(nx, ny));
                }
            }
        }
        group.put(groupNum, count);

    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
