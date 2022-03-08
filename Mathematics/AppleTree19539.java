import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AppleTree19539 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int odd = 0;
        for (int i = 0; i < N; i++) {
            int tree = Integer.parseInt(st.nextToken());
            sum += tree;
            if (tree % 2 == 1) {
                odd++;
            }
        }
        //하루에 무조건 3만큼 성장시킴. sum 은 3의 배수여야함.
        //(sum/3)은 총 일수. 홀수의 개수가 총 일수보다 작거나 같아야함.. (완벽히 이해안됨. 될까말까..)
        if (sum % 3 == 0 && odd <= sum / 3) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
