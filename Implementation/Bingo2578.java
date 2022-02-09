import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bingo2578 {
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }
        int answer = 1;
        for (Integer integer : list) {
            delete(integer);
            if (bingoCheck()) {
                System.out.println(answer);
                break;
            }
            answer++;
        }
    }

    static boolean bingoCheck() {
        int bingo = 0;
        for (int i = 0; i < 5; i++) {
            boolean flag = false;
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] != 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                bingo++;
            }
        }
        for (int i = 0; i < 5; i++) {
            boolean flag = false;
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] != 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                bingo++;
            }
        }
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            if (arr[i][i] != 0) {
                flag = true;
                break;
            }
        }
        if (!flag)
            bingo++;

        flag = false;
        for (int i = 0; i < 5; i++) {
            if (arr[i][4 - i] != 0) {
                flag = true;
                break;
            }
        }
        if (!flag)
            bingo++;

        return bingo >= 3;
    }

    static void delete(int n) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == n) {
                    arr[i][j] = 0;
                    return;
                }
            }
        }
    }
}
