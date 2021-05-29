import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bakery3109 {
    static int R,C;
    static char[][] arr;
    static int[] dy = {1,1,1};
    static int[] dx = {-1,0,1};
    static int count; //= Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        count=0;
        for(int i=0; i<R; i++){
            dfs(i,0);
        }
//        for (char[] chars : arr) {
//            for (int j = 0; j < arr[0].length; j++) {
//                System.out.print(chars[j]);
//            }
//            System.out.println();
//        }


        System.out.println(count);
    }
    static boolean dfs(int x, int y){
        for(int j=0; j<3; j++){
            int nx = x+dx[j];
            int ny = y+dy[j];
            //System.out.println("======="+"nx:"+nx+" ny:"+ny);
            if(nx>=0 && ny>=0 && nx<R && ny<C){
                if(arr[nx][ny]=='.'){
                    //System.out.println("nx:"+nx+" ny:"+ny);
                    if(ny==C-1){
                        arr[nx][ny] = 'x';
                        count++;
                        return true;
                    }
                    arr[nx][ny] = 'x';
                    if(dfs(nx,ny))
                        return true;
                }
            }
        }
        return false; //파이프가 갈 공간이 없으면 false를 리턴해 더 이상 탐색할 수 없게 한다. 이거때매 틀림.
    }
}