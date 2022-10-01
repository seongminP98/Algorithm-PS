public class BaseStationInstallation {
    public static void main(String[] args) {
        int n = 16;
        int[] stations = {9};
        int w = 2;
        System.out.println(solution(n, stations, w));

    }

    private static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int cover = w * 2 + 1;
        for (int station : stations) {
            int end = station - w - 1;
            int dis = end - start + 1;
            answer += dis / cover;
            if (dis % cover > 0) {
                answer++;
            }
            start = station + w + 1;
        }

        if (start <= n) {
            int dis = n - start + 1;
            answer += dis / cover;
            if (dis % cover > 0) {
                answer++;
            }
        }

        return answer;
    }
}
