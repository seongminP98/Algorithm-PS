import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Matrix1080 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                A[i][j] = s.charAt(j)-'0';
            }
        }
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                B[i][j] = s.charAt(j)-'0';
            }
        }


        int count=0;
        for(int i=0; i<N-2; i++){
            for(int j=0; j<M-2; j++){
                if(A[i][j]!=B[i][j]){
                    A[i][j] = 1 - A[i][j];
                    A[i][j+1]=1-A[i][j+1];
                    A[i][j+2]=1-A[i][j+2];
                    A[i+1][j]=1-A[i+1][j];
                    A[i+1][j+1]=1-A[i+1][j+1];
                    A[i+1][j+2]=1-A[i+1][j+2];
                    A[i+2][j]=1-A[i+2][j];
                    A[i+2][j+1]=1-A[i+2][j+1];
                    A[i+2][j+2]=1-A[i+2][j+2];
                    count++;
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                if(A[i][j]!=B[i][j])
                    count = -1;
            }
        }
        System.out.println(count);
    }
}
