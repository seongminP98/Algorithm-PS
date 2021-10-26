import java.util.ArrayList;
import java.util.List;

public class LankSearch {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] answer = new int[query.length];
        List<Information> applicantList = new ArrayList<>();
        for (String s : info) {
            String[] split = s.split(" ");
            applicantList.add(new Information(split[0],split[1],split[2],split[3],split[4]));
        }

        List<Information> conditionList = new ArrayList<>();
        for (String s : query) {
            s = s.replaceAll("and ","");
            String[] split = s.split(" ");
            conditionList.add(new Information(split[0],split[1],split[2],split[3],split[4]));
        }



        int i = 0;
        for (Information information : conditionList) {
            int count = 0;
            for (Information applicantCondition : applicantList) {
                if(isTrue(information, applicantCondition)){
                    count++;
                }
            }
            answer[i] = count;
        }


    }
    static boolean isTrue(Information information, Information applicantCondition) {

        if(!information.language.equals("-") && !information.language.equals(applicantCondition.language)){
            return false;
        }
        if(!information.jobGroup.equals("-") && !information.jobGroup.equals(applicantCondition.jobGroup)){
            return false;
        }
        if(!information.career.equals("-") && !information.career.equals(applicantCondition.career)){
            return false;
        }
        if(!information.soulFood.equals("-") && !information.soulFood.equals(applicantCondition.soulFood)){
            return false;
        }
        if(Integer.parseInt(information.score) > Integer.parseInt(applicantCondition.score)){
            return false;
        }
        return true;
    }

    static class Information {
        String language;
        String jobGroup;
        String career;
        String soulFood;
        String score;

        public Information(String language, String jobGroup, String career, String soulFood, String score) {
            this.language = language;
            this.jobGroup = jobGroup;
            this.career = career;
            this.soulFood = soulFood;
            this.score = score;
        }
    }
}
