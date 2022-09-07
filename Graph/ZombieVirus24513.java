import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ZombieVirus24513 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Virus> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] >= 1) {
                    q.add(new Virus(i, j, arr[i][j]));
                }
            }
        }
        int[] answer = new int[4];
        bfs();
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == -1) continue;

                answer[anInt]++;
            }
        }
        System.out.println(answer[1] + " " + answer[2] + " " + answer[3]);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int size = q.size();
            int[][] check = new int[N][M];
            while (size-- > 0) {
                Virus c = q.poll();
                if(arr[c.x][c.y] == 3) continue;

                for (int i = 0; i < 4; i++) {
                    int nx = c.x + dx[i];
                    int ny = c.y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] != -1) {
                        if (arr[nx][ny] == 0) {
                            check[nx][ny] = c.type;
                            arr[nx][ny] = c.type;
                            q.add(new Virus(nx,ny,c.type));
                        } else {
                            if (check[nx][ny] != 0 && c.type != check[nx][ny]) {
                                arr[nx][ny] = 3;
                            }
                        }

                    }
                }
            }
        }
    }

    private static class Virus {
        int x, y, type;

        public Virus(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
