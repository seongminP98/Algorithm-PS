import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SumOfSubSeq1208 {
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        dfs(0,N/2,0,left);
        dfs(N/2,N,0,right);
        Collections.sort(left);
        Collections.sort(right);

        int l = 0;
        int r = right.size()-1;
        long count = 0;
        while(l<left.size() && r>=0){
            int lSum = left.get(l);
            int rSum = right.get(r);
            long lCnt = 0;
            long rCnt = 0;
            if(lSum+rSum == S){
                while(l<left.size() && left.get(l)==lSum){ //left안에 lSum과 같은 수가 몇개 있는지 확인.
                    l++;
                    lCnt++;
                }
                while(r>=0 && right.get(r)==rSum){
                    r--;
                    rCnt++;
                }
                count += rCnt*lCnt;
            }
            else if(lSum+rSum<S){
                l++;
            }
            else if(lSum+rSum>S){
                r--;
            }
        }
        if(S==0)
            count--;

        System.out.println(count);
    }
    static void dfs(int start, int end, int sum, ArrayList<Integer> list){ //기존 수들을 반으로 나눠서 부분수열의 합을 구함.
        if(start == end){
            list.add(sum);
            return;
        }
        dfs(start+1,end,sum+arr[start],list); //현재 값 더함.
        dfs(start+1,end,sum,list); //현재 값 더하지 않음.

    }
}
