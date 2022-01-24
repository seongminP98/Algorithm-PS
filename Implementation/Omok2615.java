import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Omok2615 {
    static int[][] arr;
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[19][19];
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (arr[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        if (check(i, j, k, arr[i][j])) {
                            System.out.println(arr[i][j]);
                            System.out.println((i + 1) + " " + (j + 1));
                            System.exit(0);
                        }

                    }
                }
            }
        }

        System.out.println(0);

    }

    static boolean check(int x, int y, int d, int value) {
        int nx = x;
        int ny = y;
        int count = 1;

        int mx = x - dx[d];
        int my = y - dy[d];
        if (mx >= 0 && mx < 19 && my >= 0 && my < 19) { //반대방향으로는 체크하지 않음.
            if (value == arr[mx][my])
                return false;
        }

        for (int i = 0; i < 5; i++) {
            nx += dx[d];
            ny += dy[d];
            if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
                if (arr[nx][ny] == value) {
                    count++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return count == 5;
    }
}
