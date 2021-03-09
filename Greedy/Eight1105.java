import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Eight1105 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String L = st.nextToken();
        String R = st.nextToken();
        int result = 0;
        if(L.length() == R.length()){ //길이가 다르면 무조건 0
            for(int i=0; i<L.length(); i++){
                if(L.charAt(i)==R.charAt(i)){
                    if(L.charAt(i)=='8') //앞에서부터 L,R이 8로 같으면 1증가, 8이 아닌 다른 수로 같으면 다음 수 확인.
                        result++;
                } else{ //L,R 을 앞에서부터 비교했을 때 다른 수가 나오면 종료.
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
