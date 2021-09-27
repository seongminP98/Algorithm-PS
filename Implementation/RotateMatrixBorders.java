
public class RotateMatrixBorders {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        int[][] arr = new int[rows+1][columns+1];
        int[][] arr2 = new int[rows+1][columns+1];
        int k = 1;

        for(int i=1; i<arr.length; i++) {
            for(int j=1; j<arr[i].length; j++) {
                arr[i][j] = arr2[i][j] = k++;
            }
        }
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            int min = Integer.MAX_VALUE;

            for(int j=queries[i][1]; j<queries[i][3]; j++) {
                arr2[queries[i][0]][j+1] = arr[queries[i][0]][j];

                min = Math.min(min,arr[queries[i][0]][j]);
            }

            for(int j=queries[i][0]; j<queries[i][2]; j++) {
                arr2[j+1][queries[i][3]] = arr[j][queries[i][3]];
                min = Math.min(min,arr[j][queries[i][3]]);
            }

            for(int j=queries[i][3]; j>queries[i][1]; j--) { //j : 4->2
                arr2[queries[i][2]][j-1] = arr[queries[i][2]][j];
                min = Math.min(min,arr[queries[i][2]][j]);
            }

            for(int j=queries[i][2]; j>queries[i][0]; j--) {
                arr2[j-1][queries[i][1]] = arr[j][queries[i][1]];
                min = Math.min(min,arr[j][queries[i][1]]);
            }
            answer[i] = min;
            for(int r=0; r<arr.length; r++) {
                for(int c=1; c<arr[r].length; c++) {
                    arr[r][c] = arr2[r][c];
                }
            }
        }
        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }
}

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows+1][columns+1];
        int[][] arr2 = new int[rows+1][columns+1];
        int k = 1;

        for(int i=1; i<arr.length; i++) {
            for(int j=1; j<arr[i].length; j++) {
                arr[i][j] = arr2[i][j] = k++;
            }
        }
        int[] answer = new int[queries.length];

        for(int i=0; i<queries.length; i++) {
            int min = Integer.MAX_VALUE;

            for(int j=queries[i][1]; j<queries[i][3]; j++) {
                arr2[queries[i][0]][j+1] = arr[queries[i][0]][j];

                min = Math.min(min,arr[queries[i][0]][j]);
            }

            for(int j=queries[i][0]; j<queries[i][2]; j++) {
                arr2[j+1][queries[i][3]] = arr[j][queries[i][3]];
                min = Math.min(min,arr[j][queries[i][3]]);
            }

            for(int j=queries[i][3]; j>queries[i][1]; j--) {
                arr2[queries[i][2]][j-1] = arr[queries[i][2]][j];
                min = Math.min(min,arr[queries[i][2]][j]);
            }

            for(int j=queries[i][2]; j>queries[i][0]; j--) {
                arr2[j-1][queries[i][1]] = arr[j][queries[i][1]];
                min = Math.min(min,arr[j][queries[i][1]]);
            }
            answer[i] = min;
            for(int r=0; r<arr.length; r++) {
                for(int c=1; c<arr[r].length; c++) {
                    arr[r][c] = arr2[r][c];
                }
            }
        }

        return answer;
    }
}