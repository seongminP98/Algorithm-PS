import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Watch15683 {
    static int N, M;
    static int[][] arr;
    static List<CCTV> cctv;
    static List<Dir> dirList;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        cctv = new ArrayList<>();
        dirList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0 && arr[i][j] != 6) {
                    cctv.add(new CCTV(i, j, arr[i][j]));
                }
            }
        }
        permutation(0);

        System.out.println(answer);
    }

    static void permutation(int depth) {
        if (depth == cctv.size()) {
            check(dirList);
            return;
        }
        int x = cctv.get(depth).x;
        int y = cctv.get(depth).y;
        int value = cctv.get(depth).value;

        if (value == 2) {
            for (int i = 0; i < 2; i++) {
                dirList.add(new Dir(x, y, i, value));
                permutation(depth + 1);
                dirList.remove(dirList.size() - 1);
            }
        } else if (value == 5) {
            dirList.add(new Dir(x, y, 0, value));
            permutation(depth + 1);
            dirList.remove(dirList.size() - 1);
        } else {
            for (int i = 0; i < 4; i++) {
                dirList.add(new Dir(x, y, i, value));
                permutation(depth + 1);
                dirList.remove(dirList.size() - 1);
            }
        }

    }

    static void check(List<Dir> list) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        for (Dir dir : list) {
            if (dir.value == 1) {
                if (dir.d == 0) {
                    right(dir.x, dir.y, copy);
                } else if (dir.d == 1) {
                    down(dir.x, dir.y, copy);
                } else if (dir.d == 2) {
                    left(dir.x, dir.y, copy);
                } else {
                    up(dir.x, dir.y, copy);
                }
            } else if (dir.value == 2) {
                if (dir.d == 0) {
                    left(dir.x, dir.y, copy);
                    right(dir.x, dir.y, copy);
                } else {
                    up(dir.x, dir.y, copy);
                    down(dir.x, dir.y, copy);
                }
            } else if (dir.value == 3) {
                if (dir.d == 0) {
                    right(dir.x, dir.y, copy);
                    up(dir.x, dir.y, copy);
                } else if (dir.d == 1) {
                    right(dir.x, dir.y, copy);
                    down(dir.x, dir.y, copy);
                } else if (dir.d == 2) {
                    down(dir.x, dir.y, copy);
                    left(dir.x, dir.y, copy);
                } else {
                    left(dir.x, dir.y, copy);
                    up(dir.x, dir.y, copy);
                }
            } else if (dir.value == 4) {
                if (dir.d == 0) {
                    right(dir.x, dir.y, copy);
                    up(dir.x, dir.y, copy);
                    down(dir.x, dir.y, copy);
                } else if (dir.d == 1) {
                    right(dir.x, dir.y, copy);
                    down(dir.x, dir.y, copy);
                    left(dir.x, dir.y, copy);
                } else if (dir.d == 2) {
                    down(dir.x, dir.y, copy);
                    left(dir.x, dir.y, copy);
                    up(dir.x, dir.y, copy);
                } else {
                    left(dir.x, dir.y, copy);
                    up(dir.x, dir.y, copy);
                    right(dir.x, dir.y, copy);
                }
            } else if (dir.value == 5) {
                right(dir.x, dir.y, copy);
                left(dir.x, dir.y, copy);
                down(dir.x, dir.y, copy);
                up(dir.x, dir.y, copy);
            }
        }
        int sum = 0;
        for (int[] ints : copy) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    sum++;
                }
            }
        }
        answer = Math.min(answer, sum);
    }


    static void right(int x, int y, int[][] arr) {
        for (int i = y + 1; i < M; i++) {
            if (arr[x][i] == 0) {
                arr[x][i] = 7;
            } else {
                if (arr[x][i] == 6) {
                    break;
                }
            }
        }
    }

    static void left(int x, int y, int[][] arr) {
        for (int i = y - 1; i >= 0; i--) {
            if (arr[x][i] == 0) {
                arr[x][i] = 7;
            } else {
                if (arr[x][i] == 6) {
                    break;
                }
            }
        }
    }

    static void down(int x, int y, int[][] arr) {
        for (int i = x + 1; i < N; i++) {
            if (arr[i][y] == 0) {
                arr[i][y] = 7;
            } else {
                if (arr[i][y] == 6) {
                    break;
                }
            }
        }
    }

    static void up(int x, int y, int[][] arr) {
        for (int i = x - 1; i >= 0; i--) {
            if (arr[i][y] == 0) {
                arr[i][y] = 7;
            } else {
                if (arr[i][y] == 6) {
                    break;
                }
            }
        }
    }

    static class CCTV {
        int x, y, value;

        public CCTV(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    static class Dir {
        int x, y, d, value;

        public Dir(int x, int y, int d, int value) { //d는 방향. 1 2 3 4 우 하 좌 상상
            this.x = x;
            this.y = y;
            this.d = d;
            this.value = value;
        }
    }
}
