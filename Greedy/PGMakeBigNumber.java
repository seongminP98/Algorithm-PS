import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PGMakeBigNumber {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int k = Integer.parseInt(br.readLine());
        int len = number.length() - k;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            char next = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < next && k-- > 0) { //앞에서부터 작은수들을 k개 없애면 됨.
                stack.pop();
            }
            stack.push(next);
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < len; i++) { //number가 내림차순으로 되어있으면 스택에 다 들어감. 그래서 길이만큼 잘라줌.
            answer.append(stack.get(i));
        }
        System.out.println(answer.toString());

    }
}
