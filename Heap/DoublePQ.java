import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DoublePQ {
    public static void main(String[] args) {
        String[] operations = {"I 7", "I 5", "I -5", "D -1"};
        System.out.println(Arrays.toString(solution(operations)));
    }

    static int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            if (st.nextToken().equals("I")) {
                int n = Integer.parseInt(st.nextToken());
                maxPq.add(n);
                minPq.add(n);
            } else {
                if (st.nextToken().equals("1")) {
                    minPq.remove(maxPq.poll());
                } else {
                    maxPq.remove(minPq.poll());
                }
            }
        }

        if (!maxPq.isEmpty()) {
            answer[0] = maxPq.poll();
            answer[1] = minPq.poll();
        }

        return answer;
    }
}
