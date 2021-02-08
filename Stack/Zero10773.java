import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero10773 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<k; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n!=0){
                stack.push(n);
            }
            else if(n==0)
                stack.pop();

        }
        int sum=0;
        while(!stack.empty()){
            sum+=stack.pop();
        }
        System.out.println(sum);
    }
}
