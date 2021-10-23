import java.util.ArrayList;
import java.util.List;

public class TakeGroupPhoto {
    static int answer;
    static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        answer = 0;
        boolean[] visited = new boolean[8];
        List<String> list = new ArrayList<>();
        dfs(list, visited, data);
        System.out.println("answer = " + answer);

    }
    static void dfs(List<String> list, boolean[] visited, String[] data) {
        if(list.size() == 8) {
            if(check(list, data)){
                answer++;
            }
            return;
        }

        for (int i=0; i<8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(friends[i]);
                dfs(list, visited, data);
                visited[i] = false;
                list.remove(String.valueOf(friends[i]));
            }
        }
    }
    static boolean check(List<String> list, String[] data) {
        for (String d : data) {
            int pos1 = list.indexOf(Character.toString(d.charAt(0)));
            int pos2 = list.indexOf(Character.toString(d.charAt(2)));
            if (d.charAt(3) == '=') {
                if(!(Math.abs(pos1-pos2) == d.charAt(4)-'0'+1)){
                    return false;
                }
            } else if(d.charAt(3) == '>') {
                if(!(Math.abs(pos1-pos2) > d.charAt(4)-'0'+1)){
                    return false;
                }
            } else if(d.charAt(3) == '<') {
                if(!(Math.abs(pos1-pos2) < d.charAt(4)-'0'+1)){
                    return false;
                }
            }
        }
        return true;
    }
}

/*
import java.util.ArrayList;
import java.util.List;
class Solution {
    static int answer;
    static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    public int solution(int n, String[] data) {
        answer = 0;
        boolean[] visited = new boolean[8];
        List<String> list = new ArrayList<>();
        dfs(list, visited, data);
        return answer;
    }
    static void dfs(List<String> list, boolean[] visited, String[] data) {
        if(list.size() == 8) {
            if(check(list, data)){
                answer++;
            }
            return;
        }

        for (int i=0; i<8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(friends[i]);
                dfs(list, visited, data);
                visited[i] = false;
                list.remove(String.valueOf(friends[i]));
            }
        }
    }
    static boolean check(List<String> list, String[] data) {
        for (String d : data) {
            int pos1 = list.indexOf(Character.toString(d.charAt(0)));
            int pos2 = list.indexOf(Character.toString(d.charAt(2)));
            if (d.charAt(3) == '=') {
                if(!(Math.abs(pos1-pos2) == d.charAt(4)-'0'+1)){
                    return false;
                }
            } else if(d.charAt(3) == '>') {
                if(!(Math.abs(pos1-pos2) > d.charAt(4)-'0'+1)){
                    return false;
                }
            } else if(d.charAt(3) == '<') {
                if(!(Math.abs(pos1-pos2) < d.charAt(4)-'0'+1)){
                    return false;
                }
            }
        }
        return true;
    }
}
 */