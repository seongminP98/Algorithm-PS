import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LightAndSwitch2138 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String current = br.readLine();
        String goal = br.readLine();
        int arr1[] = new int[N]; //첫번째 스위치 눌렀을 때
        int arr2[] = new int[N]; //첫번째 스위치 안눌렀을 때
        int goal_arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr1[i] = current.charAt(i)-'0';
            arr2[i] = current.charAt(i)-'0';
            goal_arr[i] = goal.charAt(i)-'0';
        }

        int result1 = 1; //arr1은 첫번째 스위치 누름
        int result2 = 0;

        arr1[0] = 1-arr1[0];
        arr1[1] = 1-arr1[1];

        for(int i=1; i<N; i++){
            if(arr1[i-1] != goal_arr[i-1]){     //i-1번째로 비교
                result1++;
                arr1[i-1] = 1-arr1[i-1];
                arr1[i] = 1-arr1[i];
                if(i!=N-1)
                    arr1[i+1] = 1-arr1[i+1];
            }
            if(arr2[i-1] != goal_arr[i-1]){
                result2++;
                arr2[i-1] = 1-arr2[i-1];
                arr2[i] = 1-arr2[i];
                if(i!=N-1)
                    arr2[i+1] = 1-arr2[i+1];
            }
        }
        boolean check1 = false;
        boolean check2 = false;

        String S_arr1 = Arrays.toString(arr1);
        String S_arr2 = Arrays.toString(arr2);
        String S_goal = Arrays.toString(goal_arr);
        if(S_arr1.equals(S_goal))
            check1 = true;
        if(S_arr2.equals(S_goal))
            check2 = true;

        if(check1){
            if(check2){
                System.out.println(Math.min(result1,result2));
            } else{
                System.out.println(result1);
            }
        } else{
            if(check2){
                System.out.println(result2);
            } else{
                System.out.println(-1);
            }
        }
    }
}
