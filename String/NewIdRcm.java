public class NewIdRcm {
    public static void main(String[] args) {
        String new_id = "123_.def";

        String answer = new_id.toLowerCase();

        answer = answer.replaceAll("[^a-z0-9-_.]","");

        answer = answer.replaceAll("[.]{2,}",".");

        answer = answer.replaceAll("^[.]|[.]$","");

        if(answer.length()==0) {
            answer ="a";
        }

        if(answer.length()>15) {
            answer = answer.substring(0,15);
            answer = answer.replaceAll("[.]$","");
        }

        if(answer.length()<3) {
            while(answer.length()<3) {
                answer += answer.charAt(answer.length()-1);
            }
        }
        System.out.println("answer = " + answer);

    }
}
/*
class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();

        answer = answer.replaceAll("[^a-z0-9-_.]","");

        answer = answer.replaceAll("[.]{2,}",".");

        answer = answer.replaceAll("^[.]|[.]$","");

        if(answer.length()==0) {
            answer ="a";
        }

        if(answer.length()>15) {
            answer = answer.substring(0,15);
            answer = answer.replaceAll("[.]$","");
        }

        if(answer.length()<3) {
            while(answer.length()<3) {
                answer += answer.charAt(answer.length()-1);
            }
        }
        return answer;
    }
}
 */
