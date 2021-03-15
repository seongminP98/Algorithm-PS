import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IOIOI5525 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int count=0;

        int result = 0;
        for(int i=0; i<M-2; i++){
            if(S.charAt(i)=='I' && S.charAt(i+1)=='O' && S.charAt(i+2)=='I'){
                count++;
                if(count == N){
                    result++;
                    count--; //첫 IO빼고 다음 IOI부터 시작.
                }
                i++;
            } else{
                count = 0;
            }
        }
        System.out.println(result);
    }
}
