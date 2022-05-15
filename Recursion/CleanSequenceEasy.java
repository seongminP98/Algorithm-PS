import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CleanSequenceEasy {
    public static void main(String[] args) throws Exception {
        System.out.println(factorial(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }

    static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
