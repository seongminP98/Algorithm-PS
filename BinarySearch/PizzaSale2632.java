import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class PizzaSale2632 {
    static int[] A;
    static int[] B;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        A = new int[m];
        B = new int[n];
        for(int i=0; i<m; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<n; i++){
            B[i] = Integer.parseInt(br.readLine());
        }
        ArrayList<Integer> sumA = new ArrayList<>();
        ArrayList<Integer> sumB = new ArrayList<>();

        boolean[] check;
        for(int i=0; i<m; i++){
            check = new boolean[m];
            check[i] = true;  //시작점
            dfs(i+1,i,A,A[i],check,sumA); //시작점은 무조건 담고 시작.
        }
        //피자를 한바퀴돌면서 각 조각을 포함하면서 연속적으로 있는 피자조각의 누적합을 구함.
        for(int i=0; i<n; i++){
            check = new boolean[n];
            check[i] = true;
            dfs(i+1,i,B,B[i],check,sumB);
        }
        sumA.add(0);//A피자에서 한조각도 안담았을 때.
        sumB.add(0);
        for(int i : sumA){
            System.out.print(i+" ");
        }
        System.out.println();
        Collections.sort(sumA);
        Collections.sort(sumB);

        int l = 0;
        int r = sumB.size()-1;
        long count = 0;
        while(l<sumA.size() && r>=0){
            int lSum = sumA.get(l);
            int rSum = sumB.get(r);
            int lCnt = 0;
            int rCnt = 0;
            if(lSum+rSum==size){
                while(l<sumA.size() && sumA.get(l)==lSum){
                    lCnt++;
                    l++;
                }
                while(r>=0 && sumB.get(r)==rSum){
                    rCnt++;
                    r--;
                }
                count += lCnt*rCnt;
            }
            else if(lSum+rSum<size){
                l++;
            }
            else if(lSum+rSum>size){
                r--;
            }
        }
        System.out.println(count);

    }
    static void dfs(int idx, int start,int[] arr, int sum,boolean[] check, ArrayList<Integer> list){
        if(idx==arr.length) //마지막 피자조각을 담았고 첫번째 피자조각으로 감.
            idx=0;

        list.add(sum);
        if(!check[idx] && idx!=start-1){ //다음번 피자를 안담았고 마지막피자가 아닌경우. (모든 피자 조각을 다 담는 경우는 시작할 때 1번만 구함)
            check[idx]=true;
            dfs(idx+1,start,arr,sum+arr[idx],check,list);
        }
    }
}
