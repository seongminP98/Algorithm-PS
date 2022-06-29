import java.util.Arrays;

public class ArcheryCompetition {
    static int[] answer = new int[11];
    static int max = 0;
    static boolean check = false;

    public static void main(String[] args) {
        int n = 5;
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(solution(n, info)));
    }

    private static int[] solution(int n, int[] info) {
        dfs(0, 0, n, new int[11], info);
        System.out.println("max = " + max);
        if (!check) return new int[]{-1};
        return answer;
    }

    private static void dfs(int depth, int idx, int n, int[] ryan, int[] apeach) {
//        System.out.println(Arrays.toString(ryan) + " depth : " + depth + " idx : " + idx);
        if (idx >= 11) return;
        if (depth == n || idx == 10) {
            int tmp = ryan[10];
            if (idx == 10) {
                ryan[10] = n - depth;
            }
            int RScore = 0;
            int AScore = 0;
            for (int i = 0; i < 11; i++) {
                if (ryan[i] == 0 && apeach[i] == 0) continue;
                if (ryan[i] <= apeach[i]) {
                    AScore += 10 - i;
                } else {
                    RScore += 10 - i;
                }
            }
            if (RScore - AScore > max) {
                check = true;
                System.arraycopy(ryan, 0, answer, 0, 11);
                max = RScore - AScore;
            } else if (RScore - AScore == max) {
                for (int i = 10; i >= 0; i--) {
                    if (answer[i] < ryan[i]) {
                        System.arraycopy(ryan, 0, answer, 0, 11);
                        break;
                    }
                    if (answer[i] > ryan[i]) break;
                }
            }
            ryan[10] = tmp;
            return;
        }

        // 라이언이 이길 때
        if (apeach[idx] + 1 <= n - depth) {
            ryan[idx] = apeach[idx] + 1;
            dfs(depth + apeach[idx] + 1, idx + 1, n, ryan, apeach);
            ryan[idx] = 0;
        }
        // 라이언이 안맞출 때
        dfs(depth, idx + 1, n, ryan, apeach);

    }
}
