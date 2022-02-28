import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class King1063 {
    static int[] dc = {0, 0, 1, -1, 1, -1, 1, -1}; //T,B,R,L,RT,LT,RB,LB   //알파벳
    static int[] dr = {1, -1, 0, 0, 1, 1, -1, -1};                     //숫자

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String stone = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int kc = king.charAt(0);
        int kr = king.charAt(1) - '0';
        int sc = stone.charAt(0);
        int sr = stone.charAt(1) - '0';

        for (int i = 0; i < N; i++) {
            String move = br.readLine();
            int dir;

            switch (move) {
                case "R":
                    dir = 2;
                    break;
                case "L":
                    dir = 3;
                    break;
                case "B":
                    dir = 1;
                    break;
                case "T":
                    dir = 0;
                    break;
                case "RT":
                    dir = 4;
                    break;
                case "LT":
                    dir = 5;
                    break;
                case "RB":
                    dir = 6;
                    break;
                default:  //"LB"
                    dir = 7;
                    break;
            }
            int nkc = kc + dc[dir];
            int nkr = kr + dr[dir];
            if (nkc >= 65 && nkc <= 72 && nkr <= 8 && nkr >= 1) {
                if (nkc == sc && nkr == sr) {
                    int nsc = sc + dc[dir];
                    int nsr = sr + dr[dir];
                    if (nsc >= 65 && nsc <= 72 && nsr <= 8 && nsr >= 1) {
                        kc = nkc;
                        kr = nkr;
                        sc = nsc;
                        sr = nsr;
                    }
                } else {
                    kc = nkc;
                    kr = nkr;
                }
            }
        }
        sb.append((char) kc).append(kr).append('\n').append((char) sc).append(sr);
        System.out.print(sb);
    }
}
