import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Parcel8980 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        Info[] arr = new Info[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        for (Info info : arr) {
            System.out.println(info);
        }
        int[] capacity = new int[N + 1];
        int answer = 0;
        for (Info info : arr) {
            int max = 0;
            for (int i = info.send; i < info.receive; i++) {
                if (max < capacity[i]) {
                    max = capacity[i];
                }
            }
            if (max >= C) {
                continue;
            }
            int add = Math.min(info.num, C - max);
            answer += add;
            for (int i = info.send; i < info.receive; i++) {
                capacity[i] += add;
            }
        }
        System.out.println(answer);
    }

    private static class Info implements Comparable<Info> {
        int send, receive, num;

        public Info(int send, int receive, int num) {
            this.send = send;
            this.receive = receive;
            this.num = num;
        }

        @Override
        public int compareTo(Info o) {
            if (receive == o.receive) {
                return Integer.compare(send, o.send);
            }
            return Integer.compare(receive, o.receive);
        }
/*
        // 반례
        // 3 5 100
        // 1 4 100
        // 4 7 100
        @Override
        public int compareTo(Info o) {
            int diff1 = this.receive - this.send;
            int diff2 = o.receive - o.send;
            if (diff1 == diff2) {
                return Integer.compare(this.send, o.send);
            }
            return Integer.compare(diff1, diff2);
        }
*/

        @Override
        public String toString() {
            return "Info{" +
                    "send=" + send +
                    ", receive=" + receive +
                    ", num=" + num +
                    '}';
        }


    }
}
