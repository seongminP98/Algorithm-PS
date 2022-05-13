import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuyPotion24954 {
    static int N;
    static int[] c;
    static List<List<Sale>> list = new ArrayList<>();
    static int answer = 10000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        c = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            list.add(new ArrayList<>());
        }
        list.add(new ArrayList<>());
        for (int i = 1; i <= N; i++) {
            int cnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < cnt; j++) {
                st = new StringTokenizer(br.readLine());
                list.get(i).add(new Sale(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
        }

        dfs(0, 0, new boolean[N + 1]);
        System.out.println(answer);

    }

    static void dfs(int depth, int sum, boolean[] visited) {
        if (depth == N) {
            if (sum < answer) answer = sum;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            int[] tmp = new int[N + 1];
            System.arraycopy(c, 1, tmp, 1, N);
            for (Sale sale : list.get(i)) {
                c[sale.potion] -= sale.coin;
                if (c[sale.potion] < 1) c[sale.potion] = 1;
            }
            dfs(depth + 1, sum + c[i], visited);
            visited[i] = false;
            System.arraycopy(tmp, 1, c, 1, N);

        }
    }

    static class Sale {
        int potion, coin;

        @Override
        public String toString() {
            return "Sale{" +
                    "potion=" + potion +
                    ", coin=" + coin +
                    '}';
        }

        public Sale(int potion, int coin) {
            this.potion = potion;
            this.coin = coin;
        }
    }
}
