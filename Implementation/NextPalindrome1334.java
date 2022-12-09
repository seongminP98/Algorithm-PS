import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NextPalindrome1334 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int mid = N.charAt(N.length() / 2) - '0';
        int idx = N.length() / 2;

        if (N.length() % 2 == 0) { // 짝수
            for (int i = idx - 1; i >= 0; i--) {
                left.append(N.charAt(i));
            }
            for (int i = idx; i < N.length(); i++) {
                right.append(N.charAt(i));
            }
            boolean flag = false;

            for (int i = 0; i < left.length(); i++) {
                if (left.charAt(i) < right.charAt(i)) {
                    flag = true;
                } else if (left.charAt(i) == right.charAt(i)) {
                } else {
                    break;
                }
            }
            if (left.toString().equals(right.toString())) {
                flag = true;
            }
            if (flag) {
                String l = left.toString();
                StringBuilder newLeft = new StringBuilder();
                boolean check = false;
                for (int i = 0; i < l.length(); i++) {
                    if (check) {
                        newLeft.append(l.charAt(i));
                        continue;
                    }
                    if (l.charAt(i) - '0' == 9) {
                        newLeft.append(0);
                    } else {
                        newLeft.append(l.charAt(i) - '0' + 1);
                        check = true;
                    }
                }
                if (!check) {
                    newLeft.append(1);
                }
                for (int i = newLeft.toString().length() - 1; i >= 0; i--) {
                    answer.append(newLeft.toString().charAt(i));
                }
                if (!check) {
                    answer.append(newLeft.subSequence(1, newLeft.length()));

                } else {
                    answer.append(newLeft);
                }

            } else {
                for (int i = left.toString().length() - 1; i >= 0; i--) {
                    answer.append(left.toString().charAt(i));
                }
                answer.append(left);
            }

        } else { // 홀수

            for (int i = idx - 1; i >= 0; i--) {
                left.append(N.charAt(i));
            }
            for (int i = idx + 1; i < N.length(); i++) {
                right.append(N.charAt(i));
            }
            boolean flag = false;
            for (int i = 0; i < left.length(); i++) {
                if (left.charAt(i) < right.charAt(i)) {
                    flag = true;
                } else if (left.charAt(i) == right.charAt(i)) {
                } else {
                    break;
                }
            }
            if (left.toString().equals(right.toString())) {
                flag = true;
            }
            if (flag) {
                mid++;
                if (mid == 10) {
                    mid = 0;
                    String l = left.toString();
                    StringBuilder newLeft = new StringBuilder();
                    boolean check = false;
                    for (int i = 0; i < l.length(); i++) {
                        if (check) {
                            newLeft.append(l.charAt(i));
                            continue;
                        }
                        if (l.charAt(i) - '0' == 9) {
                            newLeft.append(0);
                        } else {
                            newLeft.append(l.charAt(i) - '0' + 1);
                            check = true;
                        }
                    }
                    if (!check) {
                        newLeft.append(1);
                    }
                    for (int i = newLeft.toString().length() - 1; i >= 0; i--) {
                        answer.append(newLeft.toString().charAt(i));
                    }
                    if (check) {
                        answer.append(mid);
                    }
                    answer.append(newLeft);

                } else {
                    for (int i = left.toString().length() - 1; i >= 0; i--) {
                        answer.append(left.toString().charAt(i));
                    }
                    answer.append(mid);
                    answer.append(left);
                }
            } else {
                for (int i = left.toString().length() - 1; i >= 0; i--) {
                    answer.append(left.toString().charAt(i));
                }
                answer.append(mid);
                answer.append(left);
            }
        }
        System.out.println(answer);
    }
}
