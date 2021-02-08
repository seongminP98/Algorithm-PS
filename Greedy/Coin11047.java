
import java.util.Scanner;

public class Coin11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] A = new int[n];
		for(int i=0; i<n; i++)
			A[i]=sc.nextInt();
		
		int i;
		int count=0;
		
		while(k!=0) {
			for(i=0; i<n; i++) {
				if(k<A[i])
					break;
			}
			k-=A[i-1];
			count++;
		}
		
		System.out.println(count);
	}
}
