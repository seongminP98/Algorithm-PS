import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CutString2866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        List<StringBuilder> list = new ArrayList<>(C);
        for (int i = 0; i < C; i++) {
            list.add(new StringBuilder());
        }
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                list.get(j).append(s.charAt(j));
            }
        }
        int count = 0;
        loop:
        for (int i = 0; i < R - 1; i++) {
            Set<String> set = new HashSet<>();
            for (StringBuilder str : list) {
                str.deleteCharAt(0);
            }
            for (StringBuilder str : list) {
                if (!set.add(str.toString())) {
                    break loop;
                }
            }

            count++;
        }
        System.out.println(count);
    }
}
