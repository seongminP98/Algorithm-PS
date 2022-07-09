import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeRecovery6597 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(s);
            String preorder = st.nextToken();
            String inorder = st.nextToken();
            int len = preorder.length();
            int[] pre = new int[len + 1];
            int[] in = new int[len];
            int[] idx = new int[len]; // inorder 값의 인덱스
            for (int i = 0; i < len; i++) {
                pre[i] = preorder.charAt(i) - 'A';
                in[i] = inorder.charAt(i) - 'A';
                idx[in[i]] = i;
            }
            solution(0, 0, len, pre, idx);
            sb.append('\n');

        }
        System.out.print(sb);
    }

    private static void solution(int idx, int left, int right, int[] pre, int[] inIdx) {
        if (left >= right) return;
        int root = pre[idx];
        int rootIdx = inIdx[root];

        solution(idx + 1, left, rootIdx, pre, inIdx); // 왼쪽 서브트리
        solution(idx + 1 + (rootIdx - left), rootIdx + 1, right, pre, inIdx); // 오른쪽 서브트리
        sb.append((char) (root + 'A'));
    }
}
