import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2456 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Score[] score = new Score[3];

        for (int i = 0; i < 3; i++) {
            score[i] = new Score(i + 1, 0, 0, 0, 0);
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());
            if (first == 1) {
                score[0].one++;
                score[0].sum += 1;
            } else if (first == 2) {
                score[0].two++;
                score[0].sum += 2;
            } else {
                score[0].three++;
                score[0].sum += 3;
            }

            if (second == 1) {
                score[1].one++;
                score[1].sum += 1;
            } else if (second == 2) {
                score[1].two++;
                score[1].sum += 2;
            } else {
                score[1].three++;
                score[1].sum += 3;
            }

            if (third == 1) {
                score[2].one++;
                score[2].sum += 1;
            } else if (third == 2) {
                score[2].two++;
                score[2].sum += 2;
            } else {
                score[2].three++;
                score[2].sum += 3;
            }
        }
        Arrays.sort(score, (o1, o2) -> {
            return o1.sum == o2.sum ? o1.three == o2.three ? o1.two == o2.two ? 0 : o2.two - o1.two : o2.three - o1.three : o2.sum - o1.sum;
        });

        if (score[0].sum == score[1].sum && score[0].three == score[1].three && score[0].two == score[1].two) {
            System.out.println(0 + " " + score[0].sum);
        } else {
            System.out.println(score[0].number + " " + score[0].sum);
        }

    }

    static class Score {
        int number, one, two, three, sum;

        public Score(int number, int one, int two, int three, int sum) {
            this.number = number;
            this.one = one;
            this.two = two;
            this.three = three;
            this.sum = sum;
        }

    }
}
