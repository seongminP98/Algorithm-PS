import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class WizardSharkBlizzard21611 {
    static int N, M;
    static int[][] arr;
    static int sharkX, sharkY;
    static int[] dx = {0, -1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, 0, -1, 1};
    static int answerOne = 0;
    static int answerTwo = 0;
    static int answerThree = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 맵의 크기
        M = Integer.parseInt(st.nextToken()); // 블리자드 시전 횟수
        arr = new int[N][N];
        sharkX = sharkY = N / 2;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            usingBlizzard(d, s);                                // 블리자드 사용
            String marbleStr = moveMarbles();                   // 구슬 이동
            String afterExplosion = explosion(marbleStr);       // 폭발
            String afterChange = changeMarble(afterExplosion);  // 구슬 변화
            arr = nextMap(afterChange);                         // 맵 변화
        }

        System.out.println(answerOne + answerTwo * 2 + answerThree * 3);
    }

    private static void usingBlizzard(int d, int s) { // 1번
        for (int i = 1; i <= s; i++) {
            int nx = sharkX + dx[d] * i;
            int ny = sharkY + dy[d] * i;
            arr[nx][ny] = 0;
        }
    }


    private static String moveMarbles() { // 2번
        StringBuilder sb = new StringBuilder();
        int x = sharkX;
        int y = sharkY;
        int d = 3; // 시작 방향은 왼쪽
        for (int i = 1; i < N; i++) { // 1 1 2 2 3 3 4 4 ... N-1 N-1 N-1
            int length = 2;
            if (i == N - 1) length++;
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < i; k++) {
                    x += dx[d];
                    y += dy[d];
                    if (arr[x][y] != 0) {
                        sb.append(arr[x][y]);
                    }
                }
                d = nextDir(d);
            }
        }

        return sb.toString();
    }

    private static int nextDir(int d) { // 좌 하 우 상
        if (d == 3) {
            return 2;
        } else if (d == 2) {
            return 4;
        } else if (d == 4) {
            return 1;
        } else {
            return 3;
        }
    }

    private static String explosion(String marbleStr) { // 3번
//        nt cnt = N * N / 4;
//        cnt++;
//        while (cnt-- > 0) {
//            marbleStr = marbleStr.replaceAll("1{4,}", "");
//            marbleStr = marbleStr.replaceAll("2{4,}", "");
//            marbleStr = marbleStr.replaceAll("3{4,}", "");
//        }
        boolean flag = true;
        StringBuilder nextStr = new StringBuilder();
        while (flag) { // 더이상 폭발하지 않을 때까지 반복
            flag = false;

            for (int i = 0; i < marbleStr.length(); i++) {
                int j = 1;
                int cnt = 1;
                if (i == marbleStr.length() - 1) {
                    nextStr.append(marbleStr.charAt(marbleStr.length() - 1) - '0');
                    break;
                }
                while (marbleStr.charAt(i) == marbleStr.charAt(i + j)) {
                    cnt++;
                    j++;
                    if (i + j >= marbleStr.length()) break;
                }
                if (cnt >= 4) {
                    if (marbleStr.charAt(i) == '1') {
                        answerOne += cnt;
                    } else if (marbleStr.charAt(i) == '2') {
                        answerTwo += cnt;
                    } else if (marbleStr.charAt(i) == '3') {
                        answerThree += cnt;
                    }
                    flag = true;
                } else {
                    for (int k = 0; k < cnt; k++) {
                        nextStr.append(marbleStr.charAt(i + k));
                    }
                }
                i += (cnt - 1);
            }
            marbleStr = nextStr.toString();
            nextStr = new StringBuilder();
        }
        return marbleStr;
    }

    private static String changeMarble(String marbleStr) { // 4번
        StringBuilder nextStr = new StringBuilder();
        for (int i = 0; i < marbleStr.length(); i++) {
            int cnt = 1;
            for (int j = 1; j < 3; j++) {
                if (i == marbleStr.length() - 1) {
                    break;
                }
                if (i + j >= marbleStr.length()) break;
                if (marbleStr.charAt(i) == marbleStr.charAt(i + j)) {
                    cnt++;

                } else {
                    break;
                }
            }
            i += (cnt - 1);
            nextStr.append(cnt).append(marbleStr.charAt(i) - '0');
        }
        return nextStr.toString();
    }

    private static int[][] nextMap(String marbleStr) { // 5번
        int[][] nextMap = new int[N][N];
        int x = sharkX;
        int y = sharkY;
        int d = 3;
        int idx = 0;
        if (marbleStr.length() == 0) {
            return nextMap;
        }
        for (int i = 1; i < N; i++) {
            int length = 2;
            if (i == N - 1) length++;
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < i; k++) {
                    x += dx[d];
                    y += dy[d];
                    nextMap[x][y] = marbleStr.charAt(idx++) - '0';
                    if (idx >= marbleStr.length()) {

                        return nextMap;
                    }
                }
                d = nextDir(d);
            }
        }
        return nextMap;
    }
}
