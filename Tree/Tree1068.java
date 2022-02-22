import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Tree1068 {
    static Set<Integer> set;
    static int N;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        set = new HashSet<>();
        int root = 0;
        for (int i = 0; i < N; i++) {
            set.add(i);
        }
        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if (parent[i] == -1) root = i;
            set.remove(parent[i]);
        }
        int delete = Integer.parseInt(br.readLine());
        dfs(delete);

        //삭제할 노드를 자르면 부모가 리프노드가 되는경우.
        int delParent = parent[delete];
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (parent[i] == delParent) {
                count++;
            }
        }
        int answer = set.size();
        if (count == 1 && delete != root) { //루트노드를 자르면 0이됨.
            answer++;
        }
        System.out.println(answer);
    }

    static void dfs(int x) {
        set.remove(x);
        for (int i = 0; i < N; i++) {
            if (parent[i] == x) {
                dfs(i);
            }
        }
    }
}
