import java.io.BufferedReader;
import java.io.InputStreamReader;


public class DecreasingNumber1174 {
    static int count = 1;
    static int[] output;
    static StringBuilder sb = new StringBuilder();
    static int temp = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[10][9]; //row는 자릿수 (+1) , col은 첫번째 자리 (+1)
        for (int i = 0; i < 9; i++) {
            arr[0][i] = 1;
        }
        arr[1][0] = 1;
        for (int i = 1; i < 10; i++) { //배열안에는 자릿수와, 첫번째 숫자에 해당하는 줄어드는 수가 몇개인지 저장.
            for (int j = 1; j < 9; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j - 1];
            }
        }

        int r = 0;
        int c = 0;
        loop:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                count += arr[i][j];
                if (count >= N) {
                    r = i;
                    c = j;
                    break loop;
                }
            }
        }
        c++;
        count -= N;

//        System.out.println("r = " + r + " c = "+c+" count = "+count);
        output = new int[c];
        if (N > 1023) //총 줄어드는 수의 개수는 1023개
            System.out.println(-1);
        else if (N <= 10) {
            System.out.println(N - 1);
        } else {
            sb.append(c);
            perm(r, 0, c);
        }
    }

    static void perm(int r, int depth, int c) { //순열
        if (r == depth) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < r; i++) {
                s.append(output[i]);
            }
            boolean check = true;
            for (int i = 1; i < s.length(); i++) { //줄어드는 수 인지 확인.
                if (s.charAt(i - 1) <= s.charAt(i)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                if (temp == count) { //줄어드는 수라면 해당 위치까지 반복한다음 해당 위치면 출력.
                    sb.append(s);
                    System.out.println(sb);
                    System.exit(0);

                }
                temp++;
            }
            return;
        } else {
            for (int i = c - 1; i >= 0; i--) { //순서는 내림차순임.
                output[depth] = i;
                perm(r, depth + 1, c);
            }
        }
    }
}
