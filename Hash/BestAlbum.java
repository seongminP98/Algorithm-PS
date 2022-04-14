import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 800, 500, 2500};
        Map<String, Song> map = new HashMap<>();
        int len = genres.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(genres[i])) {
                Song c = map.get(genres[i]);
                if (c.first < plays[i]) { // 가장 크면 first에 저장
                    int tmp = c.first;
                    int tempIdx = c.firstIdx;
                    c.first = plays[i];
                    c.firstIdx = i;
                    c.second = tmp;
                    c.secIdx = tempIdx;
                } else {
                    if (c.second < plays[i]) { // second 보다 크면 second 에 저장
                        c.second = plays[i];
                        c.secIdx = i;
                    }
                }
                c.sum += plays[i];
            } else { // map 에 없으면
                map.put(genres[i], new Song(plays[i], 0, plays[i], i, -1));
            }
        }
        // map value 의 sum 값으로 내림차순 정렬
        List<Map.Entry<String, Song>> list = new ArrayList<Map.Entry<String, Song>>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Song>>() {
            @Override
            public int compare(Map.Entry<String, Song> o1, Map.Entry<String, Song> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        // 답을 List 에 담기.
        List<Integer> ansList = new ArrayList<>();
        for (Map.Entry<String, Song> entry : list) {
            ansList.add(entry.getValue().firstIdx);
            if (entry.getValue().secIdx != -1) {
                ansList.add(entry.getValue().secIdx);
            }
        }

        // List 를 배열로 바꿔주기.
        int size = list.size();
        Integer[] ans = ansList.toArray(new Integer[size]);
        int[] answer = Arrays.stream(ans).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(answer));
    }

    static class Song implements Comparable<Song> {
        int first, second, sum, firstIdx, secIdx;

        public Song(int first, int second, int sum, int firstIdx, int secIdx) {
            this.first = first;
            this.second = second;
            this.sum = sum;
            this.firstIdx = firstIdx;
            this.secIdx = secIdx;
        }

        @Override
        public int compareTo(Song o) { // sun 기준 내림차순 정렬
            return o.sum - sum;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "first=" + first +
                    ", second=" + second +
                    ", sum=" + sum +
                    ", firstIdx=" + firstIdx +
                    ", secIdx=" + secIdx +
                    '}';
        }
    }
}
