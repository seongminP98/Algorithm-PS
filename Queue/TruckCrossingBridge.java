import java.util.LinkedList;
import java.util.Queue;

public class TruckCrossingBridge {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = new int[]{7, 4, 5, 6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int truck_weight : truck_weights) {
            q.add(truck_weight);
        }
        int[] bridge = new int[bridge_length];
        int sumW = 0;
        while (!q.isEmpty()) {
            if (q.peek() + sumW <= weight) {
                int cTruck = q.poll();
                bridge[0] = cTruck;
                sumW += cTruck;
            }
            for (int i = bridge_length - 1; i >= 0; i--) {
                if (bridge[i] != 0) {
                    int tmp = bridge[i];
                    bridge[i] = 0;
                    if (i == bridge_length - 1) {
                        sumW -= tmp;
                    } else {
                        bridge[i + 1] = tmp;
                    }
                }
            }
            answer++;
        }
        for (int i = 0; i < bridge_length; i++) {
            if (bridge[i] != 0) {
                answer += (bridge_length - i + 1);
                break;
            }
        }

        return answer;
    }
}
