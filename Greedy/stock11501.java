import java.util.Scanner;

public class stock11501 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long ans[] = new long[t];

        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            long stock[] = new long[n];
            for(int j=0; j<n; j++){
                stock[j] = sc.nextInt();
            }
            long max = 0;
            for(int j=n-1; j>=0; j--){
                if(stock[j]>max){
                    max = stock[j];
                } else{
                    ans[i]+=max-stock[j];
                }
            }
        }
        for( long i : ans) {
            System.out.println(i);
        }
    }
}

