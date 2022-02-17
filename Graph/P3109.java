import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3109 {
    static int R, C;
    static char[][] arr;
    static int[] dx = {-1, 0, 1};//위, 앞, 아래
    static int[] dy = {1, 1, 1};
    static int answer = 0;

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
        for (int i = 0; i < R; i++) {
            dfs(i, 0);
        }
        System.out.println(answer);
    }

    static boolean dfs(int x, int y) {
        for (int k = 0; k < 3; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && arr[nx][ny] == '.') {
                arr[nx][ny] = 'x';//파이프를 놓을 수 없어도 x로 바꿔도됨. 어짜피 못가는길.
                if (ny == C - 1) {
                    answer++;
                    return true;
                } else {
                    if (dfs(nx, ny)) { //도착을 했으면 끝임. 한칸 뒤로 되돌아가서 하면안됨.
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
