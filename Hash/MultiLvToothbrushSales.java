import java.util.HashMap;

public class MultiLvToothbrushSales {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        int[] answer = new int[enroll.length];
        HashMap<String,Integer> result = new HashMap<>();
        HashMap<String,String> map = new HashMap<>(); //자신의 추천인.
        for (String s : enroll) { //결과 0으로 초기화.
            result.put(s, 0);
        }
        for (int i=0; i<enroll.length; i++) { //추천인 초기화.
            map.put(enroll[i], referral[i]);
        }

        for (int i=0; i<seller.length; i++) {
            String person = seller[i];
            int money = amount[i]*100; //남은 수익금.
            int income; //나한테 들어오는 수입.
            while(!map.get(person).equals("-")) {
                income = money-money/10;
                if(income==0) { //enroll 길이가 최대 10000이므로 계속 올라가면 시간초과 나는 케이스 있음. 수익금이 없으면 종료.
                    break;
                }
                money = money-income;
                result.put(person, result.get(person)+income);
                person = map.get(person);
                if(map.get(person).equals("-")){
                    break;
                }
            }
            income = money-money/10;
            result.put(person, result.get(person)+income);

        }

        for(int i=0; i<answer.length; i++) {
            answer[i] = result.get(enroll[i]);
        }
        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }
}

/**
 * 처음에 3개의 테스트케이스에서 시간초과남.
 * if(income==0) {
 *     break;
 * }
 * 추가해서 수익금이 없으면 더이상 위로 올라가지 못하게 함으로써 해결.
 */

/*
import java.util.HashMap;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String,Integer> result = new HashMap<>();
        HashMap<String,String> map = new HashMap<>();
        for (String s : enroll) {
            result.put(s, 0);
        }
        for (int i=0; i<enroll.length; i++) {
            map.put(enroll[i], referral[i]);
        }



        for (int i=0; i<seller.length; i++) {
            String person = seller[i];
            int money = amount[i]*100;
            int income = 0;
            while(!map.get(person).equals("-")) {
                income = money-money/10;
                if(income==0) {
                    break;
                }
                money = money-income;
                result.put(person, result.get(person)+income);
                person = map.get(person);
            }
            income = money-money/10;
            result.put(person, result.get(person)+income);
        }

        for(int i=0; i<answer.length; i++) {
            answer[i] = result.get(enroll[i]);
        }
        return answer;
    }
}
*/
