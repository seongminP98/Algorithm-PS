import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DNA1969 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];
        for(int i=0; i<N; i++) {
            arr[i] = br.readLine();
        }
        String ansStr = "";
        int answer = 0;
        for(int i=0; i<M; i++) {
            Map<Character, Integer> hm = new HashMap<>();
            for(int j=0; j<N; j++) {
                hm.put(arr[j].charAt(i), hm.getOrDefault(arr[j].charAt(i),0)+1);
            }
            char cChar = maxChar(hm);
            ansStr += cChar;
            for(int j=0; j<N; j++) {
                if(arr[j].charAt(i) != cChar) {
                    answer++;
                }
            }
        }
        System.out.println(ansStr);
        System.out.println(answer);
    }
    static char maxChar(Map<Character, Integer> hm) {
        int result = 0;
        char ans = 'a';
        for (Character character : hm.keySet()) {
            if(result < hm.get(character)) {
                result = hm.get(character);
                ans = character;
            }
        }
        Set<Character> set = new HashSet<>();
        for (Character character : hm.keySet()) {
            if(result == hm.get(character)) {
                set.add(character);
            }
        }

        for (Character character : set) {
            if(ans > character) {
                ans = character;
            }
        }

        return ans;

    }
}
