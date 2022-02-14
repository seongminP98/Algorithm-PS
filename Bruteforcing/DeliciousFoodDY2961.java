import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DeliciousFoodDY2961 {
    static int N;
    static Food[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Food[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        powerSetBit(N, 1, 0);
        System.out.println(answer);
    }

    static void powerSetBit(int depth, int s, int b) {
        if (depth == 0) {
            if (b == 0)
                return;
            answer = Math.min(answer, Math.abs(s - b));
            return;
        }

        powerSetBit(depth - 1, s * arr[depth - 1].S, b + arr[depth - 1].B);
        powerSetBit(depth - 1, s, b);
    }

    static class Food {
        int S, B;

        public Food(int s, int b) {
            S = s;
            B = b;
        }
    }
}
