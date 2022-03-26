import java.util.Stack;

public class ParenthesesConversion {
    public static void main(String[] args) {
        String p = "(()())()";
        System.out.println(solution(p));
    }

    static boolean correct(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    static String solution(String p) {
        String answer = "";
        if (p.equals(""))
            return p;

        String u = "";
        String v = "";
        int left = 0;
        int right = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1);
                break;
            }
        }
        if (correct(u)) {
            answer = u + solution(v);
        } else {
            answer += "(";
            answer += solution(v) + ")";
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    answer += ")";
                } else answer += "(";
            }
        }
        return answer;
    }
}
