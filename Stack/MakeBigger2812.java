import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class MakeBigger2812 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String num = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (!stack.isEmpty()) {
                if (K != 0) {
                    while (!stack.isEmpty() && stack.peek() < num.charAt(i) && K-- > 0) {
                        stack.pop();
                    }
                }
            }
            stack.push(num.charAt(i));
        }
        while (K-- > 0) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        System.out.print(sb);
    }
}
