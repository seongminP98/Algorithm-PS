import java.util.ArrayList;
import java.util.List;

public class CraneDollGame {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int answer = 0;

        List<Integer> list = new ArrayList<>();

        for (int move : moves) {
            for (int i=0; i<board.length; i++) {
                if(board[i][move-1] != 0) {
                    list.add(board[i][move-1]);
                    board[i][move-1] = 0;
                    break;
                }
            }
            if(list.size()>=2) {
                if(list.get(list.size() - 1).equals(list.get(list.size() - 2))) {
                    list.remove(list.size()-1);
                    list.remove(list.size()-1);
                    answer+=2;
                }
            }
        }
        System.out.println("answer = " + answer);
    }
}
/*
import java.util.ArrayList;
import java.util.List;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for (int move : moves) {
            for (int i=0; i<board.length; i++) {
                if(board[i][move-1] != 0) {
                    list.add(board[i][move-1]);
                    board[i][move-1] = 0;
                    break;
                }
            }
            if(list.size()>=2) {
                if(list.get(list.size() - 1).equals(list.get(list.size() - 2))) {
                    list.remove(list.size()-1);
                    list.remove(list.size()-1);
                    answer+=2;
                }
            }
        }
        return answer;
    }
}
 */