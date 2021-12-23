import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SymmetricDifference1269 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        int intersection = 0;
        for(int i=0; i<A; i++) {
            int n = Integer.parseInt(st.nextToken());

            if(set.contains(n)) {
                intersection++;
            } else {
                set.add(n);
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<B; i++) {
            int n = Integer.parseInt(st.nextToken());

            if(set.contains(n)) {
                intersection++;
            } else {
                set.add(n);
            }
        }

        System.out.println(set.size()-intersection);

    }
}
