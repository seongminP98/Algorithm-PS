import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LANCutting1654 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] LAN = new int[K];
        for(int i=0; i<K; i++){
            LAN[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(LAN);
        long max = LAN[K-1];
        long min = 1;
        long middle=0;
        while(max>=min){
            middle = (max+min)/2;
            long count=0;
            for(int i=0; i<K; i++){
                count += LAN[i]/middle;
            }
            if(count>=N)    //더 많은 랜선이 나오면 더 크게 잘라줘야 함. N개보다 많은 랜선만드는 것도 가능.
                min = middle+1;
            else
                max = middle-1;
        }
        System.out.println(max);
    }
}
