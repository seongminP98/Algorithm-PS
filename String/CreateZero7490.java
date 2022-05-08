import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CreateZero7490 {
    static StringBuilder answer = new StringBuilder();
    static List<String> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            dfs(N, 1, new int[N]);
            Collections.sort(list);
            for (String s : list) {
                answer.append(s).append('\n');
            }
            answer.append('\n');
        }
        System.out.print(answer);
    }

    private static void dfs(int N, int depth, int[] insert) {
        if (depth == N) {
            cal(N, insert);
            return;
        }
        for (int i = 0; i < 3; i++) { // 0 1 2 -> + ' ' -
            insert[depth] = i;
            dfs(N, depth + 1, insert);
        }
    }

    private static void cal(int N, int[] insert) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            sb.append(i);
            if (insert[i] == 0) {
                sb.append("+");
            } else if (insert[i] == 2) {
                sb.append("-");
            } else {
                sb.append(" ");
            }
        }
        sb.append(N);

        int sum = 0;
        String[] splitP = sb.toString().split("\\+");
        for (String p : splitP) {
            String[] splitM = p.split("-");
            sum += Integer.parseInt(splitM[0].replaceAll(" ", ""));

            for (int i = 1; i < splitM.length; i++) {
                sum -= Integer.parseInt(splitM[i].replaceAll(" ", ""));
            }
        }
        if (sum == 0) {
            list.add(sb.toString());
        }
    }
}
