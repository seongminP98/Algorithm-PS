import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Flip1439 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int count = 0;

        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)!=s.charAt(i+1))
                count++;
        }
        if(count==1)
            System.out.println(count);
        else
            System.out.println((count+1)/2);
    }
}
