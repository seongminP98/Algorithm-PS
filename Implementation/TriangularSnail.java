import java.util.ArrayList;
import java.util.List;

public class TriangularSnail {
    public static void main(String[] args) {
        int n = 5;
        int max = (n*(n+1))/2;
        int[] answer = new int[max];
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new int[i+1]);
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                list.get(i)[j] = -1;
            }
        }

        int value = 1;
        int i = 0, j = 0;

        while(value<max) {
            while(i+1<n && value<max && list.get(i+1)[j]<0) {
                list.get(++i)[j] = ++value;
            }
            while(j+1<list.get(i).length && value<max && list.get(i)[j+1]<0) {
                list.get(i)[++j] = ++value;
            }
            while(i-1>0 && j-1>0 && value<max && list.get(i-1)[j-1]<0) {
                list.get(--i)[--j] = ++value;
            }
        }

        int index = 0;
        for(i=0; i<list.size(); i++) {
            for(j=0; j<list.get(i).length; j++) {
                answer[index++] = list.get(i)[j];
            }
        }
        answer[0] = 1;
        for (int i1 : answer) {
            System.out.print(i1+" ");
        }


    }
}
/*
import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int n) {
        int max = (n*(n+1))/2;
        int[] answer = new int[max];
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new int[i+1]);
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                list.get(i)[j] = -1;
            }
        }

        int value = 1;
        int i = 0, j = 0;

        while(value<max) {
            while(i+1<n && value<max && list.get(i+1)[j]<0) {
                list.get(++i)[j] = ++value;
            }
            while(j+1<list.get(i).length && value<max && list.get(i)[j+1]<0) {
                list.get(i)[++j] = ++value;
            }
            while(i-1>0 && j-1>0 && value<max && list.get(i-1)[j-1]<0) {
                list.get(--i)[--j] = ++value;
            }
        }

        int index = 0;
        for(i=0; i<list.size(); i++) {
            for(j=0; j<list.get(i).length; j++) {
                answer[index++] = list.get(i)[j];
            }
        }
        answer[0] = 1;
        return answer;
    }
}
 */