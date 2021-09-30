public class DifferentBits {
    public static void main(String[] args) {
        long[] numbers = {2,7};
        long[] answer = new long[numbers.length];


        for (int i=0; i<numbers.length; i++) {
            String binary = "0" + Long.toBinaryString(numbers[i]);
            StringBuilder stringBuilder = new StringBuilder(binary);
            int index = binary.length() - 1;
            while (true) {
                if(stringBuilder.charAt(index) == '0') {
                    stringBuilder.setCharAt(index, '1');
                    break;
                } else {
                    index--;
                }
            }
            for(int j=index+1; j<binary.length(); j++) {
                if(stringBuilder.charAt(j) == '1') {
                    stringBuilder.setCharAt(j,'0');
                    break;
                }
            }
            answer[i] = Long.parseLong(String.valueOf(stringBuilder),2);
        }

        for (long l : answer) {
            System.out.println("l = " + l);
        }
    }
}
/*
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];


        for (int i=0; i<numbers.length; i++) {
            String binary = "0" + Long.toBinaryString(numbers[i]);
            StringBuilder stringBuilder = new StringBuilder(binary);
            int index = binary.length() - 1;
            while (true) {
                if(stringBuilder.charAt(index) == '0') {
                    stringBuilder.setCharAt(index, '1');
                    break;
                } else {
                    index--;
                }
            }
            for(int j=index+1; j<binary.length(); j++) {
                if(stringBuilder.charAt(j) == '1') {
                    stringBuilder.setCharAt(j,'0');
                    break;
                }
            }
            answer[i] = Long.parseLong(String.valueOf(stringBuilder),2);
        }
        return answer;
    }
}
 */