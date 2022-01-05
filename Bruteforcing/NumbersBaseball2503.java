import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NumbersBaseball2503 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Baseball> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Baseball(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int answer = 0;
        for (int i = 123; i <= 987; i++) {
            if (!check(i))
                continue;
            boolean flag = true;

            for (int j = 0; j < N; j++) {
                String numY = Integer.toString(i);
                String numM = Integer.toString(list.get(j).num);
                int strike = 0;
                int ball = 0;

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (k == l && numM.charAt(k) == numY.charAt(l)) {
                            strike++;
                        }
                        if (k != l && numM.charAt(k) == numY.charAt(l)) {
                            ball++;
                        }
                    }
                }
                if (strike != list.get(j).strike || ball != list.get(j).ball) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
        }
        System.out.println(answer);

    }

    static boolean check(int num) {
        String strNum = Integer.toString(num);
        if (strNum.charAt(0) == strNum.charAt(1))
            return false;
        if (strNum.charAt(0) == strNum.charAt(2))
            return false;
        if (strNum.charAt(1) == strNum.charAt(2))
            return false;
        if (strNum.charAt(0) == '0' || strNum.charAt(1) == '0' || strNum.charAt(2) == '0')
            return false;

        return true;
    }

    static class Baseball {
        int num;
        int strike;
        int ball;

        public Baseball(int num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }
}
