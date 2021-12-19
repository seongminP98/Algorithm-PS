import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Difference1822 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<nA; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<nB; i++) {
            int n = Integer.parseInt(st.nextToken());
            set.remove(n);
        }
        List<Integer> answer = new ArrayList<>(set);
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        if(set.size()>0) {
            System.out.println(set.size());
            for (Integer integer : answer) {
                sb.append(integer).append(" ");
            }
            System.out.println(sb);
        } else {
            System.out.println(0);
        }
    }
}
