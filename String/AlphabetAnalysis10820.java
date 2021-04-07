import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AlphabetAnalysis10820 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while((str=br.readLine())!=null){
            int sl=0;
            int cl=0;
            int num=0;
            int blank=0;
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j)>='A' && str.charAt(j)<='Z')
                    cl++;
                else if(str.charAt(j)>='a' && str.charAt(j)<='z')
                    sl++;
                else if(str.charAt(j)==' ')
                    blank++;
                else if(str.charAt(j)>='0' && str.charAt(j)<='9')
                    num++;
            }
            System.out.println(sl+" "+cl+" "+num+" "+blank);
        }
    }
}
