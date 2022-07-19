import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MonominoDominoT20061 {
    static boolean[][] arr;
    static int answer = 0;
    static int tileCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new boolean[10][10];
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // t == 1 : (x, y)
            // t == 2 : (x, y), (x, y+1)
            // t == 3 : (x, y), (x+1, y)
            solution(t, x, y);
            delete();
            special();
        }

        for (boolean[] booleans : arr) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) tileCount++;
            }
        }
        System.out.println(answer);
        System.out.println(tileCount);
    }

    private static void special() {
        int greenCnt = 0;
        int blueCnt = 0;
        for (int i = 4; i <= 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j]) {
                    greenCnt++;
                    break;
                }
            }
            for (int j = 0; j < 4; j++) {
                if (arr[j][i]) {
                    blueCnt++;
                    break;
                }
            }
        }

        while (greenCnt-- > 0) {
            for (int j = 0; j < 4; j++) {
                arr[9][j] = false;
            }
            moveGreen(9, 4);
        }
        while (blueCnt-- > 0) {
            for (int i = 0; i < 4; i++) {
                arr[i][9] = false;
            }
            moveBlue(9);
        }

    }

    private static void printArr() {
        for (boolean[] booleans : arr) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) {

                    System.out.print("o");
                } else {
                    System.out.print("x");
                }
            }
            System.out.println();
        }
    }

    private static void moveBlue(int index) { // 6 6
        for (int j = index - 1; j >= 4; j--) {
            boolean[] temp = new boolean[4];
            for (int i = 0; i < 4; i++) {
                temp[i] = arr[i][j];
            }
            for (int i = 0; i < 4; i++) {
                arr[i][j + 1] = temp[i];
            }
            for (int i = 0; i < 4; i++) {
                arr[i][j] = false;
            }
        }
    }

    private static void moveGreen(int index, int t) {
        for (int i = index - 1; i >= 4; i--) {
            boolean[] temp = new boolean[4];
            for (int j = 0; j < 4; j++) {
                temp[j] = arr[i][j];
            }
            for (int j = 0; j < 4; j++) {
                arr[i + 1][j] = temp[j];
            }
            for (int j = 0; j < 4; j++) {
                arr[i][j] = false;
            }
        }
    }

    private static void delete() {
        for (int i = 9; i >= 6; i--) {
            boolean flag = true;
            for (int j = 0; j < 4; j++) {
                if (!arr[i][j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) { // i행 삭제
                answer++;
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = false;
                }
                moveGreen(i, 6);
                i++;
            }
        }
        for (int i = 9; i >= 6; i--) {
            boolean flag = true;
            for (int j = 0; j < 4; j++) {
                if (!arr[j][i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
                for (int j = 0; j < 4; j++) {
                    arr[j][i] = false;
                }
                moveBlue(i);
                i++;
            }
        }
    }

    private static void solution(int t, int x, int y) {
        if (t == 1) {
            int cnt = 0;
            for (int i = x + 1; i < 10; i++) {
                if (arr[i][y]) {
                    break;
                } else {
                    cnt++;
                }
            }
            arr[x + cnt][y] = true;
            cnt = 0;
            for (int j = y + 1; j < 10; j++) {
                if (arr[x][j]) {
                    break;
                } else {
                    cnt++;
                }
            }
            arr[x][y + cnt] = true;

            // 빨간색
            arr[x][y] = false;
        } else if (t == 2) { //(x, y), (x, y+1)
            int cnt = 0;
            for (int i = x + 1; i < 10; i++) {
                if (arr[i][y] || arr[i][y + 1]) {
                    break;
                } else {
                    cnt++;
                }
            }
            arr[x + cnt][y] = true;
            arr[x + cnt][y + 1] = true;

            cnt = 0;
            for (int j = y + 2; j < 10; j++) {
                if (arr[x][j]) {
                    break;
                } else {
                    cnt++;
                }
            }
            arr[x][y + cnt] = true;
            arr[x][y + cnt + 1] = true;

            //빨간색
            arr[x][y] = false;
            arr[x][y + 1] = false;
        } else { // t == 3 , (x, y), (x+1, y)
            int cnt = 0;
            for (int i = x + 2; i < 10; i++) {
                if (arr[i][y]) {
                    break;
                } else {
                    cnt++;
                }
            }
            arr[x + cnt][y] = true;
            arr[x + cnt + 1][y] = true;

            cnt = 0;
            for (int j = y + 1; j < 10; j++) {
                if (arr[x][j] || arr[x + 1][j]) {
                    break;
                } else {
                    cnt++;
                }
            }
            arr[x][y + cnt] = true;
            arr[x + 1][y + cnt] = true;

            //빨간색
            arr[x][y] = false;
            arr[x + 1][y] = false;
        }
    }
}
