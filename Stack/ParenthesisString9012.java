import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParenthesisString9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[n];

        for(int i=0; i<n; i++){
            if(check(br.readLine()))
                check[i]=true;

        }

        for(int i=0; i<n; i++){
            if(check[i])
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    static boolean check(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='(')
                stack.push('(');
            else if(stack.empty())
                return false;
            else
                stack.pop();
        }
        if(stack.empty())
            return true;
        else
            return false;
    }
}
