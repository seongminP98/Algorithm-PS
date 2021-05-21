import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ProfessorFinalE20126 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); //시험시간
        int S = Integer.parseInt(st.nextToken()); //강의실 사용가능한 시간
        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });

        int ans = 0;
        boolean check = true;
        if(arr[0][0]>=M){
            check = false;
        }
        if(check){
            for(int i=0; i<N-1; i++){
                if(arr[i+1][0]-(arr[i][1]+arr[i][0])>=M){
                    ans = arr[i][1]+arr[i][0];
                    break;
                }
            }
        }
        if(check){
            if(ans==0){
                if(S-(arr[N-1][0]+arr[N-1][1])>=M)
                    System.out.println(arr[N-1][1]+arr[N-1][0]);
                else
                    System.out.println(-1);
            } else{
                System.out.println(ans);
            }
        } else{
            System.out.println(ans);
        }

    }
}
