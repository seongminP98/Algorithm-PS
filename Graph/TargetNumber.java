public class TargetNumber {
    static int[] numbers;
    static int target;
    public static void main(String[] args) throws Exception{
        numbers = new int[]{1,1,1,1,1};
        target = 3;
        int ans = 0;
        ans = solve(0,0);
        System.out.println(ans);

    }
    static int solve(int depth, int sum) {
        if(depth == numbers.length){
            if(sum==target){
                return 1;
            } else{
                return 0;
            }
        }

        int result = 0;
        result += solve(depth+1, sum+numbers[depth]);
        result += solve(depth+1, sum-numbers[depth]);

        return result;
    }
}
