import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Castle2234 {
    static int N, M;
    static int[][] arr;
    static Map<Integer, Set<Integer>> neighbor;
    static Map<Integer, Integer> countMap;
    static int[][] visited;
    static int[] dx = {0, -1, 0, 1}; // 서, 북, 동, 남 (0,1,2,3)
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // M*N
        arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        System.out.println(1<<3 & 2);
        neighbor = new HashMap<>();
        countMap = new HashMap<>();
        visited = new int[M][N];
        int idx = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    bfs(i, j, idx++);
                }
            }
        }
        int maxArea = 0;

        for (Integer key : countMap.keySet()) {
            maxArea = Math.max(maxArea, countMap.get(key));
            neighbor.put(key, new HashSet<>());
        }
        findNeighborGroup();
        int maxTwoRoomArea = 0;
        for (Integer key : neighbor.keySet()) {
            for(Integer n : neighbor.get(key)) {
                maxTwoRoomArea = Math.max(maxTwoRoomArea, countMap.get(key) + countMap.get(n));
            }
        }
        System.out.println(idx - 1); // 1
        System.out.println(maxArea); // 2
        System.out.println(maxTwoRoomArea); // 3
    }

    private static void bfs(int x, int y, int room) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        int count = 1;
        visited[x][y] = room;
        while (!q.isEmpty()) {
            Node c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N && visited[nx][ny] == 0) {
                    if ((arr[c.x][c.y] & 1 << i) == 0) {

                        q.add(new Node(nx, ny));
                        count++;
                        visited[nx][ny] = room;
                    }
                }
            }
        }
        countMap.put(room, count);
    }
    private static void findNeighborGroup() {
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                        if(visited[i][j] != visited[nx][ny]) {
                            neighbor.get(visited[i][j]).add(visited[nx][ny]);
                        }
                    }
                }
            }
        }
    }

    private static class Node {
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
