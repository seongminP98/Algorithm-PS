import java.util.PriorityQueue;

public class PGMoreSpicy {
    public static void main(String[] args) throws Exception {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }
        while (true) {
            if (pq.peek() < K) {
                if (pq.size() >= 2) {
                    pq.add(pq.poll() + pq.poll() * 2);
                    answer++;
                } else {
                    System.out.println(-1);
                    System.exit(0);
                }
            } else {
                break;
            }
        }
        System.out.println(answer);
    }
}
/*
import java.util.PriorityQueue;


class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }
        while (true) {
            if (pq.peek() < K) {
                if (pq.size() >= 2) {
                    pq.add(pq.poll() + pq.poll() * 2);
                    answer++;
                } else {
                    return -1;
                }
            } else {
                break;
            }
        }
        return answer;
    }
}
 */