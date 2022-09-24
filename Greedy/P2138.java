import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2138 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String cStr = br.readLine();
        String goalStr = br.readLine();

        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        int[] goal = new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = cStr.charAt(i) - '0';
            arr2[i] = cStr.charAt(i) - '0';
            goal[i] = goalStr.charAt(i) - '0';
        }
        arr1[0] = 1 - arr1[0];
        arr1[1] = 1 - arr1[1];
        int answer1 = 1;
        int answer2 = 0;

        for (int i = 1; i < N; i++) {
            if (arr1[i - 1] != goal[i - 1]) {
                answer1++;
                arr1[i - 1] = 1 - arr1[i - 1];
                arr1[i] = 1 - arr1[i];
                if (i != N - 1) {
                    arr1[i + 1] = 1 - arr1[i + 1];
                }
            }

            if (arr2[i - 1] != goal[i - 1]) {
                answer2++;
                arr2[i - 1] = 1 - arr2[i - 1];
                arr2[i] = 1 - arr2[i];
                if (i != N - 1) {
                    arr2[i + 1] = 1 - arr2[i + 1];
                }
            }
        }
        String s1 = Arrays.toString(arr1);
        String s2 = Arrays.toString(arr2);
        String g = Arrays.toString(goal);
        if (s1.equals(g)) {
            if (s2.equals(g)) {
                System.out.println(Math.min(answer1, answer2));
            } else {
                System.out.println(answer1);
            }
        } else {
            if (s2.equals(g)) {
                System.out.println(answer2);
            } else {
                System.out.println(-1);
            }
        }
    }
}
