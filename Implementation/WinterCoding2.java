public class WinterCoding2 {
    public static void main(String[] args) {
        int time = 100;
        int gold = 200;
        int[][] upgrade = {{0, 5}, {1500, 3}, {3000, 1}};
        int answer = (time / upgrade[0][1]) * gold; //업글x
        if(upgrade.length == 1) {
            System.out.println(answer);
        }

        loop : for(int i=1; i< upgrade.length; i++) {
            int sum = 0;
            for(int j=1; j<=i; j++) {
                int upgradeCost = upgrade[j][0];
                int num = (int)Math.ceil((double)upgradeCost/(double)gold); //업글하는데 필요한 광석개수
                time -= num*upgrade[j-1][1];
                if(time<=0) {
                    break loop;
                }
                sum += (num*gold) - upgradeCost;
                if(j==i) {
                    sum += (time / upgrade[i][1]) * gold;
                }
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}
