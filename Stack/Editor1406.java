import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Editor1406 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(int i=0; i<str.length(); i++){
            stack1.push(str.charAt(i));
        }
        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            if(cmd == 'P'){
                stack1.push(st.nextToken().charAt(0));
            } else if(cmd == 'L'){
                if(!stack1.isEmpty())
                    stack2.push(stack1.pop());
            } else if(cmd == 'D'){
                if(!stack2.isEmpty())
                    stack1.push(stack2.pop());
            } else if(cmd == 'B'){
                if(!stack1.isEmpty())
                    stack1.pop();
            }
        }
        while(!stack1.isEmpty())
            stack2.push(stack1.pop());
        while(!stack2.isEmpty())
            bw.write(stack2.pop());
        bw.flush();
        bw.close();
    }
}
