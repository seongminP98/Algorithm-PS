import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1700 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] pluggedIn = new boolean[K + 1];
        int count = 0; // 현재 꽂혀있는 기기 개수
        int answer = 0;
        for (int i = 0; i < K; i++) {
            if (pluggedIn[arr[i]]) continue; // 꽂혀있으면 패스

            if (count < N) { // 아직 자리가 있으면 그냥 꽂음
                pluggedIn[arr[i]] = true;
                count++;
                continue;
            }
            // 안꽂혀있으면 가장 마지막에 쓰이거나, 안쓰이는 기기 제거
            Stack<Integer> stack = new Stack<>();
            for (int j = i + 1; j < K; j++) {
                if (pluggedIn[arr[j]] && !stack.contains(arr[j])) {
                    stack.push(arr[j]);
                }
            }
            int remove = 0;
            if (stack.size() >= N) {
                remove = stack.pop();
            } else {
                for (int j = 1; j < K; j++) {
                    if (pluggedIn[arr[j]] && !stack.contains(arr[j])) { // 안쓰이는 기기
                        remove = arr[j];
                        break;
                    }
                }
            }

            pluggedIn[remove] = false;
            pluggedIn[arr[i]] = true;
            answer++;
        }
        System.out.println(answer);
    }
}
