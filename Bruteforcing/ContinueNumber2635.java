import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ContinueNumber2635 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int answer = 1;
        List<Integer> answerList = new ArrayList<>();
        for (int i = num; i > num / 2; i--) {
            List<Integer> list = new ArrayList<>();
            list.add(num);
            int num1 = num;
            int num2 = i;
            while (true) {
                int num3 = num1 - num2;
                num1 = num2;
                if (num1 < 0)
                    break;
                num2 = num3;
                list.add(num1);
            }

            if (answer < list.size()) {
                answer = list.size();
                answerList = list;
            }
        }
        System.out.println(answer);
        for (Integer integer : answerList) {
            System.out.print(integer + " ");
        }
    }
}
