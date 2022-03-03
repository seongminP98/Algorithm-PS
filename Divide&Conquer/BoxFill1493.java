import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BoxFill1493 {
    static int length, width, height;
    static int N;
    static int[] cube;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        cube = new int[21];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cube[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        solution(length, width, height);
        System.out.println(answer);
    }

    static void solution(int l, int w, int h) {
        if (l == 0 || w == 0 || h == 0) {
            return;
        }
        boolean flag = false;
        int k = Math.min(Math.min(l, w), h);
        int cIdx = (int) (Math.log(k) / Math.log(2));
        for (int i = cIdx; i >= 0; i--) {
            if (cube[i] > 0) {
                cIdx = i;
                flag = true;
                break;
            }
        }
        cube[cIdx]--;
        if (!flag) { //넣을 수 있는 큐브가 없음.
            System.out.println(-1);
            System.exit(0);
        }
        int size = (int) Math.pow(2, cIdx);
        answer++;
        //가장 큰 큐브 하나를 넣고 남은 공간을 3개의 박스로 나눔.
        solution(l - size, w, h);
        solution(size, w - size, h);
        solution(size, size, h - size);

    }

}
