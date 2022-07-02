import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class showMeTheDungeon {
    static int N, K;
    static City[] arr;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new City[N];
        StringTokenizer attack = new StringTokenizer(br.readLine());
        StringTokenizer people = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = new City(Integer.parseInt(attack.nextToken()), Integer.parseInt(people.nextToken()));
        }

        Arrays.sort(arr);

        dfs(0, 0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int depth, int attack, int people, int before) {
        if (depth == N) {
            if (answer < people) {
                answer = people;
            }
            return;
        }
        if (attack + arr[depth].A + before <= K) {
            dfs(depth + 1, attack + arr[depth].A + before, people + arr[depth].P, before+arr[depth].A);
        }
        if (attack <= K) {
            dfs(depth + 1, attack, people, before);
        }
    }

    private static class City implements Comparable<City>{
        int A, P;

        @Override
        public String toString() {
            return "City{" +
                    "A=" + A +
                    ", P=" + P +
                    '}';
        }

        public City(int a, int p) {
            A = a;
            P = p;
        }

        @Override
        public int compareTo(City o) {
            return Integer.compare(this.A, o.A);
        }
    }
}
