import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lotto6603 {
    static int k;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            if (s.charAt(0) == '0')
                break;

            k = Integer.parseInt(st.nextToken());

            arr = new int[k];
            visited = new boolean[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            combination(0,k,6);
            System.out.println();
        }
    }
    static void combination(int start, int n, int r){//조합 n개중 r개 선택
        if(r==0){
            for(int i=0; i<k; i++){
                if(visited[i])
                    System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=start; i<n; i++){
            visited[i] = true;
            combination(i+1,n,r-1);
            visited[i] = false;
        }
    }
}
