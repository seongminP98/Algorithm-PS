import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SeatAssignment10157 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        int[][] arr = new int[R + 1][C + 1];
        int value = 1;
        int x = R;
        int y = 1;
        int d = 0;
        arr[x][y] = value;
        if (K > C * R) {
            System.out.println(0);
            System.exit(0);
        }
        while (value != K) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 1 && nx < R + 1 && ny >= 1 && ny < C + 1) {
                if (arr[nx][ny] != 0) {
                    if (d == 3) {
                        d = 0;
                    } else {
                        d++;
                    }
                } else {
                    arr[nx][ny] = ++value;
                    x = nx;
                    y = ny;
                }
            } else {
                if (d == 3) {
                    d = 0;
                } else {
                    d++;
                }
            }
        }
        System.out.println(y + " " + (R - x + 1));
    }
}
