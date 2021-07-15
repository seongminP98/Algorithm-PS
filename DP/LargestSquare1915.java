import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LargestSquare1915 {
    static int n,m;
    static int arr[][];
    static int d[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        d = new int[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }


        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==0 || i==0 || j==0){
                    d[i][j]=arr[i][j];
                }else{
                    d[i][j] = Math.min(Math.min(d[i-1][j],d[i-1][j-1]),d[i][j-1])+1;
                }
                ans = Math.max(ans,d[i][j]);
            }
        }
        System.out.println(ans*ans);
    }
}
