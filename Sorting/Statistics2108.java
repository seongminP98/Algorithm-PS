import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Statistics2108 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int range = arr[n-1]-arr[0];

        int avg = (int)Math.round(Arrays.stream(arr).average().getAsDouble());

        int median = arr[n/2];

        int mode=0;
        int[] count = new int[8001];
        int max = 0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>(); //최빈값이 여러 개 있을 떄 사용
        for(int i=0; i<arr.length; i++){
            if(arr[i]<0){
                count[Math.abs(arr[i])+4000]++;
            } else
                count[arr[i]]++;
        }
        for(int i=0; i<count.length; i++){
            if(count[i]>max){
                max = count[i];
                mode = i;
            }
        }
        for(int i=0; i<count.length; i++){
            if(count[i]==max){
                if(i>4000){//음수인 경우
                    arrayList.add(-(i-4000));
                }else{
                    arrayList.add(i);
                }
            }
        }
        Collections.sort(arrayList); //arrayList정렬해서 2번째로 작은 값 찾기
        if(arrayList.size()>1){
            mode = arrayList.get(1); //최빈값들이 2개 이상 존재
        } else{
            mode = arrayList.get(0);
        }

        System.out.println(avg);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}
