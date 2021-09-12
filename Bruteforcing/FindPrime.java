import java.util.HashSet;
import java.util.Set;

public class FindPrime {
    static boolean[] visited;
    static String[] output;
    static int answer;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        String number = "011";
        answer = 0;

        String[] arr = new String[number.length()];
        for(int i=0; i<number.length(); i++) {
            arr[i] = String.valueOf(number.charAt(i));
        }
        visited = new boolean[arr.length];
        output = new String[arr.length];

        for(int i=1; i<arr.length+1; i++) {
            permutation(arr, output, visited, 0, arr.length, i);
        }
        for (Integer integer : set) {
            if(isPrime(integer)){
                answer++;
            }
        }
        System.out.println(answer);

    }

    public static boolean isPrime(int num) {
        if(num<=1) {
            return false;
        }
        for(int i=2; (i*i)<=num; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void permutation(String[] arr, String[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            StringBuilder num = new StringBuilder();
            for(int i=0; i<r; i++) {
                num.append(output[i]);
            }
            int checkNum = Integer.parseInt(num.toString());
            set.add(checkNum);
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth+1, n, r);
                visited[i] = false;
            }
        }
    }

}
