import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class FindCitySpecificStreet18352 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        List<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            list.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        StringBuilder sb = new StringBuilder();
        List<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        int dis = 0;
        visited[start] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            dis++;
            while (size-- > 0) {
                int c = q.poll();
                for (int next : list.get(c)) {
                    if (!visited[next]) {
                        if (dis == K) {
                            answer.add(next);
                        }
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
            if (dis == K)
                break;
        }

        Collections.sort(answer);
        if (answer.size() == 0) {
            System.out.println(-1);
        } else {
            for (Integer integer : answer) {
                sb.append(integer).append('\n');
            }
            System.out.print(sb);
        }
    }
}
