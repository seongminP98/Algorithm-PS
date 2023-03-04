public class JumpGame {
    private static boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        int end = 0;
        for (int i = 0; i <= goal; i++) {
            int step = i + nums[i];
            end = Math.max(end, step);
            if (end >= goal) {
                return true;
            }
            if (end == i) {
                return false;
            }
        }
        return false;
    }
}
