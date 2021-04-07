import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ROT1311655 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                if (str.charAt(i) + 13 > 'z')
                    sb.append((char)(str.charAt(i) - 13));
                else
                    sb.append((char)(str.charAt(i) + 13));
            } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                if (str.charAt(i) + 13 > 'Z')
                    sb.append((char)(str.charAt(i) - 13));
                else
                    sb.append((char)(str.charAt(i) + 13));
            } else
                sb.append(str.charAt(i));
        }

        System.out.print(sb);
    }
}
