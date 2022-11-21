import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ShuffleCards1091 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] shuffle = new int[N];
        int[] cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder goal = new StringBuilder();
        for (int i = 0; i < N; i++) {
            goal.append(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            shuffle[Integer.parseInt(st.nextToken())] = i;
            cards[i] = i % 3;
        }

        Set<String> check = new HashSet<>();
        int answer = 0;
        while (true) {
            StringBuilder card = new StringBuilder();
            for (int i : cards) {
                card.append(i);
            }
            if (card.toString().equals(goal.toString())) {
                break;
            }
            if (!check.add(card.toString())) {
                System.out.println(-1);
                return;
            }
            answer++;
            int[] temp = new int[N];
            System.arraycopy(cards, 0, temp, 0, N);
            for (int i = 0; i < N; i++) {
                cards[shuffle[i]] = temp[i];
            }
        }
        System.out.println(answer);
    }
}