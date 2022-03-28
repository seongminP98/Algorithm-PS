import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NewsClustering {
    public static void main(String[] args) {
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        loop:
        for (int i = 0; i < str1.length() - 1; i++) {
            String key = str1.substring(i, i + 2);
            for (int j = 0; j < key.length(); j++) {
                if (key.charAt(j) < 'a' || key.charAt(j) > 'z') {
                    continue loop;
                }
            }
            map1.put(key, map1.getOrDefault(key, 0) + 1);
        }
        loop:
        for (int i = 0; i < str2.length() - 1; i++) {
            String key = str2.substring(i, i + 2);
            for (int j = 0; j < key.length(); j++) {
                if (key.charAt(j) < 'a' || key.charAt(j) > 'z') {
                    continue loop;
                }
            }
            map2.put(key, map2.getOrDefault(key, 0) + 1);
        }
        int intersection = 0;
        int union = 0;
        for (String s : map1.keySet()) {
            if (map2.containsKey(s)) {
                intersection += Math.min(map1.get(s), map2.get(s));
            }
        }

        for (String s : map1.keySet()) {
            if (map2.containsKey(s)) {
                union += Math.max(map1.get(s), map2.get(s));
                map1.put(s, 0);
                map2.put(s, 0);
//                map1.remove(s);
//                map2.remove(s);
            }
        }

        for (String s : map2.keySet()) {
            union += map2.get(s);
        }
        for (String s : map1.keySet()) {
            union += map1.get(s);
        }

        if(intersection == 0 && union == 0) {
            System.out.println(65536);
        }
        if(intersection == 0) {
            System.out.println(0);
        }
        int answer = (int) (intersection / (union * 1.0) * 65536);
        System.out.println(answer);
    }
}
/*
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        loop:
        for (int i = 0; i < str1.length() - 1; i++) {
            String key = str1.substring(i, i + 2);
            for (int j = 0; j < key.length(); j++) {
                if (key.charAt(j) < 'a' || key.charAt(j) > 'z') {
                    continue loop;
                }
            }
            map1.put(key, map1.getOrDefault(key, 0) + 1);
        }
        loop:
        for (int i = 0; i < str2.length() - 1; i++) {
            String key = str2.substring(i, i + 2);
            for (int j = 0; j < key.length(); j++) {
                if (key.charAt(j) < 'a' || key.charAt(j) > 'z') {
                    continue loop;
                }
            }
            map2.put(key, map2.getOrDefault(key, 0) + 1);
        }
        int intersection = 0;
        int union = 0;
        for (String s : map1.keySet()) {
            if (map2.containsKey(s)) {
                intersection += Math.min(map1.get(s), map2.get(s));
            }
        }

        for (String s : map1.keySet()) {
            if (map2.containsKey(s)) {
                union += Math.max(map1.get(s), map2.get(s));
                map1.put(s, 0);
                map2.put(s, 0);
//                map1.remove(s);
//                map2.remove(s);
            }
        }

        for (String s : map2.keySet()) {
            union += map2.get(s);
        }
        for (String s : map1.keySet()) {
            union += map1.get(s);
        }

        int answer = (int) (intersection / (union * 1.0) * 65536);
        if(intersection == 0 && union == 0) {
            return 65536;
        }
        if(intersection == 0) {
            return 0;
        }
        return answer;
    }
}
 */
