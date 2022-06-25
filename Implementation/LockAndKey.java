import java.util.Arrays;

public class LockAndKey {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }

    private static boolean solution(int[][] key, int[][] lock) {
        int N = lock.length;
        int M = key.length;

        int[][] newLock = new int[N + 2 * (M - 1)][N + 2 * (M - 1)];
        for (int[] ints : newLock) {
            Arrays.fill(ints, 2); // 검사하기 편하게 하려고 만든 공간. 홈, 돌기 둘 다 아니어서 2로 세팅
        }

        // 자물쇠의 길이 + (열쇠의 길이-1)*2 크기의 새로운 자물쇠를 만든다.
        for (int i = M - 1; i <= M - 1 + N - 1; i++) {
            for (int j = M - 1; j <= M - 1 + N - 1; j++) {
                newLock[i][j] = lock[i - (M - 1)][j - (M - 1)];
            }
        }


        for (int t = 0; t < 4; t++) { // 기존 자물쇠로 시계방향으로 돌려가면서 확인.
            for (int i = 0; i <= newLock.length - M; i++) {
                for (int j = 0; j <= newLock.length - M; j++) {
                    int[][] newKey = new int[newLock.length][newLock.length]; // 새로운 열쇠를 만든다.

                    for (int x = i; x < i + M; x++) {
                        for (int y = j; y < j + M; y++) {
                            newKey[x][y] = key[x - i][y - j];
                        }
                    }
                    if (isUnlock(newKey, newLock)) {
                        return true;
                    }
                }
            }
            key = turnClockwise(key);
        }

        return false;
    }

    private static boolean isUnlock(int[][] newKey, int[][] newLock) {
        for (int i = 0; i < newKey.length; i++) {
            for (int j = 0; j < newKey.length; j++) {
                // 둘 다 홈이거나, 둘 다 돌기면 false
                if ((newLock[i][j] == 0 && newKey[i][j] == 0) || (newLock[i][j] == 1 && newKey[i][j] == 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] turnClockwise(int[][] key) {
        int N = key.length;
        int[][] turnKey = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                turnKey[i][j] = key[N - j - 1][i];
            }
        }
        return turnKey;
    }
}
