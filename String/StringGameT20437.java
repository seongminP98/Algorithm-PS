import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringGameT20437 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                sb.append(1).append(" ").append(1).append('\n');
                continue;
            }

            int[] arr = new int[26]; // 문자 개수 저장
            for (int i = 0; i < W.length(); i++) {
                arr[W.charAt(i) - 'a']++;
            }

            int min = 10001;
            int max = 0;
            for (int i = 0; i < W.length(); i++) { // 시작문자
                if (arr[W.charAt(i) - 'a'] < K) continue; // 확인 안해도 됨.

                int cnt = 1;
                for (int j = i + 1; j < W.length(); j++) {
                    if (W.charAt(j) == W.charAt(i)) {
                        cnt++;
                    }
                    if (cnt == K) {
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max, j - i + 1);
                        break;
                    }
                }
            }
            if(max==0) {
                sb.append(-1);
            }else {
                sb.append(min).append(" ").append(max);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
