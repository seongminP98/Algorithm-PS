import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class YonseiTOTO12018 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            if(P<L){ //인원 미달인 경우 1점만 사용
                st = new StringTokenizer(br.readLine());
                list.add(1);
            } else{
                Integer arr[] = new Integer[P];
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<P; j++){
                    arr[j] = Integer.parseInt(st.nextToken());
                }
                Arrays.sort(arr,Collections.reverseOrder()); //arr 내림차순 정렬
                list.add(arr[L-1]);
            }
        }
        Collections.sort(list); //list 오름차순 정렬
        int count=0;
        for(Integer i : list){
            if(m-i>=0){
                count++;
                m-=i;
            } else{
                break;
            }
        }
        System.out.println(count);
    }
}
