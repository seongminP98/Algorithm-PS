import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Cheese2636 {
    static int N,M;
    static int[][] arr;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Queue<Node> q;
    static int ans = 0;
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        q = new LinkedList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                if(i==0 || j==0 || i==N-1 || j==M-1) {
                    arr[i][j] = -1; //벽
                    st.nextToken();
                    q.add(new Node(i,j));
                } else {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }

            }
        }

        bfsInit();
        while(check()) {
            bfsCheese();
            bfsAir();
            ans++;
        }

        System.out.println(ans);
        System.out.println(count);
    }
    static void bfsInit() {
        while(!q.isEmpty()) {

            int cx = q.peek().x;
            int cy = q.peek().y;

            q.poll();

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<M) {
                    if(arr[nx][ny] == 0) {
                        arr[nx][ny] = -1;
                        q.add(new Node(nx,ny));
                    }
                }
            }
        }
    }
    static void bfsCheese() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 1) {
                    q.add(new Node(i,j));
                }
                if(arr[i][j] == -2) {
                    arr[i][j] = -1;
                }
            }
        }
        while(!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.peek().y;

            q.poll();

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<M) {
                    if(arr[nx][ny] == -1) {
                        arr[cx][cy] = -2;
                    }
                }
            }
        }
    }
    static void bfsAir() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == -1 || arr[i][j] == -2) {
                    q.add(new Node(i,j));
                }
            }
        }
        while(!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.peek().y;

            q.poll();

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<M) {
                    if(arr[nx][ny] == 0) {
                        arr[nx][ny] = -1;
                        q.add(new Node(nx,ny));
                    }
                }
            }
        }
    }
    static boolean check() {
        int c = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if(anInt == 1) {
                    c++;
                }
            }
        }

        if(c>0) {
            count = c;
            return true;
        }

        return false;
    }

    static class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


