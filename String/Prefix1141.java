import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prefix1141 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, ((o1, o2) -> {
            return o1.length() - o2.length();
        }));
        int answer = N;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[j].startsWith(arr[i])) {
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);

    }
}
