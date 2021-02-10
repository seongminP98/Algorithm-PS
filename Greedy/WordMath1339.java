import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class WordMath1339 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        int[] check = new int[26];
        for(int i=0; i<check.length; i++){
            check[i] = 0;
        }

        for(int i=0; i<n; i++){
            words[i]=br.readLine();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<words[i].length(); j++){
                check[words[i].charAt(j)-65] += Math.pow(10,words[i].length()-j-1);
            } //자릿수를 찾아 저장.
        }

        Integer[] arr = Arrays.stream(check).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder()); //자릿수 내림차순으로 정렬.

        int k=0;
        int max=9;
        int ans = 0;

        while(arr[k] > 0){
            arr[k] *= max;
            max--;
            ans+=arr[k];
            k++;
        }
        System.out.println(ans);
    }
}
