import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BreakWallAndMove16946 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] group;
    static HashMap<Integer, Integer> groupSize; //key : 그룹번호 / value : 이 그룹에 속하는 공간의 개수
    //분리집합
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        group = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        groupSize = new HashMap<>();
        int groupCnt = 1; //그룹 번호.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0 && group[i][j] == 0) {
                    groupSize.put(groupCnt, bfs(i, j, groupCnt++));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    sb.append(count(i, j));
                } else {
                    sb.append(0);
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);

    }

    static int bfs(int x, int y, int groupCnt) { //공간을 그룹으로 만들기
        Queue<Node> q = new LinkedList<>();
        int count = 1;
        q.add(new Node(x, y));
        group[x][y] = groupCnt;
        while (!q.isEmpty()) {
            Node current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 0 && group[nx][ny] == 0) {
                    group[nx][ny] = groupCnt;
                    count++;
                    q.add(new Node(nx, ny));
                }
            }
        }
        return count; //같은 그룹의 개수 리턴.
    }

    static int count(int x, int y) { //벽에서 갈 수있는 공간의 그룹 번호를 구하고, 그 그룹의 크기를 더해서 답을 찾는다.
        int cnt = 1;
        Set<Integer> set = new HashSet<>(); //벽에서 갈 수 있는 공간이 같은 그룹이면 한번만 계산하면 됨.
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 0) {
                set.add(group[nx][ny]);
            }
        }
        for (Integer integer : set) {
            cnt += groupSize.get(integer);
        }
        return cnt % 10;

    }
/* 시간초과.
    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        boolean[][] visited = new boolean[N][M];
        int count = 1;
        while (!q.isEmpty()) {
            Node current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && arr[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                    count++;
                }
            }
        }
        arr[x][y] = count%10;
    }
*/

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
