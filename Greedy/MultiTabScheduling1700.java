import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MultiTabScheduling1700 {
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] check = new boolean[101];
        int answer = 0;
        int pluggedIn = 0;
        for (int i = 0; i < K; i++) {
            if (check[arr[i]]) //현재 기기가 꽂혀있음.
                continue;

            if (pluggedIn < N) {
                check[arr[i]] = true;
                pluggedIn++;
            } else {
                Stack<Integer> stack = new Stack<>();
                for (int j = i; j < K; j++) { //이번에 꽂을 기기가 안꽂혀있을 경우. / 현재 꽂혀있는 기기 중 다음에도 쓰이는 기기 체크
                    if (check[arr[j]] && !stack.contains(arr[j])) {
                        stack.push(arr[j]);
                    }
                }
                if (stack.size() < N) { //다음에 쓰이는 기기들의 수가 구멍 수보다 작으면, 안쓰이는 기기를 제거
                    for (int j = 0; j < 101; j++) {
                        if (check[j] && !stack.contains(j)) {
                            check[j] = false;
                            break;
                        }
                    }
                } else { //가장 마지막에 쓰이는 기기 제거
                    check[stack.pop()] = false;
                }
                check[arr[i]] = true;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
