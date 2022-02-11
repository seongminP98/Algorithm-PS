import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Ant10158 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()); //2*w 지나면 원래 자리로 옴.
        int q = Integer.parseInt(st.nextToken()); //2*h 지나면 원래 자리로 옴.
        int t = Integer.parseInt(br.readLine());
        int cnt = t % (2 * w);
        int x = (cnt + p) % (2 * w);
        if (x > w) {
            x = (2 * w) - x;
        }
        cnt = t % (2 * h);
        int y = (cnt + q) % (2 * h);
        if (y > h) {
            y = (2 * h) - y;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(x).append(" ").append(y);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
/**
 t p=4
 1 5
 2 6
 3 5
 4 4
 5 3
 6 2
 7 1
 8 0
 9 1
 10 2
 11 3
 12 4

 t+p = 5 6 7 8 9 10 11 12 13 14 15 16
 5 6 5 4 3  2  1  0  1  2  3  4

 5 6 7 8 9 10 11 0 1 2 3 4   if >6
 5 6 5 4 3 2  1  0 1 2 3 4
 */