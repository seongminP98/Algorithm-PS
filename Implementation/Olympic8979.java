import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Olympic8979 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Medal[] arr = new Medal[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arr[num - 1] = new Medal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int gold = arr[K - 1].gold;
        int silver = arr[K - 1].silver;
        int bronze = arr[K - 1].bronze;

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            if (arr[i].gold == gold && arr[i].silver == silver && arr[i].bronze == bronze) {
                System.out.println(i + 1);
                System.exit(0);
            }
        }

    }

    static class Medal implements Comparable<Medal> {
        int gold, silver, bronze;

        public Medal(int gold, int silver, int bronze) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
/*
        @Override
        public String toString() {
            return "Medal{" +
                    "gold=" + gold +
                    ", silver=" + silver +
                    ", bronze=" + bronze +
                    '}';
        }
*/

        @Override
        public int compareTo(Medal o) {
            if (o.gold > this.gold) {
                return 1;
            } else if (o.gold == this.gold) {
                if (o.silver > this.silver) {
                    return 1;
                } else if (o.silver == this.silver) {
                    if (o.bronze > this.bronze) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }
}
