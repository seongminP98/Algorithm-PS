import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class PickNumber2668 {
    static int N;
    static int[] arr;
    static Set<Integer> answerSet = new TreeSet<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i < N + 1; i++) {
            List<Integer> list = new ArrayList<>();
            visited = new boolean[N + 1];
            dfs(i, i, 1, list);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answerSet.size()).append('\n');
        for (Integer integer : answerSet) {
            sb.append(integer).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int start, int value, int num, List<Integer> list) {
        if (arr[value] == start) {
            list.add(arr[value]);
            answerSet.addAll(list);
            return;
        }
        if (visited[value]) {
            return;
        }
        visited[value] = true;
        list.add(arr[value]);
        dfs(start, arr[value], num + 1, list);
    }
}
