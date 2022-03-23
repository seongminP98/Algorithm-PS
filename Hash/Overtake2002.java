import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Overtake2002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(br.readLine(), i);
        }
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            int num = map.get(br.readLine());
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
                answer++;
            }
            stack.push(num);
        }
        System.out.println(answer);
    }
}
