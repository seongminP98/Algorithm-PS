import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QuadTree1992 {
    static int N;
    static int[][] arr;
    static String ans = "";
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }
        divide(0,0,N);
        System.out.println(ans);
    }
    static void divide(int row, int col, int n){
        boolean check = false;
        int start = arr[row][col];
        for(int i=row; i<row+n; i++){
            for(int j=col; j<col+n; j++){
                if(start!=arr[i][j])
                    check = true; //자름
            }
        }

        if(check){
            ans+="("; //나누기 시작할 때 괄호 열기
            int c = n/2;
            for(int i=0; i<2; i++){
                for(int j=0; j<2; j++){
                    divide(row+i*c,col+j*c,c);
                }
            }
            ans+=")"; //나누기 끝나면 괄호 닫기
        } else{
            ans+=Integer.toString(arr[row][col]);
        }
    }
}
