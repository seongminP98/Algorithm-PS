import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PadovanSeq9461 {
    static Long arr[] = new Long[101];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        arr[0]=arr[1]=arr[2]=arr[3]=1L;
        arr[4]=arr[5]=2L;

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(padovan(n));
        }
    }

    static long padovan(int n){
        if(arr[n]==null){
            arr[n] = padovan(n-1)+padovan(n-5);
        }
        return arr[n];
    }
}
