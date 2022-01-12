import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class PopulationMovement16234 {
    static int N, L, R;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;

        while (true) {
            int check = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        check += bfs(i, j);
//                        System.out.println(check);
                    }
                }
            }
            if(check == N*N) {
                break;
            }
            answer++;
        }
//        for (int[] ints : arr) {
//            for (int anInt : ints) {
//                System.out.print(anInt+" ");
//            }
//            System.out.println();
//        }
        System.out.println(answer);

    }

    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        List<Node> list = new ArrayList<>();
        q.add(new Node(x, y));
        list.add(new Node(x,y));
        int sum = arr[x][y];
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.poll().y;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
                    if(Math.abs(arr[nx][ny]-arr[cx][cy]) >= L && Math.abs(arr[nx][ny]-arr[cx][cy]) <= R) {
                        visited[nx][ny] = true;
                        list.add(new Node(nx,ny));
                        q.add(new Node(nx,ny));
//                        System.out.println("nx = " + nx + " ny = " + ny + " arr[nx][ny] = " + arr[nx][ny]);

                        sum += arr[nx][ny];
                    }
                }
            }
        }
//        System.out.println("sum = " + sum);
        for (Node node : list) {
            arr[node.x][node.y] = sum/list.size();
        }
        if(list.size() != 1) {
            return 0;
        } else {
            return 1;
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

