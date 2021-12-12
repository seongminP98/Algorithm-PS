import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CalculateInsufficientAmount {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());
        int money = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());

        long sumCount = 0;
        for (int i = 1; i <= count; i++) {
            sumCount += i;
        }
        long sumPrice = sumCount * price;
        if(sumPrice - money < 0) {
            System.out.println(0);
        } else {
            System.out.println(sumPrice - money);

        }
    }
}
