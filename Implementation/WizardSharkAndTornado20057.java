import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WizardSharkAndTornado20057 {
    static int N;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1}; // 왼, 아래, 오른쪽, 위
    static int[] dy = {-1, 0, 1, 0};
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int k = 1;
        int x = N / 2;
        int y = N / 2;
        int dir = 0;
        while (k < N) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < k; j++) {
                    x += dx[dir % 4];
                    y += dy[dir % 4];
                    move(x, y, dir % 4);
                }
                dir++;
            }
            k++;
        }
        for (int j = N - 1; j >= 0; j--) { // 마지막
            move(0, j, 0);
        }

        System.out.println(answer);
    }

    private static void move(int x, int y, int dir) { // y좌표와, 방향
        int sumMove = 0;
        // 5%
        if (isIn(x + dx[dir] * 2, y + dy[dir] * 2)) {
            arr[x + dx[dir] * 2][y + dy[dir] * 2] += arr[x][y] * 0.05;
        } else {
            answer += arr[x][y] * 0.05;
        }
        sumMove += Math.floor(arr[x][y] * 0.05);

        for (int i = 1; i <= 3; i += 2) {
            // 10%
            if (isIn(x + dx[dir] + dx[(dir + i) % 4], y + dy[dir] + dy[(dir + i) % 4])) {
                arr[x + dx[dir] + dx[(dir + i) % 4]][y + dy[dir] + dy[(dir + i) % 4]] += arr[x][y] * 0.1;
            } else {
                answer += arr[x][y] * 0.1;
            }
            sumMove += Math.floor(arr[x][y] * 0.1);

            // 7%

            if (isIn(x + dx[(dir + i) % 4], y + dy[(dir + i) % 4])) {
                arr[x + dx[(dir + i) % 4]][y + dy[(dir + i) % 4]] += arr[x][y] * 0.07;
            } else {
                answer += arr[x][y] * 0.07;
            }
            sumMove += Math.floor(arr[x][y] * 0.07);

            // 2%
            if (isIn(x + dx[(dir + i) % 4] * 2, y + dy[(dir + i) % 4] * 2)) {
                arr[x + dx[(dir + i) % 4] * 2][y + dy[(dir + i) % 4] * 2] += arr[x][y] * 0.02;
            } else {
                answer += arr[x][y] * 0.02;
            }
            sumMove += Math.floor(arr[x][y] * 0.02);

            // 1%
            if (isIn(x - dx[dir] + dx[(dir + i) % 4], y - dy[dir] + dy[(dir + i) % 4])) {
                arr[x - dx[dir] + dx[(dir + i) % 4]][y - dy[dir] + dy[(dir + i) % 4]] += arr[x][y] * 0.01;
            } else {
                answer += arr[x][y] * 0.01;
            }
            sumMove += Math.floor(arr[x][y] * 0.01);
        }

        // a
        if (isIn(x + dx[dir], y + dy[dir])) {
            arr[x + dx[dir]][y + dy[dir]] += (arr[x][y] - sumMove);
        } else {
            answer += (arr[x][y] - sumMove);
        }
        arr[x][y] = 0;


    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
