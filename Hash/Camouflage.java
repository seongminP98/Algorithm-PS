import java.util.HashMap;
import java.util.Map;

public class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> hm = new HashMap<>();
        for (String[] clothe : clothes) {
            if (!hm.containsKey(clothe[1])) {
                hm.put(clothe[1], 1);
            } else {
                hm.put(clothe[1], hm.get(clothe[1]) + 1);
            }
        }

        for (String clothe : hm.keySet()) {
            answer *= (hm.get(clothe) + 1);
        }
        answer-=1;

        return answer;
    }
}