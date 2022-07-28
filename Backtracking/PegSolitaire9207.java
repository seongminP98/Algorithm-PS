import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PegSolitaire9207 {
    static char[][] arr;
    static int pin = 0;
    static int pinAnswer;
    static int moveAnswer = 60;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            arr = new char[5][9];
            pin = 0;
            for (int i = 0; i < 5; i++) {
                String s = br.readLine();
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = s.charAt(j);
                    if (arr[i][j] == 'o') {
                        pin++;
                    }
                }
            }
            pinAnswer = pin;
            moveAnswer = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 9; j++) {
                    if (arr[i][j] == 'o')
                        dfs(i, j, pin, 0);
                }
            }

            if (T != 0) br.readLine();

            System.out.println(pinAnswer + " " + moveAnswer);
        }
    }

    private static void dfs(int x, int y, int remain, int count) {
        if (remain < pinAnswer) {
            pinAnswer = remain;
            moveAnswer = count;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 9 && arr[nx][ny] == 'o') {
                int mx = nx + dx[d];
                int my = ny + dy[d];
                if (mx >= 0 && mx < 5 && my >= 0 && my < 9 && arr[mx][my] == '.') {
                    arr[x][y] = '.';
                    arr[nx][ny] = '.';
                    arr[mx][my] = 'o';
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 9; j++) {
                            if (arr[i][j] == 'o') {
                                dfs(i, j, remain - 1, count + 1);
                            }
                        }
                    }
                    arr[x][y] = 'o';
                    arr[nx][ny] = 'o';
                    arr[mx][my] = '.';
                }
            }
        }
    }
}
