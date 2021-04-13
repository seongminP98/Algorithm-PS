import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RepeatSeq2331 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        ArrayList<Integer> al = new ArrayList<>();
        al.add(A);

        while(true){
            int n = 0;
            while(A!=0){
                n+=Math.pow(A%10,P);
                A/=10;
            }
            if(al.contains(n)){
                System.out.println(al.indexOf(n));
                break;
            }
            al.add(n);
            A = n;
        }
    }
}
