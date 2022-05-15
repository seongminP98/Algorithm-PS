import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DurumariTissue {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String before = br.readLine();
        String after = br.readLine();

        System.out.println(solve(before, after, N) ? "YES" : "NO");
    }

    static boolean solve(String before, String after, int N) {
        if (before.charAt(0) != after.charAt(0) || before.charAt(N - 1) != after.charAt(N - 1)) {
            return false;
        }
        StringBuilder beforeCons = new StringBuilder();
        List<Character> beforeList = new ArrayList<>();
        StringBuilder afterCons = new StringBuilder();
        List<Character> afterList = new ArrayList<>();

        for (int i = 1; i < N - 1; i++) {
            if (isVowel(before.charAt(i))) {
                beforeList.add(before.charAt(i));
            } else {
                beforeCons.append(before.charAt(i));
            }

            if (isVowel(after.charAt(i))) {
                afterList.add(after.charAt(i));
            } else {
                afterCons.append(after.charAt(i));
            }
        }
        if (!beforeCons.toString().equals(afterCons.toString())) {
            return false;
        }
        Collections.sort(beforeList);
        Collections.sort(afterList);
        if (beforeList.size() != afterList.size()) {
            return false;
        }
        for (int i = 0; i < beforeList.size(); i++) {
            if (beforeList.get(i) != afterList.get(i)) {
                return false;
            }
        }
        return true;

    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
