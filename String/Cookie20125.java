import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cookie20125 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n+1][n+1];
        for(int i=1; i<n+1; i++){
            String s = br.readLine();
            for(int j=1; j<n+1; j++){
                arr[i][j] = s.charAt(j-1);
            }
        }
        int heartX = 0;
        int heartY = 0;
        int[] len = new int[5]; //왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리
        loop:for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(arr[i][j]=='*'){
                    heartX=i+1;
                    heartY=j;
                    break loop;
                }
            }
        }
        for(int i=1; i<n+1; i++){
            if(arr[heartX][i]=='*'){
                if(i<heartY){
                    len[0]++;
                }
                if(i>heartY){
                    len[1]++;
                }
            }
        }
        int legX=0;

        for(int i=1; i<n+1; i++){
            if(arr[i][heartY]=='*'){
                if(i>heartX){
                    len[2]++;
                    legX=i;
                }
            }
        }
        for(int i=1; i<n+1; i++){
            if(arr[i][heartY-1]=='*'){
                if(i>legX){
                    len[3]++;
                }
            }
            if(arr[i][heartY+1]=='*'){
                if(i>legX){
                    len[4]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(heartX).append(" ").append(heartY).append('\n');
        for(int i : len){
            sb.append(i).append(" ");
        }
        System.out.println(sb);

    }
}
