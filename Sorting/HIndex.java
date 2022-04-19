import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));

    }

    static int solution(int[] citations) {
        Arrays.sort(citations);

        int size = citations.length;
        for (int i = 0; i < size; i++) {
            int h = size - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}
