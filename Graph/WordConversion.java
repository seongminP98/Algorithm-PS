import java.util.LinkedList;
import java.util.Queue;

public class WordConversion {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        boolean[] visited = new boolean[words.length];
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));
        while (!q.isEmpty()) {
            Word c = q.poll();
            if (c.str.equals(target)) {
                System.out.println(c.count);
                System.exit(0);
            }
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && check(words[i], c.str)) {
                    visited[i] = true;
                    q.add(new Word(words[i], c.count + 1));
                }
            }
        }
        System.out.println(0);
    }

    static boolean check(String s1, String s2) {
        boolean flag = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (!flag)
                    flag = true;
                else {
                    return false;
                }
            }
        }
        return true;
    }

    static class Word {
        String str;
        int count;

        public Word(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }
}
