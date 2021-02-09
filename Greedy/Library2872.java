import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Library2872 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] book = new int[n];
        for(int i=0; i<n; i++){
            book[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        int start = 1;
        if(n<=1)
            System.out.println(n);
        else{
            if(start < book[0]){
                start = book[0];
                sum+=book[0]-1;  //시작이 1이 아니면 시작보다 작은 수들을 앞으로 보내야 하니까.
            }
            for(int i=1; i<n; i++){
                if(start+1 < book[i]){ //start다음에는 +1한 수가 와야한다. 더 큰수가 오면 그 차이만큼 앞으로 보내야 한다.
                    sum+=book[i]-start;
                    start = book[i];
                }
                if(start+1 == book[i]) //올바른 자리에 있음.
                    start = book[i];
            }
        }
        System.out.println(sum);

    }
}
