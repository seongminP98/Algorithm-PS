import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PlaceCard5568 {
    static int N, K;
    static String[] card;
    static Set<String> set = new HashSet<>();
    static boolean[] visited;
    static String[] input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        card = new String[N];
        input = new String[K];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            card[i] = br.readLine();
        }
        permutation(0);
        System.out.println(set.size());
    }

    static void permutation(int depth) {
        if (depth == K) {
            StringBuilder s = new StringBuilder();
            for (String s1 : input) {
                s.append(s1);
            }
            set.add(s.toString());
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                input[depth] = card[i];
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}
