import java.util.*;

public class Tuple {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        Stack<Character> stack = new Stack<>();
        Map<Integer,Integer> hm = new HashMap<>();

        int start = 0;
        int end = 0;

        for(int i=1; i<s.length(); i++) {
            int size = 0;
            boolean flag = false;
            if(s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            while(!stack.isEmpty()) {
                i++;
                if(s.charAt(i) == '}'){
                    stack.pop();
                }
                size++;
                flag = true;
            }
            end = i;
            start = i-size+1;
            if(flag) {
                String numbers = s.substring(start,end);
                String[] split = numbers.split(",");
                for (String s1 : split) {
                    hm.put(Integer.parseInt(s1),hm.getOrDefault(Integer.parseInt(s1),0)+1);
                }
            }
        }

        int[] answer = new int[hm.size()];
        List<Map.Entry<Integer,Integer>> entryList = new LinkedList<>(hm.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int i=0;
        for (Map.Entry<Integer, Integer> entry : entryList) {
            answer[i++] = entry.getKey();
        }
        for (int i1 : answer) {
            System.out.println("i1 = " + i1);
        }


    }

}
/*
class Solution {
    public int[] solution(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Integer,Integer> hm = new HashMap<>();

        int start = 0;
        int end = 0;

        for(int i=1; i<s.length(); i++) {
            int size = 0;
            boolean flag = false;
            if(s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            while(!stack.isEmpty()) {
                i++;
                if(s.charAt(i) == '}'){
                    stack.pop();
                }
                size++;
                flag = true;
            }
            end = i;
            start = i-size+1;
            if(flag) {
                String numbers = s.substring(start,end);
                String[] split = numbers.split(",");
                for (String s1 : split) {
                    hm.put(Integer.parseInt(s1),hm.getOrDefault(Integer.parseInt(s1),0)+1);
                }
            }
        }

        int[] answer = new int[hm.size()];
        List<Map.Entry<Integer,Integer>> entryList = new LinkedList<>(hm.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int i=0;
        for (Map.Entry<Integer, Integer> entry : entryList) {
            answer[i++] = entry.getKey();
        }

        return answer;
    }
}
 */


/**
 * 다른 사람 풀이
 * replaceAll : 첫번째 인자에 [ ] 를 넣으면 [ ]안에 있는 문자하나씩 다 replace한다.
 * Arrays.sort 람다식.
 * set.add : 리턴값 boolean. set에 있으면 false, 없으면 true
 */
/*
class Solution {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}
*/