import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinhoAndGangho11662 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double Ax = Double.parseDouble(st.nextToken());
        double Ay = Double.parseDouble(st.nextToken());
        double Bx = Double.parseDouble(st.nextToken());
        double By = Double.parseDouble(st.nextToken());
        double Cx = Double.parseDouble(st.nextToken());
        double Cy = Double.parseDouble(st.nextToken());
        double Dx = Double.parseDouble(st.nextToken());
        double Dy = Double.parseDouble(st.nextToken());

        int interval = 1000000;

        double dxAB = (Bx-Ax)/interval;
        double dyAB = (By-Ay)/interval;
        double dxCD = (Dx-Cx)/interval;
        double dyCD = (Dy-Cy)/interval;

        double min = distance(Ax,Ay,Cx,Cy);

        for(int i=1; i<=interval; i++){
            double tmp = distance(Ax+dxAB*i,Ay+dyAB*i,Cx+dxCD*i,Cy+dyCD*i);
            if(tmp<min){
                min=tmp;
            }
        }
        System.out.println(min);

    }
    static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }
}
