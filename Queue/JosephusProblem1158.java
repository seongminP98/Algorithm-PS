import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JosephusProblem1158 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String ans = "<";
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<N+1; i++){
            queue.add(i);
        }
        while(!queue.isEmpty()){
            if(queue.size()==1){
                ans+=queue.poll()+">";
            }
            else{
                for(int i=1; i<K; i++){
                    queue.add(queue.poll());
                }
                ans+=queue.poll()+", ";
            }
        }
        System.out.print(ans);
    }
}
