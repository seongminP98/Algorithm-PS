import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IQTest1111 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // N>=3 일때 연립방정식 써야할듯?

        if (N == 1) {
            System.out.println("A");
        } else if (N == 2) {
            if (arr[0] == arr[1]) {
                System.out.println(arr[0]);
            } else {
                System.out.println("A");
            }
        } else { // N>=3
            if (arr[1] == arr[0]) {
                for (int i : arr) {
                    if (i != arr[0]) {
                        System.out.println("B"); // 3 3 3 3 5
                        return;
                    }
                }
                System.out.println(arr[0]); // 3 3 3 3 3
                return;
            }
//          arr[0] * a + b = arr[1];
//          arr[1] * a + b = arr[2];
//          (arr[i] - arr[0]) * a = arr[2] - arr[1];
            if ((arr[2] - arr[1]) % (arr[1] - arr[0]) != 0) { // a,b 는 정수니까 나누어 떨어져야 함.
                System.out.println("B");
            } else {
                int a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
                int b = arr[1] - (arr[0] * a);

                for (int i = 2; i < N; i++) {
                    if (arr[i - 1] * a + b != arr[i]) {
                        System.out.println("B");
                        return;
                    }
                }
                System.out.println(arr[N - 1] * a + b);
            }

        }

//        int answer = Integer.MAX_VALUE;
//        int cnt = 0;
//        for (int i = -10000; i < 10000; i++) {
//            for (int j = -10000; j < 10000; j++) {
//                boolean flag = false;
//                for (int k = 1; k < N; k++) {
//                    if (arr[k] != arr[k - 1] * i + j) {
//                        flag = true;
//                        break;
//                    }
//                }
//                if (!flag) {
//
//                    int temp = arr[N - 1] * i + j;
//                    if (answer != temp) {
//                        cnt++;
//                        answer = temp;
//                    }
//                }
//                if (cnt >= 2) {
//                    System.out.println("A");
//                    return;
//                }
//            }
//        }
//        if (cnt == 1) {
//            System.out.println(answer);
//        } else {
//            System.out.println("B");
//        }
    }
}
