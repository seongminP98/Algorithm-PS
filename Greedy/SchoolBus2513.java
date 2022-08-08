import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SchoolBus2513 {
    static int N, K, S;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        Apt[] arr = new Apt[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Apt(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr, (Comparator.comparingInt(o -> o.location)));
        List<Apt> left = new ArrayList<>();
        List<Apt> right = new ArrayList<>();

        for (Apt apt : arr) {
            if (apt.location < S) {
                left.add(apt);
            } else {
                break;
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i].location > S) {
                right.add(arr[i]);
            } else {
                break;
            }
        }
        solution(left);
        solution(right);
        System.out.println(answer);
    }

    private static void solution(List<Apt> list) {
        int seat = K;
        int idx = 0;
        while (true) {
            if (idx == list.size()) {
                break;
            }
            if (list.get(idx).num > seat) {
                list.get(idx).num -= seat;
                if (seat == K) {
                    answer += (Math.abs(S - list.get(idx).location)) * 2;
                }
                seat = K;
            } else if (list.get(idx).num == seat) {
                list.get(idx).num = 0;
                if (seat == K) {
                    answer += (Math.abs(S - list.get(idx).location)) * 2;
                }
                seat = K;
                idx++;
            } else {
                if (seat == K) {
                    answer += (Math.abs(S - list.get(idx).location)) * 2;
                }
                seat -= list.get(idx).num;
                list.get(idx).num = 0;
                idx++;
            }
        }
    }

    private static class Apt {
        int location, num;

        @Override
        public String toString() {
            return "Apt{" +
                    "location=" + location +
                    ", num=" + num +
                    '}';
        }

        public Apt(int location, int num) {
            this.location = location;
            this.num = num;
        }
    }
}
