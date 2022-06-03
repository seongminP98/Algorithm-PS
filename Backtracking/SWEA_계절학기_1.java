import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_계절학기_1 {
    static int N, M, K;
    static Shark baby, mom;
    static Net[] nets;
    static int[][] arr;
    static int[][][] netInfo;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Integer[][][] visited;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 맵 크기
            M = Integer.parseInt(st.nextToken()); // 그물 수
            K = Integer.parseInt(st.nextToken()); // 체력
            arr = new int[N + 1][N + 1];
            st = new StringTokenizer(br.readLine());
            baby = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            baby.k = K;
            st = new StringTokenizer(br.readLine());
            mom = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            nets = new Net[M];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                nets[i] = new Net(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), true);
            }
            netInfo = new int[M][N + 1][N + 1];
            setNetAndMap();
            visited = new Integer[N + 1][N + 1][baby.k + 1];
            visited[baby.x][baby.y][baby.k] = 0;
            answer = Integer.MAX_VALUE;
            dfs(baby);
            if (answer == Integer.MAX_VALUE) {
                answer = -1;
            }
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }

    private static void dfs(Shark baby) {
        if (baby.x == mom.x && baby.y == mom.y) {
            answer = Math.min(answer, baby.time);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = baby.x + dx[i];
            int ny = baby.y + dy[i];
            if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && (visited[nx][ny][baby.k] == null || visited[nx][ny][baby.k] > baby.time)) {
                if (arr[nx][ny] > 0) {
                    if (arr[nx][ny] < baby.k) {
                        List<Integer> list = new ArrayList<>();
                        int h = 0;
                        for (int k = 0; k < nets.length; k++) {
                            if (isInclude(nx, ny, nets[k]) && nets[k].check) {
                                nets[k].check = false;
                                h += nets[k].p;
                                list.add(k);
                                for (int x = 1; x <= N; x++) {
                                    for (int y = 1; y <= N; y++) {
                                        if (netInfo[k][x][y] != 0) {
                                            arr[x][y] -= netInfo[k][x][y];
                                        }
                                    }
                                }
                            }
                        }
                        if (arr[mom.x][mom.y] >= baby.k - h) {
                            visited[nx][ny][baby.k] = baby.time;
                            for (Integer k : list) {
                                nets[k].check = true;
                                for (int x = 1; x <= N; x++) {
                                    for (int y = 1; y <= N; y++) {
                                        if (netInfo[k][x][y] != 0) {
                                            arr[x][y] += netInfo[k][x][y];
                                        }
                                    }
                                }
                            }
                        } else {
                            visited[nx][ny][baby.k] = baby.time;
                            dfs(new Shark(nx, ny, baby.k - h, baby.time + 1));
                            for (Integer k : list) {
                                nets[k].check = true;
                                for (int x = 1; x <= N; x++) {
                                    for (int y = 1; y <= N; y++) {
                                        if (netInfo[k][x][y] != 0) {
                                            arr[x][y] += netInfo[k][x][y];
                                        }
                                    }
                                }
                            }
                        }


                    }
                } else {
                    visited[nx][ny][baby.k] = baby.time;
                    dfs(new Shark(nx, ny, baby.k, baby.time + 1));
                }
            }
        }
    }

    private static void setNetAndMap() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 0; k < nets.length; k++) {
                    if (isInclude(i, j, nets[k])) {
                        arr[i][j] += nets[k].p;
                        netInfo[k][i][j] += nets[k].p;
                    }
                }
            }
        }
    }

    private static boolean isInclude(int i, int j, Net net) {
        return Math.abs(i - net.x) + Math.abs(j - net.y) <= net.d;
    }

    private static class Net {
        int x, y, d, p;
        boolean check;

        public Net(int x, int y, int d, int p, boolean check) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.p = p;
            this.check = check;
        }

        @Override
        public String toString() {
            return "Net{" +
                    "x=" + x +
                    ", y=" + y +
                    ", d=" + d +
                    ", p=" + p +
                    ", check=" + check +
                    '}';
        }
    }

    private static class Shark {
        int x, y, k, time;

        @Override
        public String toString() {
            return "Shark{" +
                    "x=" + x +
                    ", y=" + y +
                    ", k=" + k +
                    ", time=" + time +
                    '}';
        }

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Shark(int x, int y, int k, int time) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.time = time;
        }
    }
}
