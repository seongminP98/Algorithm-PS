import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Printer {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] priorities = new int[n];
        for(int i=0; i<n; i++) {
            priorities[i] = Integer.parseInt(br.readLine());
        }
        int location = Integer.parseInt(br.readLine());

        Queue<Priority> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            q.add(new Priority(i,priorities[i]));
        }
        int answer = 0;
        while(!q.isEmpty()) {
            int cValue = q.peek().value;
            int cIndex = q.peek().index;
            boolean check = false;
            for (Priority priority : q) {
                if(cValue < priority.value){
                    check = true;
                }
            }

            if(check) {
                q.add(q.poll());
            } else{
                q.poll();
                answer++;
                if(cIndex == location) {
                    break;
                }
            }
        }
        System.out.println(answer);

    }

    static class Priority{
        int index, value;
        Priority(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
/*
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Priority> q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            q.add(new Priority(i,priorities[i]));
        }

        while(!q.isEmpty()) {
            int cValue = q.peek().value;
            int cIndex = q.peek().index;
            boolean check = false;
            for (Priority priority : q) {
                if(cValue < priority.value){
                    check = true;
                }
            }

            if(check) {
                q.add(q.poll());
            } else{
                q.poll();
                answer++;
                if(cIndex == location) {
                    break;
                }
            }
        }

        return answer;
    }
    static class Priority{
        int index, value;
        Priority(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
 */