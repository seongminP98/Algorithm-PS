import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P1987 {
    static int R, C;
    static char[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = 1;
    static Set<Character> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        set.add(arr[0][0]);
        dfs(0, 0);
        System.out.println(answer);

    }

    static void dfs(int x, int y) {

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (set.contains(arr[nx][ny])) {
                    answer = Math.max(answer, set.size());
                    //여기서 return하면 다른길로 안감.
                } else {
                    set.add(arr[nx][ny]);
                    dfs(nx, ny);
                    set.remove(arr[nx][ny]);
                }
            }
        }
    }
}
