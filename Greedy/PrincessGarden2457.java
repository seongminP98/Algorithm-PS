import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrincessGarden2457 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String sm = st.nextToken();
            String sd = st.nextToken();
            int start;
            if (sd.length() == 1) {
                start = Integer.parseInt(sm + "0" + sd);
            } else {
                start = Integer.parseInt(sm + sd);
            }
            int end;
            String em = st.nextToken();
            String ed = st.nextToken();
            if (ed.length() == 1) {
                end = Integer.parseInt(em + "0" + ed);
            } else {
                end = Integer.parseInt(em + ed);
            }
            flowers[i] = new Flower(start, end);
        }
        Arrays.sort(flowers);
        int max = 0;
        int answer = 0;
        int start = 301;
        int idx = 0;
        while (start < 1201) {
            boolean flag = false;
            for (int i = idx; i < N; i++) {
                if (flowers[i].start > start) break; // 연속적으로 피지 못하면 break
                if (max < flowers[i].end) { // 더 오래 필 수 있는 꽃 찾기
                    max = flowers[i].end;
                    idx = i + 1;
                    flag = true;
                }
            }
            if (flag) {
                start = max;
                answer++;
            } else {
                break;
            }
        }
        System.out.println(max < 1201 ? 0 : answer);
    }

    private static class Flower implements Comparable<Flower> {
        int start, end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            if (this.start == o.start) {
                return Integer.compare(o.end, this.end); // 지는 시간 내림차순
            }
            return Integer.compare(this.start, o.start); // 피는 시간 오름차순
        }
    }
}
