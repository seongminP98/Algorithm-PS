import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class WizardSharkNFirestorm20058 {
    static int N, Q;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int maxSize = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        N = (int) Math.pow(2, N);
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int L = Integer.parseInt(st.nextToken());
            int len = (int) Math.pow(2, L);
            firestorm(len);
            descIce();
        }
        iceCube();
        int sum = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        System.out.println(sum);
        System.out.println(maxSize);

    }

    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        visited[x][y] = true;
        int size = 1;
        while(!q.isEmpty()) {
            Node c = q.poll();
            for(int i=0; i<4; i++) {
                int nx = c.x+dx[i];
                int ny = c.y+dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<N && arr[nx][ny]>0 && !visited[nx][ny]) {
                    q.add(new Node(nx,ny));
                    visited[nx][ny] = true;
                    size++;
                }
            }
        }
        return size;
    }

    static void iceCube() {
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] > 0 && !visited[i][j]) {
                    maxSize = Math.max(maxSize, bfs(i,j));
                }
            }
        }
    }

    static void firestorm(int len) {
        for (int i = 0; i < N; i += len) {
            for (int j = 0; j < N; j += len) {
                for (int k = 0; k < len / 2; k++) {
                    locate(i + k, j + k, len - k*2);
                }
            }
        }
    }

    static void descIce() {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] > 0) {
                        cnt++;
                    }
                }
                if (cnt < 3) {
                    if(arr[i][j]>0)
                        list.add(new Node(i,j));
                }
            }
        }
        for (Node node : list) {
            arr[node.x][node.y]--;
        }
    }

    static void locate(int startX, int startY, int len) {
        int[] temp = new int[len*4];

        int idx = 0;
        for (int j = startY; j < startY + len; j++) {
            temp[idx++] = arr[startX][j];
        }
        for (int i = startX; i < startX + len; i++) {
            temp[idx++] = arr[i][startY + len - 1];
        }

        for (int j = startY + len - 1; j >= startY; j--) {
            temp[idx++] = arr[startX + len - 1][j];
        }

        for (int i = startX + len - 1; i >= startX; i--) {
            temp[idx++] = arr[i][startY];
        }

        idx = 0;
        for (int i = startX; i < startX + len; i++) {
            arr[i][startY + len - 1] = temp[idx++];
        }

        for (int j = startY + len - 1; j >= startY; j--) {
            arr[startX + len - 1][j] = temp[idx++];
        }



        for (int i = startX + len - 1; i >= startX; i--) {
            arr[i][startY] = temp[idx++];
        }


        for (int j = startY; j < startY + len; j++) {
            arr[startX][j] = temp[idx++];
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
