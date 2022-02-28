import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaseConversion11576 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];
        int decimal = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = m - 1; i >= 0; i--) {
            decimal += Math.pow(A, i) * Integer.parseInt(st.nextToken());
        }
        StringBuilder answer = new StringBuilder();
        while (decimal != 0) {
            answer.insert(0, decimal % B + " ");
            decimal /= B;
        }
        System.out.print(answer);
    }
}
