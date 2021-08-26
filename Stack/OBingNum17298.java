import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class OBingNum17298 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        /**
         * arr 배열을 돌면서 스택이 비었으면 먼저 스택에 index 값을 넣고,
         * 스택이 비어있지 않고, 현재 arr 의 값이 arr[stack.peek()] 값보다 크면
         * arr[stack.peek()] = 현재 arr 값으로 바꿔주고 pop 한다.
         * for 문을 다 돌았을 때 스택에 남아있는 값을 인덱스로 갖는 arr 값은 -1이다.
         */
        for(int i=0; i<N; i++) {

            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
}
