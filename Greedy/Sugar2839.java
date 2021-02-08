package greedy;
import java.util.Scanner;
public class Sugar2839 {
	public static void main(String[] args) {
		int input;
		Scanner sc = new Scanner(System.in);
		input = sc.nextInt();
		
		if(input==4 || input==7)
			System.out.println(-1);
		else if(input%5 == 0)
			System.out.println(input/5);
		else if(input%5 == 1 || input%5 == 3)
			System.out.println(input/5+1);
		else if(input%5 == 2 || input%5 == 4)
			System.out.println(input/5+2);
	}
}
