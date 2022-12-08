import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ManageTime6068 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Working[] workings = new Working[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            workings[i] = new Working(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(workings);

        int answer = workings[0].S;

        for (Working working : workings) {
            answer = Math.min(answer - working.T, working.S - working.T);
        }

        System.out.println(answer < 0 ? -1 : answer);
    }


    private static class Working implements Comparable<Working> {
        int T, S;

        public Working(int t, int s) {
            T = t;
            S = s;
        }

        @Override
        public int compareTo(Working o) {
            return Integer.compare(o.S, this.S);
        }
    }
}
