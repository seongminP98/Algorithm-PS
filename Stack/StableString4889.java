import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StableString4889 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while(true){
            String s = br.readLine();
            if(s.charAt(0)=='-')
                break;

            Stack<Character> stack = new Stack<>();
            int count = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='{'){
                    stack.push('{');
                } else{
                    if(stack.isEmpty()){
                        count++;
                        stack.push('{');
                    } else{
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty()){
                count += stack.size()/2;
            }
            sb.append(t).append(". ").append(count).append('\n');
            t++;
        }
        System.out.println(sb);
    }
}
