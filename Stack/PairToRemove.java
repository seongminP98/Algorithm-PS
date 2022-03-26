import java.util.Stack;

public class PairToRemove {
    public static void main(String[] args) {
        String s = "baabaa";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(-1);
        }
    }
}
