import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RepresentationOfSet1717 {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[] parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (check == 0) {
                unionParent(parent, a, b);
            } else {
                if (findParent(parent, a, b)) {
                    sb.append("YES");
                } else {
                    sb.append("NO");
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    static int getParent(int[] parent, int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static boolean findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a == b)
            return true;
        else
            return false;
    }
}
