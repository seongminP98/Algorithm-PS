import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CardGame2621 {
    static Card[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new Card[5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Card(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr); //숫자로 내림차순 정렬
        int score = 0;

        if (checkColor() && continuous()) {
            score = Math.max(score, arr[0].number + 900);
        }

        int checkFour = equalFour();
        if (checkFour > 0) {
            score = Math.max(score, checkFour + 800);
        }

        if (equalThree() > 0 && equalTwo(0) > 0) {
            score = Math.max(score, equalThree() * 10 + equalTwo(0) + 700);
        }

        if (checkColor()) {
            score = Math.max(score, arr[0].number + 600);
        }

        if (continuous()) {
            score = Math.max(score, arr[0].number + 500);
        }

        if (equalThree() > 0) {
            score = Math.max(score, equalThree() + 400);
        }

        if (equalTwo(0) > 0) {
            int start = equalTwo(0);
            if (equalTwo(start + 1) > 0) {
                score = Math.max(score, equalTwo(start + 1) * 10 + equalTwo(0) + 300);
            }
        }

        if (equalTwo(0) > 0) {
            score = Math.max(score, equalTwo(0) + 200);
        }
        if (score > 0) {
            System.out.println(score);
        } else {
            System.out.println(arr[0].number + 100);
        }
    }

    static boolean checkColor() {
        int c = arr[0].color;
        for (Card card : arr) {
            if (c != card.color) {
                return false;
            }
        }
        return true;
    }

    static boolean continuous() {
        int n = arr[0].number;
        for (int i = 1; i < 5; i++) {
            n--;
            if (arr[i].number != n) {
                return false;
            }
        }
        return true;
    }

    static int equalFour() {
        int[] number = new int[10];
        for (int i = 0; i < 5; i++) {
            number[arr[i].number]++;
        }

        for (int i = 1; i < 10; i++) {
            if (number[i] == 4) {
                return i;
            }
        }
        return 0;
    }

    static int equalThree() {
        int[] number = new int[10];
        for (int i = 0; i < 5; i++) {
            number[arr[i].number]++;
        }

        for (int i = 1; i < 10; i++) {
            if (number[i] == 3) {
                return i;
            }
        }
        return 0;
    }

    static int equalTwo(int start) {
        int[] number = new int[10];
        for (int i = 0; i < 5; i++) {
            number[arr[i].number]++;
        }

        for (int i = start; i < 10; i++) {
            if (number[i] == 2) {
                return i;
            }
        }
        return 0;
    }

    static class Card implements Comparable<Card> {
        char color;
        int number;

        public Card(char color, int number) {
            this.color = color;
            this.number = number;
        }

        @Override
        public int compareTo(Card o) {
            return o.number > this.number ? 1 : -1;
        }
    }
}
