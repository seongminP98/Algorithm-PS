import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Ant3048 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());
        String g1 = br.readLine();
        String g2 = br.readLine();
        int T = Integer.parseInt(br.readLine());
        Set<Character> group1 = new HashSet<>();
        Set<Character> group2 = new HashSet<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < N1; i++) {
            group1.add(g1.charAt(i));
            list.add(g1.charAt(N1 - i - 1));
        }
        for (int i = 0; i < N2; i++) {
            group2.add(g2.charAt(i));
            list.add(g2.charAt(i));
        }

        for (int i = 0; i < T; i++) {
            boolean[] check = new boolean[list.size()];
            for (int j = 0; j < list.size() - 1; j++) {
                if (group1.contains(list.get(j)) && group2.contains(list.get(j + 1))) {
                    check[j] = true; //여기서 바꾸면 바뀐애가 또 바뀜.
                }
            }
            for (int j = 0; j < list.size() - 1; j++) {
                if (check[j]) {
                    Character temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (Character character : list) {
            sb.append(character);
        }
        System.out.println(sb);

    }
}
