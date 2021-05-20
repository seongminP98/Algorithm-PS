import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StringExplosion9935 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            stack.push(str.charAt(i));
            if(stack.size()>=bomb.length()){
                boolean check = true;
                for(int j=0; j<bomb.length(); j++){
                    if(stack.get(stack.size()-bomb.length()+j) != bomb.charAt(j)){
                        check = false;
                        break;
                    }
                }
                if(check){
                    for(int j=0; j<bomb.length(); j++){
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        if(stack.isEmpty()){
            ans.append("FRULA");
        } else{
            for(char c : stack)
                ans.append(c);
        }
        System.out.println(ans);
    }
}
