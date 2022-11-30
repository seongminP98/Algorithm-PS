import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PostOffice2285 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Town[] towns = new Town[N];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            towns[i] = new Town(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            sum += towns[i].a;
        }
        Arrays.sort(towns);

        long temp = 0;
        for (Town town : towns) {
            temp += town.a;
            if (temp >= (sum + 1) / 2) {
                System.out.println(town.x);
                return;
            }
        }


    }

    private static class Town implements Comparable<Town> {
        long x, a;

        public Town(long x, long a) {
            this.x = x;
            this.a = a;
        }

        @Override
        public int compareTo(Town o) {
            return Long.compare(this.x, o.x);
        }
    }
}
