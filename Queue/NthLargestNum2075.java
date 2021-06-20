import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NthLargestNum2075 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<Node2075> pq = new PriorityQueue<>(new Comparator<Node2075>() {
            @Override
            public int compare(Node2075 o1, Node2075 o2) {
                return o2.value-o1.value;
            }
        });
        for(int i=0; i<N; i++){
            pq.offer(new Node2075(N-1,i,arr[N-1][i]));
        }

        int count = 0;

        while(count<N){
            assert pq.peek() != null;
            int x = pq.peek().x;
            int y = pq.peek().y;
            int value = pq.peek().value;
            pq.poll();
            count++;
            if(count==N){
                System.out.print(value);
                break;
            }
            pq.offer(new Node2075(x-1,y,arr[x-1][y]));
        }

    }
}
class Node2075{
    int x,y,value;
    Node2075(int x, int y, int value){
        this.x=x;
        this.y=y;
        this.value = value;
    }
}
