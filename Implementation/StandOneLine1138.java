import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StandOneLine1138 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> ans = new ArrayList<>();

        for(int i=N-1; i>=0; i--) {
            ans.add(arr[i], i);
        }

        for (Integer an : ans) {
            System.out.print(an+1+" ");
        }
    }
}
