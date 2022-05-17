import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SimilarWords2179 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> originList = new ArrayList<>(N);
        List<String> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }
        originList.addAll(list);
        Collections.sort(list);

        int cnt = 0; // 공통 접두사 길이
        Map<String, Integer> map = new HashMap<>(); // 접두사 길이가 같거나 최대로 갱신될 때마다 맵에 담아줌.
        for (int i = 1; i < list.size(); i++) {
            boolean flag = false;
            for (int j = cnt; j < list.get(i - 1).length(); j++) {
                if (list.get(i).startsWith(list.get(i - 1).substring(0, j))) {
                    cnt = j;
                    flag = true;
                }
            }
            if (flag) { // 접두사 길이가 같거나 더 크면 맵에 문자열 2개 다 담는다. 어떤게 먼저 입력됐는지 모르기때문
                map.put(list.get(i - 1), cnt);
                map.put(list.get(i), cnt);
            }
        }

        String ansStr = "";
        int ansIdx = N + 1;

        for (String s : map.keySet()) {
            if (map.get(s) == cnt) {
                if (originList.indexOf(s) < ansIdx) { // 접두사의 길이가 최대인 문자열 중 originList 에서 제일 앞에오는 문자열을 찾는다.
                    ansIdx = originList.indexOf(s);
                    ansStr = s;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ansStr).append('\n'); // 답의 첫 단어.
        String ansPrefix = ansStr.substring(0, cnt); // 접두사

        for (int i = ansIdx + 1; i < N; i++) {
            if (originList.get(i).startsWith(ansPrefix)) { // 답의 두 번째 단어.
                sb.append(originList.get(i));
                break;
            }
        }
        System.out.print(sb);
    }
}
