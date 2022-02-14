import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P24039 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[105];
        //소수면 false
        arr[0] = arr[1] = true;
        for (int i = 2; i * i < arr.length; i++) {
            if (!arr[i]) {
                for (int j = i * i; j < arr.length; j += i) {
                    arr[j] = true;
                }
            }
        }
        List<Integer> prime = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) prime.add(i);
        }

        for (int i = 1; i < prime.size(); i++) {
            if (prime.get(i - 1) * prime.get(i) > N) {
                System.out.println(prime.get(i - 1) * prime.get(i));
                System.exit(0);
            }
        }
    }
}
