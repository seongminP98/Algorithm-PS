import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HambugerDistribution19941 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char arr[] = new char[N+K]; //그냥 char[N]했다가 런타임 에러 (ArrayIndexOutOfBounds)가 떠서 바꿨음.
        String str = br.readLine();
        for(int i=0; i<str.length(); i++){
            arr[i] = str.charAt(i);
        }

        int sum = 0;
        for(int i=0; i<arr.length-K; i++){
            if(arr[i]=='P'){
                if(i<K){
                    for(int j=0; j<=i+K; j++){
                        if(arr[j]=='\0')
                            break;
                        if(arr[j]=='H'){
                            arr[j]='X';
                            sum++;
                            break;
                        }
                    }
                } else{
                    for(int j=i-K; j<=i+K; j++){
                        if(arr[j]=='\0')
                            break;
                        if(arr[j]=='H'){
                            arr[j]='X';
                            sum++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
