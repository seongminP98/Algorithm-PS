import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Change5585 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000 - Integer.parseInt(br.readLine());
        int count=0;
        if(n/500==1){
            n-=500;
            count++;
        }

        if(n/100>0){
            count+=(n/100);
            n=n%100;
        }

        if(n/50>0){
            count+=(n/50);
            n=n%50;
        }

        if(n/10>0){
            count+=(n/10);
            n=n%10;
        }

        if(n/5>0){
            count+=(n/5);
            n=n%5;
        }

        if(n>0){
            count+=n;
        }
        System.out.println(count);
    }
}
