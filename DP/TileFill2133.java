import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TileFill2133 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int d[] = new int[N+1];
        d[0]=1;

        for(int i=2; i<N+1; i+=2){
            d[i]=d[i-2]*3;
            for(int j=i-4; j>=0; j-=2){
                d[i] += d[j]*2;
            }
        }
        System.out.println(d[N]);
    }
}
//N=4일때부터 짝수일 때 마다 특수한 경우가 2개씩 늘어남. N=2일때 결과는 3, N=4일때 결과는 11
//그래서 N=6일때를 생각해보면 (3*4)(3*2)인 경우 , (3*2)(3*4)인 경우(앞에것과 중복인 것 제외, 즉 특수한 경우만 생각)
// , 특수한 경우 2가지 를 생각
//따라서 d[n] = 3*d[n-2] + 2*d[n-4] + 2*d[n-6] ...