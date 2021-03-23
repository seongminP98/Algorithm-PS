import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Library1461 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            if(n>0){
                arr1.add(n);
            } else{
                arr2.add(n);
            }
        }
        Collections.sort(arr1,Collections.reverseOrder());
        Collections.sort(arr2);
        int result = 0;
        boolean last = true;
        while(arr1.size()!=0 || arr2.size()!=0){
            if(last){
                if(arr1.size()==0){
                    result+=Math.abs(arr2.get(0));
                    int k=M;
                    if(M>arr2.size()){
                        k = arr2.size();
                    }
                    for(int i=0; i<k; i++) {
                        Math.abs(arr2.remove(0));
                    }
                } else if(arr2.size()==0){
                    result+=arr1.get(0);
                    int k=M;
                    if(M>arr1.size()){
                        k = arr1.size();
                    }
                    for(int i=0; i<k; i++) {
                        arr1.remove(0);
                    }
                } else{
                    if(arr1.get(0)>Math.abs(arr2.get(0))){
                        result += arr1.get(0);
                        int k=M;
                        if(M>arr1.size()){
                            k = arr1.size();
                        }
                        for(int i=0; i<k; i++) {
                            arr1.remove(0);
                        }
                    } else{
                        result += Math.abs(arr2.get(0));
                        int k=M;
                        if(M>arr2.size()){
                            k = arr2.size();
                        }
                        for(int i=0; i<k; i++) {
                            arr2.remove(0);
                        }
                    }
                }
                last = false;
            }
            if(arr1.size()!=0){
                result += (2*arr1.get(0));
                int k = M;
                if(M>arr1.size())
                    k=arr1.size();

                for(int i=0; i<k; i++){
                    arr1.remove(0);
                }
            }
            if(arr2.size()!=0){
                result += Math.abs(2*arr2.get(0));
                int k = M;
                if(M>arr2.size())
                    k=arr2.size();

                for(int i=0; i<k; i++){
                    arr2.remove(0);
                }
            }

        }
        System.out.println(result);

    }
}
