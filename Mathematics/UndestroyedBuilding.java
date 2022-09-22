public class UndestroyedBuilding {
    public static void main(String[] args) {
        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};
        System.out.println(solution(board, skill));
    }

    private static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        // skill : type, r1, c1, r2, c2, degree
        // type : 1공격, 2회복
        int[][] arr = new int[board.length + 1][board[0].length + 1];
        for (int[] s : skill) {
            if (s[0] == 1) { // 공격
                arr[s[1]][s[2]] -= s[5];
                arr[s[3] + 1][s[4] + 1] -= s[5];

                arr[s[1]][s[4] + 1] += s[5];
                arr[s[3] + 1][s[2]] += s[5];
            } else { // 회복
                arr[s[1]][s[2]] += s[5];
                arr[s[3] + 1][s[4] + 1] += s[5];

                arr[s[1]][s[4] + 1] -= s[5];
                arr[s[3] + 1][s[2]] -= s[5];
            }
        }
        for (int[] ints : arr) {
            for (int i = 1; i < ints.length; i++) {
                ints[i] += ints[i - 1];
            }
        }
        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 1; i < arr.length; i++) {
                arr[i][j] += arr[i - 1][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
//                board[i][j] += arr[i][j];
                if (board[i][j] + arr[i][j] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
