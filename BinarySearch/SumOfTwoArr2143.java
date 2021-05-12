import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SumOfTwoArr2143 {
    static int T;
    static int n,m;
    static int[] arrA;
    static int[] arrB;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        arrA = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        arrB = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Long> sumA = new ArrayList<>();
        ArrayList<Long> sumB = new ArrayList<>();
        for(int i=0; i<n; i++){
            solve(i+1,arrA[i],arrA,sumA);
        }
        for(int i=0; i<m; i++){
            solve(i+1,arrB[i],arrB,sumB);
        }

        Collections.sort(sumA);
        Collections.sort(sumB);

        int l = 0;
        int r = sumB.size()-1;
        long count=0;
        while(l<sumA.size() && r>=0){
            long A = sumA.get(l);
            long B = sumB.get(r);
            long lCnt = 0;
            long rCnt = 0;
            if(A+B == T){
                while(l<sumA.size() && A==sumA.get(l)){
                    lCnt++;
                    l++;
                }
                while(r>=0 && B==sumB.get(r)){
                    rCnt++;
                    r--;
                }
                count += lCnt*rCnt;
            }
            else if(A+B < T){
                l++;
            }
            else if(A+B > T){
                r--;
            }
        }
        System.out.println(count);


    }
    static void solve(int idx, long sum, int[] arr, ArrayList<Long> list){
        list.add(sum);
        if(idx==arr.length)
            return;

        solve(idx+1,sum+arr[idx],arr,list);
    }
}
