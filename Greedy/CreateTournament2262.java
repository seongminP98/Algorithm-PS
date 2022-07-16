import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class CreateTournament2262 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int answer = 0;
        while (list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == N) {
                    if (i == 0) {
                        answer += list.get(i) - list.get(i + 1);
                    } else if (i == list.size() - 1) {
                        answer += list.get(i) - list.get(i - 1);
                    } else {
                        answer += list.get(i) - Math.max(list.get(i - 1), list.get(i + 1));
                    }
                    list.remove(i);
                    N--;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
