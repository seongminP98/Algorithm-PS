import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PhoneNumList {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, String> hm = new HashMap<>();

        for (String s : phone_book) {
            hm.put(s,s);
        }

        for(String s : phone_book) {
            for(int i=0; i<s.length(); i++) {
                String temp = s.substring(0,i);
                if(hm.containsKey(temp)) {
                    return false;
                }
            }
        }
        return answer;
    }
}
