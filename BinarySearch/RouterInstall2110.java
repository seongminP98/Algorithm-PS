import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RouterInstall2110 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int left = 1;  //제일 짧은 거리
        int right = arr[N-1]-arr[0]; //제일 긴 거리
        int d = 0;
        int ans = 0;
        while(left<=right){
            int mid = (left+right)/2; //기준
            int start = arr[0]; //처음 집부터 시작
            int cnt = 1;  //처음 집 선택했으니 카운트는 1부터 시작

            for(int i=1; i<N; i++){ //모든 집 탐색
               d = arr[i]-start; //두 집의 거리
                if(mid<=d){ //기준보다 집의 거리가 길어야 공유기 설치
                    cnt++;
                    start = arr[i];
                }
            }
            if(cnt>=C){ //설치한 공유기가 가지고 있는 공유기 개수보다 많으면 기준 거리 늘림.
                ans = mid;
                left = mid+1;
            } else{
                right = mid-1;
            }

        }
        System.out.println(ans);
    }
}
