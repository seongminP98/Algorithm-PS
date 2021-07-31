import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CandyGame3085 {
    static int N;
    static char[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int result = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(j+1<N) {
                    char temp = arr[i][j];
                    arr[i][j] = arr[i][j+1];
                    arr[i][j+1] = temp;
                    int ans = check();
                    result = Math.max(result,ans);
                    temp = arr[i][j];
                    arr[i][j] = arr[i][j+1];
                    arr[i][j+1] = temp;
                }
                if(i+1<N) {
                    char temp = arr[i][j];
                    arr[i][j] = arr[i+1][j];
                    arr[i+1][j] = temp;
                    int ans = check();
                    result = Math.max(result,ans);
                    temp = arr[i][j];
                    arr[i][j] = arr[i+1][j];
                    arr[i+1][j] = temp;
                }
            }
        }
        System.out.println(result);
    }
    static int check() {
        int ans = 1;
        for(int i=0; i<N; i++) {
            int count = 1;
            for(int j=1; j<N; j++) {
                if(arr[i][j] == arr[i][j-1]){
                    count++;
                }else{
                    count=1;
                }
                ans = Math.max(ans, count);
            }
            count = 1;
            for(int j=1; j<N; j++) {
                if(arr[j][i] == arr[j-1][i]) {
                    count++;
                }else{
                    count=1;
                }
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}
