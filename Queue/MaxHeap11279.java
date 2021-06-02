import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap11279 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            if(n==0){
                if(pq.isEmpty())
                    sb.append(0).append('\n');
                else{
                    sb.append(pq.poll()).append('\n');
                }
            } else{
                pq.offer(n);
            }
        }
        System.out.print(sb);
    }
}