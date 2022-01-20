import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Tower2493 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Tower> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            int h = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek().height > h) {
                    sb.append(stack.peek().index).append(" ");
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            }
            stack.push(new Tower(i, h));
        }
        System.out.print(sb);
    }

    static class Tower {
        int index, height;

        public Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}
