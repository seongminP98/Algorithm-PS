import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RepaintChessboard1018 {
    static boolean[][] arr;
    static int answer = 64;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) == 'W';
            }
        }

        for (int i = 0; i < (N - 7); i++) {
            for (int j = 0; j < (M - 7); j++) {
                solution(i, j);
            }
        }

        System.out.println(answer);
    }

    public static void solution(int x, int y) {
        int count = 0;

        boolean check = arr[x][y];

        for (int i = x; i < (x + 8); i++) {
            for (int j = y; j < (y + 8); j++) {
                if (arr[i][j] != check) {
                    count++;
                }
                check = !check;
            }
            check = !check;
        }
        count = Math.min(count, 64 - count); //첫번째 칸이 W일 때와 B일 때 중 작은 값.

        answer = Math.min(count, answer);
    }
}
