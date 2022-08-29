import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AttendanceAward1563 {
    static int N, answer;
    static final int DIV = 1_000_000;
    static int[][][] d; // 일, 지각, 결석

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 한 학기 일 수
        d = new int[N + 1][2][3]; // 일, 지각, 결석
        d[1][0][0] = d[1][1][0] = d[1][0][1] = 1;
        for (int i = 2; i <= N; i++) {
            d[i][0][0] = (d[i - 1][0][0] + d[i - 1][0][1] + d[i - 1][0][2]) % DIV; // 현재(i) 지각 0, 결석 0
            d[i][0][1] = (d[i - 1][0][0]) % DIV;
            d[i][0][2] = (d[i - 1][0][1]) % DIV;
            d[i][1][0] = (d[i - 1][0][0] + d[i - 1][0][1] + d[i - 1][0][2] + d[i - 1][1][0] + d[i - 1][1][1] + d[i - 1][1][2]) % DIV;
            d[i][1][1] = (d[i - 1][1][0]) % DIV;
            d[i][1][2] = (d[i - 1][1][1]) % DIV;
        }
        answer = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                answer += d[N][i][j];
            }
        }
        System.out.println(answer % DIV);

    }
}
