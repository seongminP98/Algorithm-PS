import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DrawStar2447 {
    static char[][] star;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        star = new char[n][n];

        drawStar(0,0,n,false);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
    static void drawStar(int x, int y, int n, boolean blank){ //(x,y) 시작점. blank 공백위치확인
        if(blank){
            for(int i=x; i<x+n; i++){
                for(int j=y; j<y+n; j++){
                    star[i][j] = ' ';
                }
            }
            return;
        }

        if(n==1){
            star[x][y]='*';
            return;
        }

        int size = n/3;
        int count = 0;
        for(int i=x; i<x+n; i+=size){
            for(int j=y; j<y+n; j+=size){
                count++;
                if(count==5){//공백칸확인
                    drawStar(i,j,size,true);
                }
                else{
                    drawStar(i,j,size,false);
                }
            }
        }
    }
}
