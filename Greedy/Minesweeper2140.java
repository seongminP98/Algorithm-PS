import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Minesweeper2140 {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] >= 0) {
                    check(i, j, arr[i][j]);
                }
            }
        }
        int answer = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == -13 || anInt == -1) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static void check(int x, int y, int cur) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {

                if (arr[nx][ny] == -13 && cur > 0) { //# 지뢰 설치
                    cur--;
                    arr[nx][ny] = -1;
                } else if (arr[nx][ny] == -1 && cur > 0) { //지뢰
                    cur--;
                } else if (cur == 0 && arr[nx][ny] == -13) {
                    arr[nx][ny] = -2; // 지뢰 못놓음
                }
            }
        }
    }
}
