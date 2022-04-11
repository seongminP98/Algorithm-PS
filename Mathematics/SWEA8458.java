import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA8458 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean flag = false;
            arr[0] = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
                if (arr[i - 1] % 2 != arr[i] % 2) { // 모두 홀수이거나, 짝수일 때 가능
                    flag = true;
                }
            }
            if(flag) {
                sb.append(-1).append('\n');
                continue;
            }
            Arrays.sort(arr);
            int max = arr[N - 1];
            int num = 0;
            int sum = 0;
            // 제일 큰 수를 원점까지 갈 때 몇번 필요한지 구하면 됨.
            // 원점을 지나쳤고 지나친 거리가 짝수이면 끝. 짝수라면 원점에서 왔다 갔다 2번씩 계속하면 원점으로 도착할테니까.
            while (sum < max || (sum - max) % 2 != 0) {
                sum += ++num;
            }

            sb.append(num).append('\n');
        }
        System.out.println(sb);
    }
}
