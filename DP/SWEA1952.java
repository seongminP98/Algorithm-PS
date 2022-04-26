import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1952 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            Fee fee = new Fee(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            int[] plan = new int[13];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < 13; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }
            int[] ratePlan = new int[13]; // 최소금액 저장

            for (int i = 1; i <= 12; i++) {
                ratePlan[i] = Math.min(ratePlan[i - 1] + fee.month, ratePlan[i - 1] + fee.day * plan[i]);
                if (i >= 3) ratePlan[i] = Math.min(ratePlan[i], ratePlan[i - 3] + fee.tMonth); // 3개월 요금제
            }
            sb.append(Math.min(ratePlan[12], fee.year)).append('\n');
        }
        System.out.println(sb);
    }


    static class Fee {
        int day, month, tMonth, year;

        public Fee(int day, int month, int tMonth, int year) {
            this.day = day;
            this.month = month;
            this.tMonth = tMonth;
            this.year = year;
        }
    }
}
