import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FineDust17144 {
    static int R, C, T;
    static int[][] arr;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < T; i++) {
            arr = diffusion();

        }

        System.out.println(calc());
    }

    static int[][] diffusion() {
        int[][] temp = new int[R][C];
        int x = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == -1) {
                    temp[i][j] = -1;
                    x = i;
                }
                if (arr[i][j] != 0 && arr[i][j] != -1) {
                    int count = 0;
                    int amount = arr[i][j] / 5;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && arr[nx][ny] != -1) {
                            count++;
                            temp[nx][ny] += amount;
                        }
                    }
                    temp[i][j] += arr[i][j] - amount * count;
                }
            }
        }

        airCleaner(temp, x);


        return temp;
    }

    static void airCleaner(int[][] temp, int x) {
        int rightV = right(temp, x - 1);
        int upV = up1(temp, x - 1, rightV);
        int leftV = left(temp, 0, upV);
        down1(temp, x - 1, leftV);

        rightV = right(temp, x);
        int downV = down2(temp, x, rightV);
        leftV = left(temp, R - 1, downV);
        up2(temp, R - 1, x, leftV);

    }

    static int right(int[][] temp, int x) {
        int tmp = temp[x][1];
        int tmp2 = 0;
        for (int i = 1; i < C - 1; i++) {
            tmp2 = temp[x][i + 1];
            temp[x][i + 1] = tmp;
            tmp = tmp2;
        }
        temp[x][1] = 0;

        return tmp;
    }

    static int up1(int[][] temp, int x, int prev) {
        int tmp = prev;
        int tmp2 = 0;
        for (int i = x; i > 0; i--) {
            tmp2 = temp[i - 1][C - 1];
            temp[i - 1][C - 1] = tmp;
            tmp = tmp2;
        }
        return tmp;
    }

    static void up2(int[][] temp, int x, int end, int prev) {
        if (arr[x][0] == -1)
            return;

        int tmp = prev;
        int tmp2 = 0;
        for (int i = x; i > end + 1; i--) {
            tmp2 = temp[i - 1][0];
            temp[i - 1][0] = tmp;
            tmp = tmp2;
        }

    }

    static int left(int[][] temp, int x, int prev) {
        if(arr[x][0] == -1) {
            return 0;
        }
        int tmp = prev;
        int tmp2 = 0;
        for (int i = C - 1; i > 0; i--) {
            if(arr[x][i-1] == -1)
                break;
            tmp2 = temp[x][i - 1];
            temp[x][i - 1] = tmp;
            tmp = tmp2;
        }

        return tmp;
    }

    static int down2(int[][] temp, int x, int prev) {
        int tmp = prev;
        int tmp2 = 0;
        for (int i = x; i < R - 1; i++) {
            tmp2 = temp[i + 1][C - 1];
            temp[i + 1][C - 1] = tmp;
            tmp = tmp2;
        }

        return tmp;
    }

    static void down1(int[][] temp, int end, int prev) {
        if (arr[0][0] == -1)
            return;

        int tmp = prev;
        int tmp2 = 0;
        for (int i = 1; i < end; i++) {
            tmp2 = temp[i][0];
            temp[i][0] = tmp;
            tmp = tmp2;
        }

    }

    static int calc() {
        int sum = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt != -1) {
                    sum += anInt;
                }
            }
        }
        return sum;
    }
}
