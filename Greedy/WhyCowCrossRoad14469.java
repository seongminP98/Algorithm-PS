import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WhyCowCrossRoad14469 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Time[] arr = new Time[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);
        int answer = arr[0].arrive + arr[0].check;
        for (int i = 1; i < N; i++) {
            if (arr[i].arrive > answer) {
                answer = arr[i].arrive;
            }
            answer += arr[i].check;
        }
        System.out.println(answer);
    }

    static class Time implements Comparable<Time> {
        int arrive, check;

        public Time(int arrive, int check) {
            this.arrive = arrive;
            this.check = check;
        }

        public int compareTo(Time o) {
            return arrive - o.arrive;
        }
    }
}
