import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class StraightSwitchGame20209 {
    static int N, K;
    static int[] cube;
    static List<Set<Integer>> con;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cube = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cube[i] = Integer.parseInt(st.nextToken()); // 각 큐브의 번호
        }
        con = new ArrayList<>();
        for (int i = 0; i <= K; i++) {
            con.add(new HashSet<>());
        }
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                con.get(i).add(Integer.parseInt(st.nextToken())); // 스위치에 연결된 큐브
            }
        }
        solve(1, new int[K + 1]);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }
   
    static void solve(int depth, int[] count) { // depth = 스위치 번호
        if (depth == K + 1) {
            for (int i = 1; i < N; i++) {
                if (cube[i] != cube[i + 1]) {
                    return;
                }
            }
            int sum = 0;
            for (int i = 1; i <= K; i++) {
                sum += count[i];
            }
            if (sum < answer) answer = sum;
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                count[depth] = 0;
                solve(depth + 1, count);
            } else {
                for (Integer num : con.get(depth)) {
                    cube[num] += depth * i;
                    cube[num] %= 5;
                }
                count[depth] = i;
                solve(depth + 1, count);
                for (Integer num : con.get(depth)) {
                    cube[num] += depth * (5 - i);
                    cube[num] %= 5;
                }
            }
        }
    }
}
