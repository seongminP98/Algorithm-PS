import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedWorld4949 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack;
        while(true){
            stack = new Stack<Character>();
            boolean ans = true;
            String s = br.readLine();
            if(s.equals("."))
                break;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='('){
                    stack.push(s.charAt(i));
                }
                if(s.charAt(i)=='['){
                    stack.push(s.charAt(i));
                }
                if(s.charAt(i)==')'){
                    if(stack.empty()){
                        ans = false;
                        break;
                    }
                    if(stack.peek()=='('){
                        stack.pop();
                    } else{
                        ans = false;
                    }

                }
                if(s.charAt(i)==']'){
                    if(stack.empty()){
                        ans = false;
                        break;
                    }
                    if(stack.peek()=='['){
                        stack.pop();
                    } else{
                        ans = false;
                    }
                }
            }
            if(!stack.empty())
                ans = false;
            if(ans)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
