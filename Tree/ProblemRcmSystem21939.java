import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ProblemRcmSystem21939 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new TreeMap<>();
        TreeSet<Problem> set = new TreeSet<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            set.add(new Problem(P, L));
            map.put(P, L);
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                set.add(new Problem(P, L));
                map.put(P, L);

            } else if (cmd.equals("recommend")) {
                if (st.nextToken().equals("1")) {
                    Problem last = set.last();
                    sb.append(last.P).append('\n');

                } else {
                    Problem first = set.first();
                    sb.append(first.P).append('\n');
                }
            } else { // solved
                int p = Integer.parseInt(st.nextToken()); // 문제번호 p 제거
                int l = map.get(p);
                map.remove(p);
                set.remove(new Problem(p, l));
            }
        }
        System.out.print(sb);
    }

    static class Problem implements Comparable<Problem> {
        int P, L;

        public Problem(int p, int l) {
            P = p;
            L = l;
        }

        @Override
        public int compareTo(Problem o) { // 오름차순
            if (L == o.L) {
                return P - o.P;
            }
            return L - o.L;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Problem problem = (Problem) o;
            return P == problem.P &&
                    L == problem.L;
        }

        @Override
        public int hashCode() {
            return Objects.hash(P, L);
        }

        @Override
        public String toString() {
            return "Problem{" +
                    "P=" + P +
                    ", L=" + L +
                    '}';
        }
    }
}
