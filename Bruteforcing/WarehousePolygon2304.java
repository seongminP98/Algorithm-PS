import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class WarehousePolygon2304 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });


        Stack<int[]> leftStack = new Stack<>();
        Stack<int[]> rightStack = new Stack<>();

        int maxH = 0;
        for (int[] ints : arr) {
            if (ints[1] >= maxH) { //가장 높은창고가 2개 이상일 경우를 생각해 = 표시 붙여줌.
                maxH = ints[1];
                leftStack.push(ints);
            }
        }

        maxH = 0;
        for(int i=arr.length-1; i>=0; i--) {
            if(arr[i][1]>maxH) {
                maxH = arr[i][1];
                rightStack.push(arr[i]);
            }
        }

        int ans = 0;

        int index = leftStack.peek()[0];
        int max = leftStack.peek()[1];

        leftStack.pop();

        while(!leftStack.isEmpty()) {
            int cIndex = leftStack.peek()[0];
            int cHeight = leftStack.peek()[1];

            leftStack.pop();
            ans += (index - cIndex) * (cHeight);
            index = cIndex;
        }

        index = rightStack.peek()[0];
        rightStack.pop();

        while(!rightStack.isEmpty()) {
            int cIndex = rightStack.peek()[0];
            int cHeight = rightStack.peek()[1];

            rightStack.pop();
            ans += (cIndex - index) * (cHeight);
            index = cIndex;
        }

        ans+=max; //가장 높은 .
        System.out.println("ans = " + ans);

    }
}
