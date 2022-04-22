import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AntInHexaCage17370 {
    static int N;
    // x가 홀수는 위로 하나 아래로 두개 dx={-1,1,1} dy={0,-1,1}
    // x가 짝수는 위로 두개 아래로 하나 dx={-1,-1,1} dy={-1,1,0}
    static int[] odx = {-1, 1, 1};
    static int[] ody = {0, -1, 1};

    static int[] edx = {-1, -1, 1};
    static int[] edy = {-1, 1, 0};
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[100][100];
        // 내가 보기 편하려고 시작을 이렇게 함.
        visited[51][49] = true;
        visited[50][49] = true;
        dfs(0, 51, 49, 50, 49);
        System.out.println(answer);
    }

    static void dfs(int cnt, int bx, int by, int cx, int cy) {
        if (cnt == N - 1) { // 마지막은 여기서 확인
            for (int i = 0; i < 3; i++) {
                int nx, ny;
                if (cx % 2 == 0) { //짝수
                    nx = cx + edx[i];
                    ny = cy + edy[i];
                } else { //홀수
                    nx = cx + odx[i];
                    ny = cy + ody[i];
                }
                if (nx == bx && ny == by) continue; // 방금 왔던길

                if (visited[nx][ny]) {
                    answer++;
                }
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nx, ny;
            if (cx % 2 == 0) { //짝수
                nx = cx + edx[i];
                ny = cy + edy[i];
            } else { //홀수
                nx = cx + odx[i];
                ny = cy + ody[i];
            }
            if (nx == bx && ny == by) continue; // 방금 왔던길

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(cnt + 1, cx, cy, nx, ny);
                visited[nx][ny] = false;
            }
        }
    }
}
