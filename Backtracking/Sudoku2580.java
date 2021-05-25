import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sudoku2580 {
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9][9];
        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
    }
    static void dfs(int x, int y){
        if(y == 9){ //행의 끝까지 왔으면 1행 내려감
            dfs(x+1,0);
            return;
        }
        if(x == 9){ //스도쿠가 모두 채워짐.
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }


        if(arr[x][y] == 0){
            for(int i=1; i<=9; i++){
                if(possible(x,y,i)){
                    arr[x][y] = i;
                    dfs(x,y+1);
                }
            }
            arr[x][y] = 0;
            return;
        }
        dfs(x,y+1);
    }
    static boolean possible(int x, int y, int value){
        for(int i=0; i<9; i++){
            if(arr[x][i] == value){
                return false;
            }
        }

        for(int i=0; i<9; i++){
            if(arr[i][y] == value){
                return false;
            }
        }

        int sx = (x/3)*3;
        int sy = (y/3)*3;

        for(int i=sx; i<sx+3; i++){
            for(int j=sy; j<sy+3; j++){
                if(arr[i][j] == value)
                    return false;
            }
        }
        return true;
    }
}
