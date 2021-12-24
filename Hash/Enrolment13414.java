import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Enrolment13414 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for(int i=0; i<L; i++) {
            String next = br.readLine();
            set.remove(next);
            set.add(next);
        }
        int i=0;
        for (String s : set) {
            if(i<K) {
                System.out.println(s);
                i++;
            }
        }
    }
}
