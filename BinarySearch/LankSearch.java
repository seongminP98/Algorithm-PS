import java.util.*;

public class LankSearch {
    static Map<String, ArrayList<Integer>> information;
    static ArrayList<Integer> in;
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] answer = new int[query.length];

        information = new HashMap<>();
        for (String s : info) {
            dfs("",0,s.split(" "));
        }

        // map에 저장된 점수들을 오름차순 정렬
        List<String> list = new ArrayList<>(information.keySet());
        for (String s : list) {
            //얕은 복사 (참조값 복사)
            List<Integer> scoreList = information.get(s);
            Collections.sort(scoreList);
        }

        int i = 0;
        for (String q : query) {
            q = q.replaceAll(" and ","");
            String[] split = q.split(" ");
            int score = Integer.parseInt(split[1]);
            answer[i++] = search(split[0], score);//조건과 점수
        }
        for (int i1 : answer) {
            System.out.println(i1);
        }
    }

    static void dfs(String key, int depth, String[] infoSplit) {//언어, 직군, 경력, 소울푸드 조건 있거나 없거나(-)로 모든 키값 만든다.
        //지원자가 속할 수 있는 모든 조건을 만들어서 hm의 키값에 넣음.
        //그 키값에 속하는 모든 지원자의 점수를 넣음.
        if(depth == 4) {
            if(!information.containsKey(key)) {
                in = new ArrayList<>();
                in.add(Integer.parseInt(infoSplit[4]));
                information.put(key, in);
            } else {
                information.get(key).add(Integer.parseInt(infoSplit[4]));
            }
            return;
        }
        dfs(key+"-", depth+1, infoSplit);
        dfs(key+infoSplit[depth], depth+1, infoSplit);
    }

    //이분 탐색
    static int search(String str, int score) {
        if(!information.containsKey(str)) //조건에 맞는 지원자 없음
            return 0;
        List<Integer> scoreList = information.get(str); //조건에 맞는 점수들
        int start = 0;
        int end = scoreList.size()-1;

        while(start<=end) {
            int mid = (start+end)/2;
            if(scoreList.get(mid) < score) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        //scoreList에 있는 점수들(오름차순 되어있음) 중 score보다 큰게 몇개인지 찾음
        return scoreList.size()-start;
    }
}

/*
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

 */
