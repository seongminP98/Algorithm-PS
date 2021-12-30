import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GlobalWarming5212 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        char[][] newMap = new char[R][C];
        int startR = Integer.MAX_VALUE;
        int endR = 0;
        int startC = Integer.MAX_VALUE;
        int endC = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') {
                    int check = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == 'X') {
                            check++;
                        }
                    }
                    if (check >= 2) {
                        if (startR > i) {
                            startR = i;
                        }
                        if (startC > j) {
                            startC = j;
                        }
                        if (endR < i) {
                            endR = i;
                        }
                        if (endC < j) {
                            endC = j;
                        }
                        newMap[i][j] = 'X';
                    } else {
                        newMap[i][j] = '.';
                    }
                } else {
                    newMap[i][j] = '.';
                }
            }
        }
        for (int i = startR; i <= endR; i++) {
            for (int j = startC; j <= endC; j++) {
                System.out.print(newMap[i][j]);
            }
            System.out.println();
        }
    }
}
