import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
CCW 알고리즘. 신발끈 공식과 같다.
CCW 함수의 리턴 값이 양수면 반시계방향, 0이면 직선, 음수면 시계방향
 */
public class CCW11758 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        int a = x1 * y2 + x2 * y3 + x3 * y1;
        int b = x2 * y1 + x3 * y2 + x1 * y3;

        if (a - b > 0) {
            System.out.println(1);
        } else if (a == b) {
            System.out.println(0);
        } else {
            System.out.println(-1);
        }
    }
}
