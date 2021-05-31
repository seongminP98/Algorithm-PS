import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackSeq1874 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int idx = 0;
        int num = 1;
        while(true){
            if(!stack.isEmpty() && stack.peek()==arr[idx]){
                stack.pop();
                idx++;
                sb.append('-').append('\n');
                if(idx>=n)
                    break;
            } else{
                if(num<=n){
                    stack.push(num);
                    num++;
                    sb.append('+').append('\n');
                }
            }
            if(num>n){
                if(!stack.isEmpty() && stack.peek()!=arr[idx])
                    break;
            }
        }
        if(!stack.isEmpty())
            System.out.println("NO");
        else
            System.out.println(sb);
    }
}
