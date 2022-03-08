import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Dice1041 {
    static int N;
    static Dice[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Dice[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = new Dice(i, Integer.parseInt(st.nextToken()));
        }
        long two = 8 * N - 12;
        long one = (long) (Math.pow((N - 2), 2) + 4 * (Math.pow(N - 2, 2) + (N - 2)));
        Arrays.sort(arr);

        if (N == 1) {
            int oneSum = 0;
            for (int i = 0; i < 5; i++) {
                oneSum += arr[i].num;
            }
            System.out.println(oneSum);
            System.exit(0);
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);
        if (5 - arr[0].pos == arr[1].pos) {
            list.add(2);
        } else {
            list.add(1);
        }
        int next = list.get(1) + 1;
        if (5 - arr[list.get(0)].pos == arr[next].pos || 5 - arr[list.get(1)].pos == arr[next].pos) {
//            System.out.println("여기");
            if (5 - arr[list.get(0)].pos == arr[next + 1].pos || 5 - arr[list.get(1)].pos == arr[next + 1].pos) {
                list.add(next + 2);
            } else {
                list.add(next + 1);
            }
        } else {
            list.add(next);
        }
//        for (Dice dice : arr) {
//            System.out.println(dice);
//        }
//        for (Integer integer : list) {
//            System.out.println(integer);
//        }
        int sumTwo = arr[list.get(0)].num + arr[list.get(1)].num;
        int sumThree = sumTwo + arr[list.get(2)].num;
        long sum = arr[list.get(0)].num * one + sumTwo * two + sumThree * 4;
        System.out.println(sum);


    }

    static class Dice implements Comparable<Dice> {
        int pos, num;

        public Dice(int pos, int num) {
            this.pos = pos;
            this.num = num;
        }

        @Override
        public int compareTo(Dice o) {
            return num - o.num;
        }

        @Override
        public String toString() {
            return "Dice{" +
                    "pos=" + pos +
                    ", num=" + num +
                    '}';
        }
    }
}
