import java.util.*;

public class ParkingFee {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }

    private static int[] solution(int[] fees, String[] records) {
        // fees : 기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)
        Map<String, String> inRecodes = new HashMap<>();
        Map<String, Integer> time = new TreeMap<>();
        for (String record : records) {
            String[] split = record.split(" ");
            if (split[2].equals("IN")) { // 입차
                inRecodes.put(split[1], split[0]);
            } else { // 출차
                int parkingTime = timeCal(inRecodes.get(split[1]), split[0]);
                inRecodes.remove(split[1]);
                time.put(split[1], time.getOrDefault(split[1], 0) + parkingTime);
            }
        }
        for (String num : inRecodes.keySet()) {
            int parkingTime = timeCal(inRecodes.get(num), "23:59");
            time.put(num, time.getOrDefault(num, 0) + parkingTime);
        }
        int[] answer = new int[time.size()];
        int idx = 0;
        for (Integer value : time.values()) {
            answer[idx++] = feeCal(fees, value);
        }
        return answer;
    }

    private static int timeCal(String in, String out) {
        StringTokenizer st = new StringTokenizer(out, ":");
        int mOut = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in, ":");
        int mIn = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        System.out.println("mOut - mIn = " + (mOut - mIn));
        return mOut - mIn;
    }

    private static int feeCal(int[] fees, int time) {
        if (time <= fees[0]) {
            return fees[1];
        } else {
            int sumFee = fees[1];
            time -= fees[0];
            sumFee += (time / fees[2]) * fees[3];
            if (time % fees[2] != 0) {
                sumFee += fees[3];
            }
            return sumFee;
        }
    }
}
