import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Guitarist1495 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] V = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[] vol = new int[M + 1];
        if (S + V[1] >= 0 && S + V[1] <= M)
            vol[S + V[1]] = 1;
        if (S - V[1] >= 0 && S - V[1] <= M)
            vol[S - V[1]] = 1;

        for (int i = 2; i <= N; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= M; j++) {
                if (vol[j] == (i - 1)) {
                    if (j - V[i] >= 0 && j - V[i] <= M) {
                        list.add(j - V[i]);
                    }
                    if (j + V[i] >= 0 && j + V[i] <= M) {
                        list.add(j + V[i]);
                    }
                }
            }
            for (Integer integer : list) { //바꿀 수 있는 곳 list에 저장하고 한번에 바꿔야함.
                vol[integer] = i;
            }
        }
        /*
        list 사용안했을 때 반례
        2 1 4
        1 2
         */
        int answer = -1;
        for (int i = 0; i <= M; i++) {
            if (vol[i] == N) {
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
