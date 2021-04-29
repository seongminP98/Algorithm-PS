import java.util.Scanner;

public class DrawStar2448 {
    static char[][] star;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        star = new char[N][2*N-1];
        for(int i=0; i<N; i++){
            for(int j=0; j<2*N-1; j++){
                star[i][j]=' ';
            }
        }
        draw(N,0,N-1);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<2*N-1; j++){
                sb.append(star[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
    static void draw(int n, int x, int y){
        if(n==3){
            star[x][y] = '*';
            star[x+1][y-1] = star[x+1][y+1] = '*';
            star[x+2][y-2] = star[x+2][y-1] = star[x+2][y] = star[x+2][y+1] = star[x+2][y+2] = '*';
            return;
        }
        draw(n/2,x,y);      //위 삼각형
        draw(n/2,x+n/2,y-n/2);  //왼쪽 아래 삼각형
        draw(n/2,x+n/2,y+n/2);  //오른쪽 아래 삼각형
    }
}
