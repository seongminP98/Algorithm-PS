import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class PhoneNumberList5052 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            boolean check = true;
            for(int j=0; j<n; j++){
                arr[j] = br.readLine();
            }
            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });//사전순으로 정렬
            for(int j=1; j<n; j++){//정렬했기 때문에 이전과만 비교
                if(arr[j].startsWith(arr[j-1])){ //startsWith는 앞부분비교, endsWith는 뒷부분 비교
                    check = false;
                    break;
                }
            }
            if(check)
                sb.append("YES").append('\n');
            else
                sb.append("NO").append('\n');
        }
        /*
        시간초과
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for(int j=0; j<n; j++){
                arr[j] = br.readLine();
            }
            String ans = "YES";
            loop: for(int j=0; j<n-1; j++){
                int phone = arr[j].hashCode();
                int len = arr[j].length();
                for(int k=j+1; k<n; k++){
                    if(arr[k].length()>=len && phone == (arr[k].substring(0,len).hashCode())){
                        ans = "NO";
                        break loop;
                    } else if(arr[k].length()<len && arr[j].substring(0,arr[k].length()).hashCode() == arr[k].hashCode()) {
                        ans = "NO";
                        break loop;
                    }
                }
            }
            sb.append(ans).append('\n');
        }
         */
        System.out.println(sb);
    }
}
