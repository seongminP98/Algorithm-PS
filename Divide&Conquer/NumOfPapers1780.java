import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumOfPapers1780 {
    static int[] ans = new int[3];
    static int N;
    static int arr[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cut(0,0,N);
        StringBuilder sb = new StringBuilder();
        for(int i : ans){
            sb.append(i);
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void cut(int row, int col, int n){
        int init = arr[row][col];
        boolean check = false;
        for(int i=row; i<row+n; i++){
            for(int j=col; j<col+n; j++){
                if(init!=arr[i][j]){
                    check = true; //잘라야함
                    break;
                }
            }
        }

        if(check){
            int c = n/3;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    cut(row+i*c,col+j*c,c);
                }
            }
        } else{
            ans[arr[row][col]+1]++; // -1은 ans[0]에 0은 ans[1]에 1은 ans[2]에 저장
        }
    }
}
