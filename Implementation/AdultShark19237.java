import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AdultShark19237 {
    static int N, M, K;
    static Shark[] sharks;
    static Map[][] map;
    static int[][][] direction;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    static boolean[] isOut;
    static int count;
    static List<Shark> check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 상어 개수
        K = Integer.parseInt(st.nextToken()); // 냄새 사라지는 시간

        sharks = new Shark[M + 1];
        map = new Map[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken()); // 상어 번호
                if (x == 0) {
                    map[i][j] = new Map(0, 0, 0);
                } else {
                    map[i][j] = new Map(x, K, x);
                    sharks[x] = new Shark(0, i, j);
                }
            }
        }

        // 1,2,3,4 => 위, 아래, 왼쪽, 오른쪽
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            sharks[i].dir = Integer.parseInt(st.nextToken());
        }

        // 위, 아래, 왼쪽, 오른쪽
        direction = new int[M + 1][5][4]; // 상어 숫자, 현재 방향, 다음 방향 우선순위
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int d = 0; d < 4; d++) {
                    direction[i][j][d] = Integer.parseInt(st.nextToken());
                }
            }
        }
        isOut = new boolean[M + 1];
        count = M;
        // 입력 끝
        int time = 0;
        while (time++ < 1000) {
            check = new ArrayList<>();
            solution();
            if (count == 1) {
                System.out.println(time);
                System.exit(0);
            }
        }
        System.out.println(-1);

    }

    private static void solution() {
        for (int i = 1; i <= M; i++) { // 1번 상어부터 출발

            if (isOut[i]) {
                continue;
            }
            int dir = findNextDir(i);

            map[sharks[i].x][sharks[i].y].curNum = 0; // 현재 있던 자리의 curNum 은 0으로.
            // 움직이고, 보는 방향 바꾸고
            sharks[i].x += dx[dir];
            sharks[i].y += dy[dir];
            sharks[i].dir = dir;
            if (map[sharks[i].x][sharks[i].y].curNum < i && map[sharks[i].x][sharks[i].y].curNum != 0) { // 쫓겨남
                isOut[i] = true;
                count--;
            } else {
                map[sharks[i].x][sharks[i].y].curNum = i;
                map[sharks[i].x][sharks[i].y].num = i;
                map[sharks[i].x][sharks[i].y].smell = K + 1;
            }
        }
        for (Map[] maps : map) {
            for (Map m : maps) {
                if (m.smell > 0) {
                    if (--m.smell == 0) {
                        m.num = 0;
                    }
                }
            }
        }

    }

    private static int findNextDir(int num) {
        int curDir = sharks[num].dir;
        int firstMySmell = 0;

        for (int d : direction[num][curDir]) {
            int nx = sharks[num].x + dx[d];
            int ny = sharks[num].y + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) { // 냄새 없는 칸 찾기
                if (map[nx][ny].smell == 0 || map[nx][ny].smell > K) {
                    if (!check.contains(new Shark(nx, ny))) {
                        return d;
                    }
                } else if (map[nx][ny].num == num && firstMySmell == 0) { // 내 냄새가 있는 칸
                    firstMySmell = d;
                    check.add(new Shark(nx, ny)); // 다음 상어가 못가는 자리. 
                }
            }
        }
        return firstMySmell;
    }


    static class Shark {
        int dir, x, y;

        public Shark(int dir, int x, int y) {
            this.dir = dir;
            this.x = x;
            this.y = y;
        }

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Shark shark = (Shark) o;
            return x == shark.x &&
                    y == shark.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "dir=" + dir +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static class Map {
        int num, smell, curNum;
        boolean check;


        public Map(int num, int smell, int curNum) {
            this.num = num;
            this.smell = smell;
            this.curNum = curNum;
        }

        @Override
        public String toString() {
            return "Map{" +
                    "num=" + num +
                    ", smell=" + smell +
                    ", curNum=" + curNum +
                    '}';
        }
    }
}
