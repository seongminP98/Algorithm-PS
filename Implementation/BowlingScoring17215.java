import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BowlingScoring17215 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int frame = 1;
        boolean flag = false;
        int[] score = new int[11];
        for (int i = 0; i < s.length(); i++) {
            if (frame > 10) break; // 9-8P72S9P-9S-P9-2PS  > 10프레임 : 2PS
            if (s.charAt(i) == 'S') {
                if (frame <= 9) {
                    score[frame] += 10;
                    if (s.charAt(i + 2) == 'P') {
                        score[frame] += 10;
                    } else {
                        score[frame] += getScore(s.charAt(i + 1)) + getScore(s.charAt(i + 2));
                    }
                } else {
                    score[frame] += 10;
                    if (s.charAt(i + 2) == 'P') {
                        score[frame] += 10;
                    } else {
                        score[frame] += getScore(s.charAt(i + 1)) + getScore(s.charAt(i + 2));
                    }
                    break;
                }
                frame++;
                flag = false;
            } else {
                if (s.charAt(i) == 'P') {
                    score[frame] = 10;
                    score[frame] += getScore(s.charAt(i + 1));
                } else {
                    score[frame] += getScore(s.charAt(i));
                }

                if (flag) {
                    frame++;
                    flag = false;
                } else {
                    flag = true;
                }

            }
        }

        int answer = 0;
        for (int i = 1; i <= 10; i++) {
            answer += score[i];
        }
        System.out.println(answer);
    }

    private static int getScore(char c) {
        if (c == 'S') {
            return 10;
        } else if (c == '-') {
            return 0;
        } else {
            return c - '0';
        }
    }
}
