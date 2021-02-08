import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GoodCarNum1871 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[n];

        for(int i=0; i<n; i++){
            int num=0;
            String[] car = br.readLine().split("-");
            num+=(car[0].charAt(0)-'A')*(Math.pow(26,2))+(car[0].charAt(1)-'A')*(Math.pow(26,1))+(car[0].charAt(2)-'A')*(Math.pow(26,0));

            if(Math.abs(num-Integer.parseInt(car[1]))<=100)
                check[i]=true;

        }

        for(int i=0; i<check.length; i++){
            if(check[i])
                System.out.println("nice");
            else
                System.out.println("not nice");
        }

    }
}
