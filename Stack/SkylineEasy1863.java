import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SkylineEasy1863 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int y = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek() > y) {
                answer++;
                stack.pop();
            }
            if (!stack.empty() && stack.peek() == y)
                continue;
            stack.push(y);
        }
        while (!stack.isEmpty()) {
            if (stack.pop() > 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
