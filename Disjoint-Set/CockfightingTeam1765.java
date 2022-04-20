import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CockfightingTeam1765 {
    static int N, M;
    static List<ArrayList<Integer>> friendList;
    static List<ArrayList<Integer>> enemyList;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        friendList = new ArrayList<>();
        enemyList = new ArrayList<>();
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
            friendList.add(new ArrayList<>());
            enemyList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if (type.equals("F")) {
                friendList.get(n1).add(n2);
                friendList.get(n2).add(n1);
            } else {
                enemyList.get(n1).add(n2);
                enemyList.get(n2).add(n1);
            }
        }


        for (ArrayList<Integer> integers : enemyList) {
            if (integers.size() >= 2) {
                int c = integers.get(0);
                for (int i = 1; i < integers.size(); i++) {
                    friendList.get(c).add(integers.get(i));
                    friendList.get(integers.get(i)).add(c);
                }
            }
        }

        for (int i = 1; i < friendList.size(); i++) {
            for (Integer friend : friendList.get(i)) {
                union(friend, i);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(parent[i]);
        }

        System.out.println(set.size());
    }

    static int findParent(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = findParent(parent[x]);
    }

    static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        if (x != y) {
            if (x < y) parent[y] = x;
            else parent[x] = y;
        }
    }
}
