public class WinterCoding1 {
    public static void main(String[] args) {
        String character = "10 5 2";
        String[] monsters = {"Knight 3 10 10 3","Wizard 5 10 15 1","Beginner 1 1 15 1"};

        double cHealth = Double.parseDouble(character.split(" ")[0]);
        double cPower = Double.parseDouble(character.split(" ")[1]);
        double cDefense = Double.parseDouble(character.split(" ")[2]);

        double[] exp = new double[monsters.length];
        for(int i=0; i< monsters.length; i++) {
            double mHealth = Double.parseDouble(monsters[i].split(" ")[2]);
            double mPower = Double.parseDouble(monsters[i].split(" ")[3]);
            double mDefense = Double.parseDouble(monsters[i].split(" ")[4]);

            if(cPower - mDefense >= mHealth) { //한방컷
                exp[i] = Double.parseDouble(monsters[i].split(" ")[1]);
                continue;
            }
            if(mPower - cDefense >= cHealth) { //못잡음
                exp[i] = 0;
                continue;
            }

            double sec = Math.ceil(mHealth / (cPower - mDefense));
            exp[i] = Double.parseDouble(monsters[i].split(" ")[1]) / sec;

        }
        double result = 0;
        int index = 0;
        for(int i=0; i<exp.length; i++) {
            if(result<exp[i]) {
                result = exp[i];
                index = i;
            }else if(result == exp[i]) {
                if(Double.parseDouble(monsters[index].split(" ")[1]) < Double.parseDouble(monsters[i].split(" ")[1])) {
                    result = exp[i];
                    index = i;
                }
            }
        }
        String answer = monsters[index].split(" ")[0];
        System.out.println(answer);
    }
}
