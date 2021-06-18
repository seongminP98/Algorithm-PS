import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class YourTier14613 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double win = Double.parseDouble(st.nextToken());
        double lose = Double.parseDouble(st.nextToken());
        double draw = Double.parseDouble(st.nextToken());
        double[] ans = new double[5];
        for(int w=0; w<=20; w++){
            for(int l=0; l<=20; l++){
                for(int d=0; d<=20; d++){
                    if(w+l+d == 20){
                        int score = 2000+((w-l)*50);
                        double percent = Math.pow(win,w) * Math.pow(lose,l) * Math.pow(draw,d)
                                * factorial(20) / factorial(w) / factorial(l) / factorial(d);
                        if(score>=1000 && score <=1499){
                            ans[0] += percent;
                        } else if(score>=1500 && score<=1999){
                            ans[1] += percent;
                        } else if(score>=2000 && score<=2499){
                            ans[2] += percent;
                        } else if(score>=2500 && score<=2999){
                            ans[3] += percent;
                        } else if(score>=3000 && score<=3499){
                            ans[4] += percent;
                        }
                    }
                }
            }
        }
        for(double i : ans){
            System.out.println(String.format("%.8f", i));
            //System.out.println(Math.floor(i*100000000)/100000000.0);
        }

    }
    static double factorial(int n){
        if(n<=1){
            return 1.0;
        }
        return n*factorial(n-1);
    }
}
