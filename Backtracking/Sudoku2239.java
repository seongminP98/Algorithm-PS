import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sudoku2239 {
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        
        dfs(0, 0);
    }

    static void dfs(int x, int y) {
        if (y == 9) {
            dfs(x + 1, 0);
            return;
        }
        if (x == 9) {
            StringBuilder sb = new StringBuilder();
            for (int[] ints : arr) {
                for (int anInt : ints) {
                    sb.append(anInt);
                }
                sb.append('\n');
            }
            System.out.print(sb);
            System.exit(0);
        }
        if (arr[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isPossible(x, y, i)) {
                    arr[x][y] = i;
                    dfs(x, y + 1);
                }
            }
            arr[x][y] = 0;
        } else {
            dfs(x, y + 1);
        }

    }

    static boolean isPossible(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (arr[x][i] == value) {
                return false;
            }
            if (arr[i][y] == value) {
                return false;
            }
        }
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
