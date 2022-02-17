import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CollectingBalls17615 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = new char[N];
        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = s.charAt(i);
        }
        int frontB = 0;
        int backB = 0;
        int frontR = 0;
        int backR = 0;
        if (arr[0] == 'B') {
            frontB++;
        } else {
            frontR++;
        }
        if (arr[N - 1] == 'B') {
            backB++;
        } else {
            backR++;
        }
        for (int i = 1; i < N; i++) {
            if (frontB > 0) {
                if (arr[i] == 'B') {
                    frontB++;
                } else {
                    break;
                }
            } else {
                if (arr[i] == 'R') {
                    frontR++;
                } else {
                    break;
                }
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            if (backB > 0) {
                if (arr[i] == 'B') {
                    backB++;
                } else {
                    break;
                }
            } else {
                if (arr[i] == 'R') {
                    backR++;
                } else {
                    break;
                }
            }
        }

        //앞으로 보내기
        int answer = 0;
        if (frontB > 0) { //맨 앞이 blue / 앞으로 옮겨야할 blue 공 갯수
            for (int i = frontB; i < N; i++) {
                if (arr[i] == 'B') {
                    answer++;
                }
            }
        } else { //맨 앞이 red
            for (int i = frontR; i < N; i++) {
                if (arr[i] == 'R') {
                    answer++;
                }
            }
        }

        //뒤로 보내기
        int back = 0;
        if (backB > 0) { //맨 뒤가 blue
            for (int i = 0; i < N - backB; i++) {
                if (arr[i] == 'B') {
                    back++;
                }
            }
        } else { //맨 뒤가 red
            for (int i = 0; i < N - backR; i++) {
                if (arr[i] == 'R') {
                    back++;
                }
            }
        }

        //맨 앞, 맨 뒤 전부 red 일 때, blue 공의 수가 적으면 blue 공만 다 옮기면 됨.
        int blue = 0;
        if (frontR > 0 && backR > 0) {
            for (char c : arr) {
                if (c == 'B') {
                    blue++;
                }
            }
            answer = Math.min(answer, blue);
        }

        //맨 앞, 맨 뒤 전부 blue 일 때, red 공의 수가 적으면 red 공만 다 옮기면 됨.
        int red = 0;
        if (frontB > 0 && backB > 0) {
            for (char c : arr) {
                if (c == 'R') {
                    red++;
                }
            }
            answer = Math.min(answer, red);
        }
        answer = Math.min(answer, back);


        System.out.println(answer);
    }
}
