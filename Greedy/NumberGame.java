import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;

public class NumberGame {
    public static void main(String[] args) {
        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};
//        long milliseconds = 1664952246620L;
        long milliseconds = 1664954229937L;
        LocalDate date =
                Instant.ofEpochMilli(milliseconds).atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("date = " + date);
    }

    private static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = A.length - 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] < B[idx]) {
                answer++;
                idx--;
            }
        }
        return answer;
    }
}
