import java.util.*;

public class FunctionDevelopment {
    public static void main(String[] args) {
        int[] progresses = {99,98,97,96,96};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<progresses.length; i++) {
            int amount = 100 - progresses[i];
            int day;
            if (amount%speeds[i] != 0) {
                day = amount/speeds[i] + 1;
            } else {
                day = amount/speeds[i];
            }
            if (!q.isEmpty()) {
                if (q.peek() < day) {
                    list.add(q.size());
                    q.clear();
                }
            }
            q.offer(day);
        }

        if(!q.isEmpty())
            list.add(q.size());

        int[] answer = new int[list.size()];
        int i=0;
        for (Integer integer : list) {
            answer[i++] = integer;
        }
        for (int i1 : answer) {
            System.out.println("i1 = " + i1);
        }
    }
}
/*
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<progresses.length; i++) {
            int amount = 100 - progresses[i];
            int day;
            if (amount%speeds[i] != 0) {
                day = amount/speeds[i] + 1;
            } else {
                day = amount/speeds[i];
            }
            if (!q.isEmpty()) {
                if (q.peek() < day) {
                    list.add(q.size());
                    q.clear();
                }
            }
            q.offer(day);
        }

        if(!q.isEmpty())
            list.add(q.size());

        int[] answer = new int[list.size()];
        int i=0;
        for (Integer integer : list) {
            answer[i++] = integer;
        }

        return answer;
    }
}
 */
