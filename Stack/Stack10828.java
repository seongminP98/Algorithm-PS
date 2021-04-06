import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Stack10828 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> stack = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch(s){
                case "push":
                    stack.add(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    if(stack.size()==0)
                        System.out.println(-1);
                    else{
                        System.out.println(stack.get(stack.size()-1));
                        stack.remove(stack.size()-1);
                    }
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty" :
                    if(stack.size()==0)
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;

                case "top":
                    if(stack.size()==0)
                        System.out.println(-1);
                    else
                        System.out.println(stack.get(stack.size()-1));
                    break;

                default:
                    break;
            }

        }
    }
}
