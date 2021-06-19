import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostFix1935 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        double[] arr = new double[n];
        for(int i=0; i<n; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }
        Stack<Double> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != '*' && s.charAt(i) != '/' && s.charAt(i) != '+' && s.charAt(i) != '-'){
                stack.push(arr[s.charAt(i)-65]);
            } else{
                if(s.charAt(i) == '*'){
                    double a = stack.pop();
                    double b = stack.pop();
                    double next = b*a;
                    stack.push(next);
                }else if(s.charAt(i) == '/'){
                    double a = stack.pop();
                    double b = stack.pop();
                    double next = b/a;
                    stack.push(next);
                }else if(s.charAt(i) == '+'){
                    double a = stack.pop();
                    double b = stack.pop();
                    double next = b+a;
                    stack.push(next);
                }else if(s.charAt(i) == '-'){
                    double a = stack.pop();
                    double b = stack.pop();
                    double next = b-a;
                    stack.push(next);
                }
            }
        }
        System.out.print(String.format("%.2f",stack.pop()));
    }
}
