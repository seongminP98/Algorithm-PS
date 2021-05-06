import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Subtotal1806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = Integer.MAX_VALUE;
        boolean check = false;
        for (int i = 0; i < N; i++) {
            long sum = 0;
            for (int j = i; j < N; j++) {
                sum += arr[j];
                if (sum >= S) {
                    count = Math.min(count, j-i+1);
                    check = true;
                    //System.out.println("i:"+i+"j:"+j);
                    break;
                }
            }
        }
        if(check)
            System.out.println(count);
        else
            System.out.println(0);
    }
}
