import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Cubing5373 {
    static List<int[][]> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            init(); // 큐브 초기화
            int N = Integer.parseInt(br.readLine()); // 큐브를 돌린 횟수
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String cmd = st.nextToken();
                char side = cmd.charAt(0);
                char dir = cmd.charAt(1);
                turn(side, dir);
            }

            for (int[] ints : list.get(0)) {
                for (int anInt : ints) {
                    if(anInt == 0) {
                        sb.append('w');
                    } else if(anInt == 1)  {
                        sb.append('y');
                    } else if(anInt == 2) {
                        sb.append('r');
                    } else if(anInt == 3) {
                        sb.append('o');
                    } else if(anInt == 4) {
                        sb.append('g');
                    } else if(anInt == 5) {
                        sb.append('b');
                    }
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    private static void turn(char side, char dir) {

        if (dir == '+') { // 시계방향
            switch (side) {
                case 'U': // 위
                    turn(2, 4, 3, 5, true, 0);
                    transSide(0, true);
                    break;
                case 'B': // 뒤
                    changeCubePositionFront();
                    turn(2, 4, 3, 5, true, 0);
                    transSide(0, true);
                    changeCubePositionFront();
                    changeCubePositionFront();
                    changeCubePositionFront();
                    break;
                case 'D': // 아래
                    changeCubePositionFront();
                    changeCubePositionFront();
                    turn(2, 4, 3, 5, true, 0);
                    transSide(0, true);
                    changeCubePositionFront();
                    changeCubePositionFront();

                    break;
                case 'F': // 앞
                    changeCubePositionFront();
                    changeCubePositionFront();
                    changeCubePositionFront();
                    turn(2, 4, 3, 5, true, 0);
                    transSide(0, true);
                    changeCubePositionFront();
                    break;
                case 'L': // 왼
                    changeCubePositionRight();
                    turn(2, 4, 3, 5, true, 0);
                    transSide(0, true);
                    changeCubePositionRight();
                    changeCubePositionRight();
                    changeCubePositionRight();
                    break;
                case 'R': // 오른
                    changeCubePositionRight();
                    changeCubePositionRight();
                    changeCubePositionRight();
                    turn(2, 4, 3, 5, true, 0);
                    transSide(0, true);
                    changeCubePositionRight();
                    break;
                default:
                    break;

            }
        } else { // 반시계방향
            switch (side) {
                case 'U':
                    turn(2, 5, 3, 4, true, 0);
                    transSide(0, false);
                    break;
                case 'B':
                    changeCubePositionFront();
                    turn(2, 5, 3, 4, true, 0);
                    transSide(0, false);
                    changeCubePositionFront();
                    changeCubePositionFront();
                    changeCubePositionFront();
                    break;
                case 'D':
                    changeCubePositionFront();
                    changeCubePositionFront();
                    turn(2, 5, 3, 4, true, 0);
                    transSide(0, false);
                    changeCubePositionFront();
                    changeCubePositionFront();
                    break;
                case 'F':
                    changeCubePositionFront();
                    changeCubePositionFront();
                    changeCubePositionFront();
                    turn(2, 5, 3, 4, true, 0);
                    transSide(0, false);
                    changeCubePositionFront();
                    break;
                case 'L':
                    changeCubePositionRight();
                    turn(2, 5, 3, 4, true, 0);
                    transSide(0, false);
                    changeCubePositionRight();
                    changeCubePositionRight();
                    changeCubePositionRight();
                    break;
                case 'R':
                    changeCubePositionRight();
                    changeCubePositionRight();
                    changeCubePositionRight();
                    turn(2, 5, 3, 4, true, 0);
                    transSide(0, false);
                    changeCubePositionRight();
                    break;
                default:
                    break;

            }
        }
    }

    private static void turn(int first, int second, int third, int fourth, boolean isRow, int num) {
        // 일단 윗면
        if (isRow) {
            int[] temp = new int[3];
            for (int i = 0; i < 3; i++) {
                temp[i] = list.get(first)[num][i]; // 첫번째 면 저장
            }
            for (int i = 0; i < 3; i++) {
                list.get(first)[num][i] = list.get(fourth)[num][i]; // 첫번째 면에 네번째면 복사
            }
            int[] temp2 = new int[3];
            for (int i = 0; i < 3; i++) {
                temp2[i] = list.get(second)[num][i]; // 두번째 면 저장
            }
            for (int i = 0; i < 3; i++) {
                list.get(second)[num][i] = temp[i]; // 두번째 면에 첫번째 면 복사
            }
            for (int i = 0; i < 3; i++) {
                temp[i] = list.get(third)[num][2 - i]; // 세번째 면 저장
            }
            for (int i = 0; i < 3; i++) {
                list.get(third)[num][2 - i] = temp2[i]; // 세번째 면에 두번째 면 복사
            }
            for (int i = 0; i < 3; i++) { // 너벤째 면에 세번째 면 복사
                list.get(fourth)[num][i] = temp[i];
            }

        }
    }

    private static void changeCubePositionRight() {
        int[][] tempTop = new int[3][3];
        int[][] tempRight = new int[3][3];
        int[][] tempBottom = new int[3][3];
        int[][] tempLeft = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempRight[i][j] = list.get(0)[2 - j][i];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempBottom[i][j] = list.get(5)[2 - j][2 - i];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempLeft[i][j] = list.get(1)[j][i];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempTop[i][j] = list.get(4)[2 - j][i];
            }
        }

        transSide(2, true); // 앞쪽은 시계방향
        transSide(3, true); // 뒤쪽은 시계방향
        for (int i = 0; i < 3; i++) { // 위
            for (int j = 0; j < 3; j++) {
                list.get(0)[i][j] = tempTop[i][j];
            }
        }
        for (int i = 0; i < 3; i++) { // 아래
            for (int j = 0; j < 3; j++) {
                list.get(1)[i][j] = tempBottom[i][j];
            }
        }
        for (int i = 0; i < 3; i++) { // 오른
            for (int j = 0; j < 3; j++) {
                list.get(5)[i][j] = tempRight[i][j];
            }
        }
        for (int i = 0; i < 3; i++) { // 왼
            for (int j = 0; j < 3; j++) {
                list.get(4)[i][j] = tempLeft[i][j];
            }
        }
    }

    private static void changeCubePositionFront() {
        int[][] tempTop = new int[3][3];
        int[][] tempFront = new int[3][3];
        int[][] tempBottom = new int[3][3];
        int[][] tempBack = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempFront[i][j] = list.get(0)[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempBottom[i][j] = list.get(2)[2 - i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempBack[i][j] = list.get(1)[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempTop[i][j] = list.get(3)[2 - i][j];
            }
        }
        transSide(4, true); // 왼쪽은 시계방향
        transSide(5, false); // 오른쪽은 반시계방향
        for (int i = 0; i < 3; i++) { // 위
            for (int j = 0; j < 3; j++) {
                list.get(0)[i][j] = tempTop[i][j];
            }
        }
        for (int i = 0; i < 3; i++) { // 아래
            for (int j = 0; j < 3; j++) {
                list.get(1)[i][j] = tempBottom[i][j];
            }
        }
        for (int i = 0; i < 3; i++) { // 앞
            for (int j = 0; j < 3; j++) {
                list.get(2)[i][j] = tempFront[i][j];
            }
        }
        for (int i = 0; i < 3; i++) { // 뒤
            for (int j = 0; j < 3; j++) {
                list.get(3)[i][j] = tempBack[i][j];
            }
        }
    }

    private static void transSide(int sideNum, boolean isClockwise) { //돌리는면 변환
        int[][] temp = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(list.get(sideNum)[i], 0, temp[i], 0, 3);
        }
        if (isClockwise) { // 시계방향
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    list.get(sideNum)[i][j] = temp[3 - j - 1][i];
                }
            }
        } else { // 반시계방향
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    list.get(sideNum)[i][j] = temp[j][3 - i - 1];
                }
            }
        }
    }

    private static void init() {
        /*
        U(윗면) : w,      0
        D(아랫면) : y,     1
        F(앞면) : r,       2
        B(뒷면) : o,      3
        L(왼쪽면) : g,     4
        R(오른쪽면) : b     5
         */
        list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(new int[3][3]);
            for (int[] ints : list.get(i)) {
                Arrays.fill(ints, i);
            }
        }
    }
}
