import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GuitarStrings1049 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int minPkg = Integer.MAX_VALUE;
        int minOne = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            minPkg = Math.min(minPkg, Integer.parseInt(st.nextToken()));
            minOne = Math.min(minOne, Integer.parseInt(st.nextToken()));
        }
        if (minPkg / 6.0 < minOne) {
            int num = N / 6;
            int rem = N % 6;
            int answer = minPkg * num;
            answer += Math.min(rem * minOne, minPkg);
            System.out.println(answer);
        } else {
            System.out.println(minOne * N);
        }
    }
}
