import java.util.*;
class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int n=0; n<commands.length; n++){
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];

            int cut = j-i+1;
            int[] newArr = new int[cut];
            for(int m=0; m<cut; m++){
                newArr[m] = array[i-1+m];
            }
            Arrays.sort(newArr);

            answer[n] = newArr[k-1];
        }

        return answer;
    }
    public static void main(String[] args){
        KthNumber sol = new KthNumber();
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        System.out.println(Arrays.toString(sol.solution(array,commands)));
    }
}