public class MakeTwoQSumEqual {
    public static void main(String[] args) {
//        int[] q1 = {1, 2, 1, 2};
//        int[] q1 = {3, 2, 7, 2};
//        int[] q1 = {1, 3, 2, 7};
//        int[] q1 = {2, 7, 2, 3};
        int[] q1 = {1,1,1,1};
//        int[] q1 = {1, 1};
//        int[] q2 = {1, 10, 1, 2};
//        int[] q2 = {4, 6, 5, 1};
//        int[] q2 = {2, 5, 4, 6};
//        int[] q2 = {1, 1, 1, 1};
        int[] q2 = {1,1,7,1};
//        int[] q2 = {1, 5};
        System.out.println(solution(q1, q2));
    }

    // TC 2, 9, 14, 29
    private static int solution(int[] queue1, int[] queue2) {
        long sum = queue1[0];
        int len = queue1.length;

        long[] arr = new long[len + len];
        arr[0] = queue1[0];
        for (int i = 1; i < len; i++) {
            sum += queue1[i];
            arr[i] += arr[i - 1] + queue1[i];
        }
        for (int i = 0; i < len; i++) {
            sum += queue2[i];
            arr[i + len] += arr[i + len - 1] + queue2[i];
        }
        for (long l : arr) {
            System.out.print(l + " ");
        }

        if (sum % 2 == 1) {
            return -1;
        }
        long goal = sum / 2;
        int left = 0;
        int right = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= goal) {
                right = i;
                if (arr[i] == goal) {
                    flag = true;
                }
                break;
            }
        }
        System.out.println();
        if (flag) {
            System.out.println("right = " + right);
            if (right >= len) {
                return right - len + 1;
            } else {
                return right + len + 1;
            }
        }
//        if (arr[right] == goal) {
//            left = right;
//        } else {
        while (true) {
            if (right >= arr.length) {
                return -1;
            }
            if (arr[right] - arr[left] == goal) {
                break;
            }
            if (left > right) {

                return -1;
            }
            if (arr[right] - arr[left] > goal) {
                left++;
            } else {
                right++;
            }
        }
//        }
        System.out.println();
        System.out.println("right = " + right);
        System.out.println("left = " + left);

        left++;
        right++;
        int answer = 0;
        answer += Math.min(len, left);
        if (left > len) {
            answer += left - len;
        }
//        answer += left;
        if (right >= len) {
            answer += right - len;
        } else {
            answer += right + len;
        }
        return answer;
    }
}
