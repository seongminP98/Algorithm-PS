public class StringCompression {
    public static void main(String[] args) {
        String s = "aabbaccc";
        int answer = Integer.MAX_VALUE;
        if(s.length() == 1){
            System.out.println(1);
            System.exit(0);
        }
        for (int i=1; i<=s.length()/2; i++) {
            int check = 1;
            String pre = s.substring(0,i);
            int sum = i;
            for (int j=i; j<s.length(); j+=i) {
                String c = "";
                if(j+i>s.length()){
                    c = s.substring(j);
                } else {
                    c = s.substring(j,j+i);
                }
                if(c.equals(pre)) {
                    check++;
                } else {
                    if(check!=1) {
                        sum+= (int)(Math.log10(check)+1);
                    }
                    sum += c.length();
                    check = 1;
                }
                pre = c;
            }
            if(check!=1) {
                sum += (int)(Math.log10(check)+1);
            }
            answer = Math.min(answer,sum);
        }
        System.out.println("answer = " + answer);
    }
}
/**
 * 문자열 합칠 때 숫자의 길이 잘 생각하기.
 * (int)(Math.log10(check)+1);
 */
/*
class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if(s.length() == 1){
            return 1;
        }
        for (int i=1; i<=s.length()/2; i++) {
            int check = 1;
            String pre = s.substring(0,i);
            int sum = i;
            for (int j=i; j<s.length(); j+=i) {
                String c = "";
                if(j+i>s.length()){
                    c = s.substring(j);
                } else {
                    c = s.substring(j,j+i);
                }
                if(c.equals(pre)) {
                    check++;
                } else {
                    if(check!=1) {
                        sum+= (int)(Math.log10(check)+1);
                    }
                    sum += c.length();
                    check = 1;
                }
                pre = c;
            }
            if(check!=1) {
                sum += (int)(Math.log10(check)+1);
            }
            answer = Math.min(answer,sum);
        }
        return answer;
    }
}
 */
