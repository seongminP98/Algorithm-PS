import java.util.Arrays;
import java.util.Stack;

public class StockPrice {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 2, 3, 4};
        System.out.println(Arrays.toString(solution(prices)));
    }
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>(); // index 가 들어감.
        for(int i=0; i<prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        // 끝까지 주식이 떨어지지 않은 경우
       while(!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        return answer;
    }
}
