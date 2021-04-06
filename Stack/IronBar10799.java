import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class IronBar10799 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        boolean check = false;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
                check = true;
            }
            if(s.charAt(i)==')'){
                stack.pop();
                if(check) //짤랐을 때.
                    result+=stack.size();
                else //막대기가 끝났을 때.
                    result+=1;
                check=false;
            }
        }
        System.out.print(result);
    }
}
