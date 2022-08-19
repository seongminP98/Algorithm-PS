public class JustThatSong {
    public static void main(String[] args) {
        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicinfos));
    }
    private static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int answerTime = 0;
        // musicinfos
        // 음악이 시작한 시각, 끝난 시각, 음악 제목, 악보 정보
        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");
            int time = getTime(split[0], split[1]); // 재생시간
            if (check(change(m), change(split[3]), time)) {
                if (answerTime < time) {
                    answerTime = time;
                    answer = split[2];
                }
            }
        }
        return answer;
    }

    private static String change(String sound) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sound.length(); i++) {
            if (i != sound.length() - 1 && sound.charAt(i + 1) == '#') {
                sb.append((char) (sound.charAt(i) + 7));
                i++;
            } else {
                sb.append(sound.charAt(i));
            }
        }
        return sb.toString();
    }

    private static boolean check(String m, String music, int time) {
        StringBuilder sb = new StringBuilder();

        if (time > music.length()) {
            sb.append(music);
            int a = time / music.length();
            int b = time & music.length();
            sb.append(music.repeat(a));
            for (int i = 0; i < b; i++) {
                sb.append(music.charAt(i));
            }
        } else {
            for (int i = 0; i < time; i++) {
                sb.append(music.charAt(i));
            }
        }
        return sb.toString().contains(m);
    }

    private static int getTime(String start, String end) {
        String[] startTime = start.split(":");
        int s = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
        String[] endTime = end.split(":");
        int e = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);
        return e - s;
    }
}
