import java.util.Arrays;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int width = 2;
        int length = (brown / 2 + 1) - width + 1;
        int total = brown + yellow;
        while (true) {
            width++;
            length = (brown / 2 + 1) - width + 1;
            if (width < length) {
                continue;
            }
            int sum = width * length;
            if (sum == total) {
                return new int[]{width, length};
            }
        }
    }

    public static void main(String[] args) {
        Carpet carpet = new Carpet();
        System.out.println(Arrays.toString(carpet.solution(24, 24)));
    }
}