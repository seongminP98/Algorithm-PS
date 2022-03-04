import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NewGame17780 {
    static int N, K;
    static int[][] arr;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static Chess[][] arrChess;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        arrChess = new Chess[K + 1][2];
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            arrChess[i][0] = new Chess(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i, 1);
        }
        Play();
        System.out.println(-1);
    }

    static void Play() {
        int count = 0;
        while (count++ < 1000) {
            for (int i = 1; i <= K; i++) {
                if (arrChess[i][0] == null)
                    continue;
                if (arrChess[i][0].cnt >= 4) {
                    System.out.println(count - 1);
                    System.exit(0);
                }
            }
            for (int i = 1; i <= K; i++) {
                Chess current = arrChess[i][0];
                if (current == null) {
                    continue;
                }
                int nx = current.x + dx[current.dir];
                int ny = current.y + dy[current.dir];
                int already = 0;
                for (int j = 1; j <= K; j++) {
                    if (arrChess[j][0] == null)
                        continue;
                    if (arrChess[j][0].x == nx && arrChess[j][0].y == ny) {
                        already = j;
                        break;
                    }
                }
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {

                    if (arr[nx][ny] == 0) { //흰색
                        if (already == 0) {  //이동하려는 칸에 말이 없음
                            arrChess[i][0].x = nx;
                            arrChess[i][0].y = ny;
                            if (arrChess[i][1] != null) {
                                arrChess[i][1].x = nx;
                                arrChess[i][1].y = ny;
                            }
                        } else { //이동하려는 칸에 말이 있음
                            if (arrChess[i][1] != null) { //나한테 업힌애가 있음.
                                arrChess[already][1] = arrChess[i][1];
                            } else {
                                arrChess[already][1] = arrChess[i][0];
                            }
                            arrChess[already][0].cnt += arrChess[i][0].cnt;

                            arrChess[i][0] = null;
                            arrChess[i][1] = null;
                        }
                    } else if (arr[nx][ny] == 1) { //빨강
                        if (already == 0) {
                            if (arrChess[i][1] != null) {

                                int number = arrChess[i][1].number;
                                arrChess[number][0] = arrChess[i][1];
                                arrChess[number][1] = arrChess[i][0];
                                arrChess[number][0].cnt = arrChess[i][0].cnt;
                                arrChess[number][0].x = nx;
                                arrChess[number][0].y = ny;
                                arrChess[i][0] = null;
                                arrChess[i][1] = null;
                            } else {
                                arrChess[i][0].x = nx;
                                arrChess[i][0].y = ny;
                            }
                        } else {
                            arrChess[already][1] = arrChess[i][0];
                            arrChess[already][0].cnt += arrChess[i][0].cnt;
                            arrChess[i][0] = null;
                            arrChess[i][1] = null;
                        }
                    } else { //파랑
                        if (arrChess[i][0].dir == 1 || arrChess[i][0].dir == 3) {
                            arrChess[i][0].dir++;
                        } else {
                            arrChess[i][0].dir--;
                        }
                        nx = arrChess[i][0].x + dx[arrChess[i][0].dir];
                        ny = arrChess[i][0].y + dy[arrChess[i][0].dir];
                        already = 0;
                        for (int j = 1; j <= K; j++) {
                            if (arrChess[j][0] == null)
                                continue;
                            if (arrChess[j][0].x == nx && arrChess[j][0].y == ny) {
                                already = j;
                                break;
                            }
                        }
                        if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {

                            if (arr[nx][ny] == 0) { //흰색
                                if (already == 0) {  //이동하려는 칸에 말이 없음
                                    arrChess[i][0].x = nx;
                                    arrChess[i][0].y = ny;
                                    if (arrChess[i][1] != null) {
                                        arrChess[i][1].x = nx;
                                        arrChess[i][1].y = ny;
                                    }
                                } else { //이동하려는 칸에 말이 있음
                                    if (arrChess[i][1] != null) { //나한테 업힌애가 있음.
                                        arrChess[already][1] = arrChess[i][1];
                                    } else {
                                        arrChess[already][1] = arrChess[i][0];
                                    }
                                    arrChess[already][0].cnt += arrChess[i][0].cnt;

                                    arrChess[i][0] = null;
                                    arrChess[i][1] = null;
                                }
                            } else if (arr[nx][ny] == 1) { //빨강
                                if (already == 0) {
                                    if (arrChess[i][1] != null) {

                                        int number = arrChess[i][1].number;
                                        arrChess[number][0] = arrChess[i][1];
                                        arrChess[number][1] = arrChess[i][0];
                                        arrChess[number][0].cnt = arrChess[i][0].cnt;
                                        arrChess[number][0].x = nx;
                                        arrChess[number][0].y = ny;
                                        arrChess[i][0] = null;
                                        arrChess[i][1] = null;
                                    } else {
                                        arrChess[i][0].x = nx;
                                        arrChess[i][0].y = ny;
                                    }
                                } else {
                                    arrChess[already][1] = arrChess[i][0];
                                    arrChess[already][0].cnt += arrChess[i][0].cnt;
                                    arrChess[i][0] = null;
                                    arrChess[i][1] = null;
                                }
                            }


                        }
                    }
                } else { //범위 밖, =파랑
                    if (arrChess[i][0].dir == 1 || arrChess[i][0].dir == 3) {
                        arrChess[i][0].dir++;
                    } else {
                        arrChess[i][0].dir--;
                    }
                    nx = current.x + dx[current.dir];
                    ny = current.y + dy[current.dir];
                    already = 0;
                    for (int j = 1; j <= K; j++) {
                        if (arrChess[j][0] == null)
                            continue;
                        if (arrChess[j][0].x == nx && arrChess[j][0].y == ny) {
                            already = j;
                            break;
                        }
                    }

                    if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {

                        if (arr[nx][ny] == 0) { //흰색
                            if (already == 0) {  //이동하려는 칸에 말이 없음
                                arrChess[i][0].x = nx;
                                arrChess[i][0].y = ny;
                                if (arrChess[i][1] != null) {
                                    arrChess[i][1].x = nx;
                                    arrChess[i][1].y = ny;
                                }
                            } else { //이동하려는 칸에 말이 있음
                                if (arrChess[i][1] != null) { //나한테 업힌애가 있음.
                                    arrChess[already][1] = arrChess[i][1];
                                } else {
                                    arrChess[already][1] = arrChess[i][0];
                                }
                                arrChess[already][0].cnt += arrChess[i][0].cnt;

                                arrChess[i][0] = null;
                                arrChess[i][1] = null;
                            }
                        } else if (arr[nx][ny] == 1) { //빨강
                            if (already == 0) {
                                if (arrChess[i][1] != null) {

                                    int number = arrChess[i][1].number;
                                    arrChess[number][0] = arrChess[i][1];
                                    arrChess[number][1] = arrChess[i][0];
                                    arrChess[number][0].cnt = arrChess[i][0].cnt;
                                    arrChess[number][0].x = nx;
                                    arrChess[number][0].y = ny;
                                    arrChess[i][0] = null;
                                    arrChess[i][1] = null;
                                } else {
                                    arrChess[i][0].x = nx;
                                    arrChess[i][0].y = ny;
                                }
                            } else {
                                arrChess[already][1] = arrChess[i][0];
                                arrChess[already][0].cnt += arrChess[i][0].cnt;
                                arrChess[i][0] = null;
                                arrChess[i][1] = null;
                            }
                        }
                    }
                }
            }
        }
    }

    static class Chess {
        int x, y, dir, number, cnt;

        @Override
        public String toString() {
            return "Chess{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    ", number=" + number +
                    ", cnt=" + cnt +
                    '}';
        }

        public Chess(int x, int y, int dir, int number, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.number = number;
            this.cnt = cnt;
        }
    }
}
