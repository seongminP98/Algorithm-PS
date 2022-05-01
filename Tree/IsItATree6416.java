import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class IsItATree6416 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = 0;
        loop:
        while (true) { // test
            Set<Integer> node = new HashSet<>(); // 전체 노드 개수 구하기 위해 사용
            Set<Integer> inDegree = new HashSet<>(); // in-degree 는 반드시 1개
            boolean answer = true;
            st = new StringTokenizer(br.readLine());
            while (true) {
                if (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                int out = Integer.parseInt(st.nextToken());
                int in = Integer.parseInt(st.nextToken());
                if (out == 0) {
                    break;
                }
                if (out == -1) {
                    break loop;
                }
                node.add(out);
                node.add(in);
                if (!inDegree.add(in)) { // 들어오는 간선이 2개 이상이면 트리 아님.
                    answer = false;
                }
            }

            if (node.size() == 0 && inDegree.size() == 0) { // 노드가 없으면 트리...
                answer = true;
            } else if (node.size() != (inDegree.size() + 1)) { // 루트 하나.
                answer = false;
            }
            sb.append("Case ").append(++t).append(" is ");
            if (answer) {
                sb.append("a tree.");
            } else {
                sb.append("not a tree.");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
