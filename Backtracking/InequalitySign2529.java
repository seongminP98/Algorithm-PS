import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class InequalitySign2529 {
    static int K;
    static char[] arr;
    static List<String> answer = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        arr = new char[K];
        visited = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        dfs("", 0);
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.get(answer.size()-1)).append('\n').append(answer.get(0));
        System.out.println(sb);

    }

    static void dfs(String num, int depth) {
        if (depth == K + 1) { //숫자는 K보다 1많음.
            answer.add(num);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (visited[i])
                continue;
            if (depth == 0 || !visited[i] && check(num.charAt(num.length() - 1) - '0', i, arr[depth - 1])) {
                visited[i] = true;
                dfs(num + i, depth + 1);
                visited[i] = false;
            }
        }
    }

    static boolean check(int a, int b, char c) {
        if (c == '<')
            return a < b;
        else
            return a > b;
    }
}
