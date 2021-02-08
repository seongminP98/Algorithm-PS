package greedy;

import java.util.Scanner;

public class ATM11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int[] p= new int[n];
		for(int i=0; i<n; i++) {
			p[i]=sc.nextInt();
		}
		int temp;
		for(int i=1; i<p.length+1; i++) {
			for(int j=0; j<p.length-i; j++) {
				if(p[j]>p[j+1]) {
					temp = p[j];
					p[j]=p[j+1];
					p[j+1] = temp;
				}
			}
		}
		
		int sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<i+1; j++) {
				sum+=p[j];
			}
		}
		
		System.out.println(sum);
	}
}
