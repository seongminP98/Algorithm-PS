import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotOnConveyorBelt20055 {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[2 * N + 1];
        st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 1; i <= 2 * N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 0)
                count++;
        }
        boolean[] robot = new boolean[N + 1];
        int answer = 0;
        while (count < K) {
            answer++;

            //1번
            int last = arr[2 * N];
            for (int i = 2 * N; i > 1; i--) {
                arr[i] = arr[i - 1];
            }
            arr[1] = last;

            for (int i = N - 1; i > 1; i--) {
                robot[i] = robot[i - 1];
            }
            robot[1] = false;


            //2번
            for (int i = N - 1; i > 0; i--) {
                if (robot[i] && arr[i + 1] != 0 && !robot[i + 1]) {
                    robot[i + 1] = true;
                    robot[i] = false;
                    arr[i + 1]--;
                    if (arr[i + 1] == 0)
                        count++;
                }
            }
            robot[N] = false;

            //3번
            if (arr[1] != 0) {
                robot[1] = true;
                arr[1]--;
                if (arr[1] == 0)
                    count++;
            }

        }
        System.out.println(answer);
    }
}
