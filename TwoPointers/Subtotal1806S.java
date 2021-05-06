import java.util.Scanner;

public class Subtotal1806S {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] data = new int[N + 1];
        for (int i = 0; i < N; i++) {
            data[i] = sc.nextInt();
        }
        int ans = Integer.MAX_VALUE;
        int s = 0;
        int e = 0;
        int sum=0;
        while (e <= N && s <= N) {
            System.out.println("s:"+s+" e:"+e);
            if (sum >= S && ans > e - s)
                ans = e - s;

            if (sum < S)
                sum += data[e++]; //작으면 end 포인터를 한칸 증가
            else
                sum -= data[s++]; //크면 start 포인터를 한칸 증가
        }
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}