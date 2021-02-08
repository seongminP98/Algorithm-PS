import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CardUnion15903 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long[] card = new long[(int) n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            card[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(card);

        for(int i=0; i<m; i++){
            long union = card[0]+card[1];
            card[0] = union;
            card[1] = union;
            Arrays.sort(card);
        }
        long sum = 0;
        for(int i=0; i<n; i++){
            sum += card[i];
        }
        br.close();
        System.out.println(sum);
    }
}
