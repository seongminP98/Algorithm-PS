import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Queue10845 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> queue = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch(s){
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    if(queue.size()==0)
                        System.out.println(-1);
                    else{
                        System.out.println(queue.get(0));
                        queue.remove(0);
                    }
                    break;

                case "size":
                    System.out.println(queue.size());
                    break;

                case "empty" :
                    if(queue.size()==0)
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;

                case "front":
                    if(queue.size()==0)
                        System.out.println(-1);
                    else
                        System.out.println(queue.get(0));
                    break;
                case "back":
                    if(queue.size()==0)
                        System.out.println(-1);
                    else
                        System.out.println(queue.get(queue.size()-1));
                    break;

                default:
                    break;
            }

        }
    }
}
