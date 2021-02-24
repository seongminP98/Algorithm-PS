import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CororedPaper2630 {
    static int[][] paper;
    static int white=0;
    static int blue=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cut(0,0,n);
        System.out.println(white);
        System.out.println(blue);

    }
    static void cut(int x, int y, int n){ //(x,y) 시작지점
        int first = paper[x][y];
        boolean check = true;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(first != paper[i+x][j+y])
                    check = false;
            }
        }
        if(check){
           if(paper[x][y]==1)
               blue++;
           else
               white++;
           return;
        } else{
            n/=2;
            cut(x,y,n);
            cut(x,y+n,n);
            cut(x+n,y,n);
            cut(x+n,y+n,n);
        }
    }
}
