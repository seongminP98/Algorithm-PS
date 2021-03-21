import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class CardSorting1715 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            pq.add(Long.parseLong(br.readLine()));
        }
        int result = 0;
        while(!pq.isEmpty()){
            long sum = 0;
            sum+=pq.poll();
            if(!pq.isEmpty()){
                sum+=pq.poll();
                pq.add(sum);
                result+=sum;
            }
        }
        System.out.println(result);
    }
}
