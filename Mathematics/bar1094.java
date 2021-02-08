import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bar1094 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int n = 64;
        int check=0;
        while(true){
            if(x==n){
                check++;
                break;
            }

            else{
                n/=2;
            }
            if(n<x){
                x-=n;
                check++;
            }
        }
        System.out.println(check);
    }
}
