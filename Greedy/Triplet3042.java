import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Triplet3042 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<double[]> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                if(s.charAt(j)!='.'){
                    list.add(new double[]{i,j});
                }
            }
        }
        int result = 0;

        double m,m2;
        for(int i=0; i<list.size()-2; i++){
            for(int j=i+1; j<list.size()-1; j++){
                if(list.get(j)[0]-list.get(i)[0] == 0){
                    m = 10000;
                }else{
                    m = f(list.get(i)[0], list.get(i)[1], list.get(j)[0], list.get(j)[1]);
                }
                for(int k=j+1; k<list.size(); k++){
                    if(list.get(k)[0]-list.get(j)[0] == 0){
                        m2=10000;
                    }
                    else{m2 = f(list.get(j)[0], list.get(j)[1], list.get(k)[0], list.get(k)[1]);}
                    if(m==m2)
                        result++;
                }
            }
        }
        System.out.println(result);
    }

    public static double f(double x1, double y1, double x2, double y2){
        return (y2-y1) / (x2-x1);
    }
}
