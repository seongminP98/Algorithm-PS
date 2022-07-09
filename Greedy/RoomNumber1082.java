import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RoomNumber1082 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] P = new int[N];
        int price = 50; // 제일 싼 번호의 가격
        int cheapAndBig = -1; // 제일 싼 번호(인덱스)
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            if (P[i] <= price) {
                price = P[i];
                cheapAndBig = i;
            }
        }
        int M = Integer.parseInt(br.readLine()); // 현재 가지고 있는 돈
        List<Integer> answer = new ArrayList<>();
        if (cheapAndBig == 0) {
            int tmpPrice = 50; // 제일 싼 번호가 0 일 때. 2번째로 싼 번호의 가격
            int idx = 0; // 2번쨰로 싼 번호
            for (int i = 1; i < N; i++) {
                if (P[i] <= tmpPrice) {
                    tmpPrice = P[i];
                    idx = i;
                }
            }
            answer.add(idx);
            M -= tmpPrice;
        }
        if (answer.size() > 0) {
            if (M < 0) {
                System.out.println(0);
                return;
            }
        }
        int cnt = M / price;
        while (cnt-- > 0) {
            answer.add(cheapAndBig);
        }
        M %= price;
        int sIdx = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            if (sIdx >= answer.size()) break;
            for (int i = N - 1; i > cheapAndBig; i--) { // 큰 숫자부터
                if (P[i] <= M + P[answer.get(sIdx)]) {
                    M = M + P[answer.get(sIdx)] - P[i];
                    answer.remove(sIdx);
                    answer.add(sIdx, i);
                    flag = true;
                    sIdx++;
                    break;
                }
            }
        }
        for (Integer integer : answer) {
            System.out.print(integer);
        }
    }
}
