import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DragonCurve15685 {
    static boolean[][] arr;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new boolean[101][101];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            solution(y, x, d, g);
        }
        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] && arr[i + 1][j] && arr[i][j + 1] && arr[i + 1][j + 1]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static void solution(int x, int y, int d, int g) {
        List<Integer> dir = new ArrayList<>();
        dir.add(d);
        arr[x][y] = true;
        for (int i = 0; i < g; i++) {
            for (int j = dir.size() - 1; j >= 0; j--) {
                dir.add((dir.get(j) + 1) % 4); //다음 세대의 방향은 전 세대까지 들어온 방향의 역순으로 시계방향으로.
            }
        }
        for (Integer i : dir) {
            x += dx[i];
            y += dy[i];
            arr[x][y] = true;
        }
    }
}
