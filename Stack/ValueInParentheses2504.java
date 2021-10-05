import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ValueInParentheses2504 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<String> stack = new Stack<>();
        boolean check = true;
        int sum = 0;

        loop :for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(' || s.charAt(i)=='[') {
                stack.push(s.substring(i,i+1));
            }
            else {
                int num = 0;
                while(true) {
                    if(stack.isEmpty()) {
                        check = false;
                        break loop;
                    }
                    if(!stack.peek().equals("(") && !stack.peek().equals("[")) { //숫자
                        num += Integer.parseInt(stack.pop());
                    } else {
                        if(s.charAt(i) == ')' && stack.peek().equals("(")) {
                            stack.pop();
                            if(num == 0) {
                                stack.push("2");
                            } else {
                                int tmp = num*2;
                                stack.push(String.valueOf(tmp));
                            }
                            break;
                        } else if(s.charAt(i) == ']' && stack.peek().equals("[")) {
                            stack.pop();
                            if(num == 0) {
                                stack.push("3");
                            } else {
                                int tmp = num*3;
                                stack.push(String.valueOf(tmp));
                            }
                            break;
                        } else {
                            check = false;
                            break loop;
                        }
                    }
                }
            }
        }

        if(!check) {
            System.out.println(0);
            System.exit(0);
        } else {
            while(!stack.isEmpty()) {
                if(!stack.peek().equals("(") && !stack.peek().equals("["))
                    sum += Integer.parseInt(stack.pop());
                else{
                    System.out.println(0);
                    System.exit(0);
                }
            }
            System.out.println(sum);
        }

    }
}
