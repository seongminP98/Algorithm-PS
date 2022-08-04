import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SharkMiddleSchool21609 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = 0;
    static List<Node> groupList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (playGame()) ;
        System.out.println(answer);
    }

    private static void printArr() {
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }

    private static boolean playGame() {
        groupList = new ArrayList<>();
        // 1
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] >= 1 && !visited[i][j]) {
                    groupList.add(getGroup(i, j, visited));
                }
            }
        }
        Collections.sort(groupList);
        if (groupList.size() == 0) return false;
        Node group = groupList.get(0);
        if (group.size >= 2) {
            answer += group.size * group.size;
            // 제일 큰 그룹. 게임 이어나감.
            //2,3,4,5번 적용
            deleteBlock(group.x, group.y); // 2
            gravity();
            turnClockwise();
            gravity();
            return true;
        } else {
            return false;
        }
    }

    private static void turnClockwise() { // 4
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = arr[j][N - i - 1];
            }
        }
        for (int i = 0; i < N; i++) {
            System.arraycopy(temp[i], 0, arr[i], 0, N);
        }
    }

    private static void gravity() { // 3,5
        for (int j = 0; j < N; j++) {
            Queue<Integer> q = new LinkedList<>();
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i][j] != -2) {
                    q.add(arr[i][j]);
                }
            }
            if (q.size() == 0) continue;

            boolean flag = false;
            for (int i = N - 1; i >= 0; i--) {
                if (flag) {
                    arr[i][j] = -2;
                    continue;
                }
                if (q.peek() == -1) {
                    if (arr[i][j] == -1) {
                        q.poll();
                        if (q.size() == 0) {
                            flag = true;
                        }
                    } else { // 확인 필요
                        arr[i][j] = -2;
                    }
                } else {
                    arr[i][j] = q.poll();
                    if (q.size() == 0) {
                        flag = true;
                    }
                }
            }
        }
    }

    private static void deleteBlock(int x, int y) { // 2
        boolean[][] visited = new boolean[N][N];
        visited[x][y] = true;
        int value = arr[x][y];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        while (!q.isEmpty()) {
            Node c = q.poll();
            arr[c.x][c.y] = -2;
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && (arr[nx][ny] == value || arr[nx][ny] == 0)) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static Node getGroup(int x, int y, boolean[][] visited) { // 1
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        int count = 0; // 무지개 블럭 수
        int row = x; // 기준 블록
        int column = y; // 기준 블록
        visited[x][y] = true;
        int value = arr[x][y];
        int size = 1;
        List<Node> rainbowList = new ArrayList<>();
        while (!q.isEmpty()) {
            Node c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && (arr[nx][ny] == value || arr[nx][ny] == 0)) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    size++;
                    if (arr[nx][ny] == 0) {
                        rainbowList.add(new Node(nx, ny));
                        count++;
                    } else {
                        if (nx < row) {
                            row = nx;
                            column = ny;
                        } else if (nx == row) {
                            column = Math.min(column, ny);
                        }
                    }

                }
            }
        }
        for (Node node : rainbowList) {
            visited[node.x][node.y] = false;
        }
        return new Node(row, column, count, size);
    }

    private static class Node implements Comparable<Node> {
        int x, y, cnt, size;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int cnt, int size) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.size = size;
        }

        public Node() {
        }

        @Override
        public int compareTo(Node o) {
            if (this.size == o.size) {
                if (this.cnt == o.cnt) {
                    if (this.x == o.x) {
                        return Integer.compare(o.y, this.y);
                    } else {
                        return Integer.compare(o.x, this.x);
                    }
                } else {
                    return Integer.compare(o.cnt, this.cnt);
                }
            } else {
                return Integer.compare(o.size, this.size);
            }
        }
    }
}
