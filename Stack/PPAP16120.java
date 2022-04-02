import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PPAP16120 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'P') {
                stack.push(c);
            } else {
                if (stack.size() < 2 || i == str.length() - 1) {
                    System.out.println("NP");
                    System.exit(0);
                }
                if (stack.pop() + stack.pop() == 160 && str.charAt(i + 1) == 'P') {
                    stack.push('P');
                    i++;
                } else {
                    System.out.println("NP");
                    System.exit(0);
                }
            }
        }

        System.out.println(stack.size() == 1 ? "PPAP" : "NP");
    }
}
