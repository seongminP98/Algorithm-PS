import java.util.HashSet;
import java.util.Set;

public class CandidateKey {
    //    static boolean[] check;
    static Set<String> check;
    static int answer;

    public static void main(String[] args) {
//        String[][] relation = {
//                {"100", "ryan", "music", "2"},
//                {"200", "apeach", "math", "2"},
//                {"300", "tube", "computer", "3"},
//                {"400", "con", "computer", "4"},
//                {"500", "muzi", "music", "3"},
//                {"600", "apeach", "music", "2"}
//        };

        String[][] relation = {{"a", "1", "aaa", "c", "ng"},
                {"a", "1", "bbb", "e", "g"},
                {"c", "1", "aaa", "d", "ng"},
                {"d", "2", "bbb", "d", "ng"}};
        System.out.println(solution(relation));
    }

    private static int solution(String[][] relation) {
        answer = 0;
        check = new HashSet<>();
        int n = relation[0].length;
        for (int i = 0; i <= n; i++) {
            combination(n, 0, i, new boolean[n + 1], relation);
        }
        for (String s : check) {
            System.out.println(s);
        }
        return answer;
    }

    private static void combination(int n, int start, int r, boolean[] visited, String[][] relation) {
        if (r == 0) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            if (isCandidateKey(visited, relation)) {
                answer++;
            }
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(n, i + 1, r - 1, visited, relation);
            visited[i] = false;
        }
    }

    private static boolean isCandidateKey(boolean[] visited, String[][] relation) {
        Set<String> set = new HashSet<>();
        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(row[i]);
                }
            }
            if (!set.add(sb.toString())) {
                return false;
            }
        }
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                key.append(i);
            }
        }
        for (String s : check) { // key : 012 / s : 02 인 경우 체크하기 위해서
            int cnt = s.length();
            for (int i = 0; i < s.length(); i++) {
                if (key.toString().contains(s.charAt(i) + "")) {
                    cnt--;
                }
            }
            if (cnt == 0) {
                return false;
            }
        }
        check.add(key.toString());
        return true;
    }
}
