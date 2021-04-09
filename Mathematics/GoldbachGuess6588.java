import java.io.*;

public class GoldbachGuess6588 {
    static boolean primeCheck[] = new boolean[1000001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=2; i<=100000; i++){
            primeCheck[i]=false;
        }
        for(int i=2; i<=1000000; i++){
            if(!primeCheck[i]){
                for(int j=i*2; j<=1000000; j+=i){
                    primeCheck[j]=true; //소수 아님.
                }
            }
        }
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0)
                break;

            int a=0;
            int b=0;
            boolean check=false;
            for(int i=n-3; i>=3; i-=2){
                if(!primeCheck[i] && !primeCheck[n-i]){
                    a = n-i;
                    b = i;
                    check=true;
                    break;
                }
            }
            if(check){
                bw.write(n+" = "+a+" + "+b);
            } else{
                bw.write("Goldbach's conjecture is wrong.");
            }
            bw.write('\n');
            bw.flush();
        }
        bw.close();
    }
}
