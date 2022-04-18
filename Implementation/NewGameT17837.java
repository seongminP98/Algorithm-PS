import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NewGameT17837 {
    static int N, K;
    static int[][] arr;
    static Chess[] chess;
    static int[] dx = {0, 0, 0, -1, 1}; // 0,우,좌,상,하
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) { // 0은 흰색, 1은 빨간색, 2는 파란색
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        chess = new Chess[K + 1];
        chess[0] = new Chess(-1, -1, 0, -1);
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            chess[i] = new Chess(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1);
        }
        play();
        System.out.println(-1);
    }

    static void play() {
        int count = 0;
        while (count++ < 1000) {
            for (int i = 1; i <= K; i++) { // i : 체스말의 번호
                int nx = chess[i].x + dx[chess[i].dir];
                int ny = chess[i].y + dy[chess[i].dir];
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                    if (arr[nx][ny] == 0) { // 흰
                        white(i, nx, ny);
                    } else if (arr[nx][ny] == 1) { // 빨
                        red(i, nx, ny);
                    } else if (arr[nx][ny] == 2) { // 파
                        int next = blue(i);
                        if (next == 0) {
                            white(i, chess[i].x + dx[chess[i].dir], chess[i].y + dy[chess[i].dir]);
                        } else if (next == 1) {
                            red(i, chess[i].x + dx[chess[i].dir], chess[i].y + dy[chess[i].dir]);
                        }
                    }
                } else { //파
                    int next = blue(i);
                    if (next == 0) {
                        white(i, chess[i].x + dx[chess[i].dir], chess[i].y + dy[chess[i].dir]);
                    } else if (next == 1) {
                        red(i, chess[i].x + dx[chess[i].dir], chess[i].y + dy[chess[i].dir]);
                    }
                }
                for (Chess chess1 : chess) {
                    if (chess1.h >= 4) {
                        System.out.println(count);
                        System.exit(0);
                    }
                }
            }
        }
    }

    static int blue(int num) {
        int cx = chess[num].x;
        int cy = chess[num].y;
        int nDir = 0;
        // 반대 방향
        if (chess[num].dir == 1) {
            nDir = 2;
        } else if (chess[num].dir == 2) {
            nDir = 1;
        } else if (chess[num].dir == 3) {
            nDir = 4;
        } else if (chess[num].dir == 4) {
            nDir = 3;
        }
        chess[num].dir = nDir;

        int nx = cx + dx[chess[num].dir];
        int ny = cy + dy[chess[num].dir];
        if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
            if (arr[nx][ny] == 0) { // 흰
                return 0;
            } else if (arr[nx][ny] == 1) { // 빨
                return 1;
            } else { // 파
                return 2;
            }
        } else { // 파
            return 2;
        }
    }

    static void red(int num, int nx, int ny) {
        int h = 1;
        int cx = chess[num].x;
        int cy = chess[num].y;
        int ch = chess[num].h;
        for (Chess chess1 : chess) {
            if (chess1.x == nx && chess1.y == ny) {
                h = Math.max(h, chess1.h + 1);
            }
        }
        PriorityQueue<Chess> pq = new PriorityQueue<>();
        for (int i = 1; i <= K; i++) {// 나 포함 위에 올려져 있던 말. h 내림차순으로
            if (chess[i].x == cx && chess[i].y == cy && chess[i].h >= ch) {
                pq.add(chess[i]);
            }
        }
        while (!pq.isEmpty()) { // 뒤집어줌. (내림차순으로 정렬되어 있으니)
            Chess c = pq.poll();
            c.x = nx;
            c.y = ny;
            c.h = h++;
        }
    }

    static void white(int num, int nx, int ny) {
        int h = 1;
        int cx = chess[num].x;
        int cy = chess[num].y;
        int ch = chess[num].h;
        for (Chess chess1 : chess) {
            if (chess1.x == nx && chess1.y == ny) {
                h = Math.max(h, chess1.h + 1);
            }
        }
        chess[num].x = nx;
        chess[num].y = ny;
        chess[num].h = h;
        int dh = h - ch; // h변화
        for (int i = 1; i <= K; i++) {// 위에 올려져 있던 말
            if (chess[i].x == cx && chess[i].y == cy && chess[i].h > ch) {
                chess[i].x = nx;
                chess[i].y = ny;
                chess[i].h += dh;
            }
        }
    }

    static class Chess implements Comparable<Chess> {
        int x, y, dir, h;

        public Chess(int x, int y, int dir, int h) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.h = h;
        }

        @Override
        public int compareTo(Chess o) { // 내림차순
            return o.h - h;
        }

        @Override
        public String toString() {
            return "Chess{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    ", h=" + h +
                    '}';
        }
    }
}
