import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwitchOnOff1244 {
    static boolean[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                arr[i] = true;
            }
        }
        int p = Integer.parseInt(br.readLine()); //학생수
        for (int t = 0; t < p; t++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (s == 1) {
                for (int i = num; i < N + 1; i += num) {
                    arr[i] = !arr[i];
                }
            } else {
                arr[num] = !arr[num];
                for (int i = num + 1; i < N + 1; i++) {
                    int front = num - (i - num);
                    if (front >= 1 && arr[i] == arr[front]) {
                        arr[i] = !arr[i];
                        arr[front] = !arr[front];
                    } else {
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            if (arr[i]) sb.append(1).append(" ");
            else sb.append(0).append(" ");

            if (i % 20 == 0) {
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}
