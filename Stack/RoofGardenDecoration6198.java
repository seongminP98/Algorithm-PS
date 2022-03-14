import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class RoofGardenDecoration6198 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }
            answer += stack.size();
            stack.push(height);
        }
        System.out.println(answer);
    }
}
