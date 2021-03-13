import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MakePalindrome1213 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        int[] arr = new int[26]; //알파벳 개수
        StringBuffer sb;
        for(int i=0; i<name.length(); i++){
            arr[name.charAt(i)-'A']++;
        }
        int odd=0;
        int mid=-1;
        String rs="";
        String result = "";
        for(int i=0; i<arr.length; i++){
            if(odd>=2)
                break;
            if(arr[i]%2==1){
                odd++;
                mid = i;
            }
            for(int j=0; j<arr[i]/2; j++){
                result += (char)(i+'A');
            }
        }

        sb = new StringBuffer(result);
        rs = sb.reverse().toString();
        if(mid!=-1){
            result += (char)(mid+'A');
        }
        if(odd>=2)
            System.out.println("I'm Sorry Hansoo");
        else{
            result += rs;
            System.out.println(result);
        }
    }
}
