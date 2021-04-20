import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeCut2805 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);
        long min = 1;
        long max = tree[N-1];

        long middle = 0;
        while(max>=min){
            long sum = 0;
            middle = (max+min)/2;
            for(int i=0; i<N; i++){
                if(tree[i]>middle)
                    sum+=tree[i]-middle;
            }
            if(sum==M){
                max = middle;
                break;
            }
            else if(sum>M){
                min = middle+1;
            }
            else
                max = middle-1;
        }
        System.out.println(max);
    }
}
