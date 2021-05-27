import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class SerialNumber1431 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length())
                    return 1;
                else if(o1.length()<o2.length())
                    return -1;
                else{
                    int sum1 = 0;
                    int sum2 = 0;
                    for(int i=0; i<o1.length(); i++){
                        if(o1.charAt(i)-'0'>=0 && o1.charAt(i)-'0'<=9){
                            sum1+=o1.charAt(i)-'0';
                        }
                        if(o2.charAt(i)-'0'>=0 && o2.charAt(i)-'0'<=9){
                            sum2+=o2.charAt(i)-'0';
                        }
                    }
                    if(sum1>sum2){
                        return 1;
                    } else if(sum1<sum2){
                        return -1;
                    } else{
                        return o1.compareTo(o2);
                    }
                }

            }
        });
        for(int i=0; i<N; i++){
            System.out.println(arr[i]);
        }
    }
}
