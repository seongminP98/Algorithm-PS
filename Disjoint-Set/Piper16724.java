import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Piper16724 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == 'D') {
                    arr[i][j] = 1;
                } else if (s.charAt(j) == 'L') {
                    arr[i][j] = 2;
                } else if (s.charAt(j) == 'R') {
                    arr[i][j] = 3;
                }
            }
        }
        int[][] visited = new int[N][M];
        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    visited[i][j] = num;
                    dfs(i, j, visited, num++);
                }
            }
        }
        Set<Integer> set = new HashSet<>(map.values());
        System.out.println(set.size());
    }

    static void dfs(int i, int j, int[][] visited, int num) {
        int nx = i + dx[arr[i][j]];
        int ny = j + dy[arr[i][j]];
        if (visited[nx][ny] == 0) {
            visited[nx][ny] = num;
            dfs(nx, ny, visited, num);
        } else {
            map.put(num, map.getOrDefault(visited[nx][ny], num));
        }
    }
}
