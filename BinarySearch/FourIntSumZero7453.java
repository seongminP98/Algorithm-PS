import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FourIntSumZero7453 {
    static int[][] arr;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][4];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] sumAB = new int[n*n];
        int[] sumCD = new int[n*n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sumAB[n*i+j] = arr[i][0]+arr[j][1];
                sumCD[n*i+j] = arr[i][2]+arr[j][3];
            }
        }

        Arrays.sort(sumAB);
        Arrays.sort(sumCD);

        int l = 0;
        int r = sumCD.length-1;
        long count = 0;
        while(l<sumAB.length && r>=0){
            int lSum = sumAB[l];
            int rSum = sumCD[r];
            long lCnt = 0;
            long rCnt = 0;
            if(lSum+rSum == 0){
                while(l<sumAB.length && sumAB[l]==lSum){
                    l++;
                    lCnt++;
                }
                while(r>=0 && sumCD[r]==rSum){
                    r--;
                    rCnt++;
                }
                count += lCnt*rCnt;
            }
            else if(lSum+rSum<0){
                l++;
            }
            else if(lSum+rSum>0){
                r--;
            }
        }
        System.out.println(count);
    }
}
