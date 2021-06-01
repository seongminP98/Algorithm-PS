import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SumOfSeq1024 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long L = Long.parseLong(st.nextToken());
        ArrayList<Long> list = new ArrayList<>();
        while(L<=100){
            long start = N/L - (L-1)/2;
            if(start<0){
                System.out.println(-1);
                System.exit(0);
            }
            long sum = 0;

            for(long i=start; i<start+L; i++){
                sum += i;
                list.add(i);
            }
            if(N==sum){
                break;
            }else{
                list.clear();
            }
            L++;

        }
        if(list.isEmpty())
            System.out.println(-1);
        else{
            for(long i : list){
                System.out.print(i+" ");
            }
        }
    }
}
