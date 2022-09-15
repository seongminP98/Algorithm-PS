public class FindPrimeInKNum {
    public static void main(String[] args) {
        int n = 110011;
        int k = 10;
        System.out.println(solution(n, k));
    }

    private static int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, (n % k));
            n /= k;
        }

        int answer = 0;

        String[] numbers = sb.toString().split("0");
        for (String number : numbers) {
            if (!number.equals("")) {
                if (isPrime(Long.parseLong(number)))
                    answer++;
            }
        }

        return answer;
    }

    private static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        for (long i = 2; (i * i) <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
