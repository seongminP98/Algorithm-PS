import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Repairman1449 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] p = new int[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(p);

        int tape = p[0]+L;
        int count=1;

        for(int i=1; i<N; i++){
            if(tape<=p[i]){
                tape = p[i]+L;
                count++;
            }
        }

        System.out.println(count);

    }
}
