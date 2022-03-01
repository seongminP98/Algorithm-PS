import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lie1043 {
    static int N, M;
    static int[] truth;
    static int[] parent;
    static List<ArrayList<Integer>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람의 수
        M = Integer.parseInt(st.nextToken()); // 파티의 수
        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken());
        truth = new int[truthNum];
        for (int i = 0; i < truthNum; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            list.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
            if (num > 1) {
                for (int j = 1; j < list.get(i).size(); j++) {
                    if (!isSameParent(list.get(i).get(j - 1), list.get(i).get(j))) {
                        union(list.get(i).get(j - 1), list.get(i).get(j));
                    }
                }
            }

        }
        int answer = M;
        for (ArrayList<Integer> party : list) {
            loop:
            for (Integer p : party) {
                for (int t : truth) {
                    if (isSameParent(p, t)) {
                        answer--;
                        break loop;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    static boolean isSameParent(int x, int y) {
        return findParent(x) == findParent(y);
    }

    static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        if (x != y) {
            parent[y] = x;
        }
    }
}
