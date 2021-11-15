import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SimilarWord2607 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String first = br.readLine();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < first.length(); i++) {
            list.add(first.charAt(i));
        }
        int answer = 0;
        for (int i = 0; i < N - 1; i++) {
            ArrayList<Character> word = (ArrayList<Character>) list.clone();
            boolean flag = true;
            boolean check = true;
            String compare = br.readLine();
            for (int j = 0; j < compare.length(); j++) {
                if (word.contains(compare.charAt(j))) {
                    word.remove((Character) compare.charAt(j));
                } else {
                    if (!flag) {
                        check = false;
                        break;
                    }
                    flag = false;
                }
            }
            if (word.size() == 1 && check) {
                answer++;
            } else if (word.size() == 0 && check) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
