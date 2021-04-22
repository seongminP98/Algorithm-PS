import java.util.*;
public class PracticeTest {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(s.solution(arr)));
    }
}

class Solution {
    public int[] solution(int[] answers) {
        int[] result = new int[4];
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        for(int i=0; i<answers.length; i++){
            if(answers[i] == arr1[i%5])
                result[1]++;

            if(answers[i] == arr2[i%8])
                result[2]++;

            if(answers[i] == arr3[i%10])
                result[3]++;
        }
        int max = result[1];
        for(int i=2; i<result.length; i++){
            if(max<result[i])
                max = result[i];
        }

        ArrayList<Integer> al = new ArrayList<>();
        for(int i=1; i<result.length; i++){
            if(max==result[i])
                al.add(i);
        }
        int[] answer = new int[al.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = al.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }
}