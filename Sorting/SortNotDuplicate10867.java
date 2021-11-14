import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SortNotDuplicate10867 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);

    }
}
