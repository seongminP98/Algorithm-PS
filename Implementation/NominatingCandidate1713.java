import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class NominatingCandidate1713 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<PhotoFrame> photoFrame = new ArrayList<>();
        int[] students = new int[101];
        for (int i = 0; i < num; i++) {
            int student = Integer.parseInt(st.nextToken());
            if (students[student] > 0) { //추천 학생이 이미 사진틀에 있음
                students[student] += 1; //투표 수 증가
                for (PhotoFrame frame : photoFrame) { //투표 수 증가
                    if (frame.student == student) {
                        frame.votes += 1;
                        break;
                    }
                }
            } else {
                if (photoFrame.size() >= N) { //추천 학생이 사진틀에 없고, 사진틀 꽉 참
                    Collections.sort(photoFrame); //삭제할 사진 순으로 정렬
                    students[photoFrame.get(0).student] = 0; //투표 수 0됨.
                    photoFrame.remove(0);
                }
                photoFrame.add(new PhotoFrame(student, 1, i));
                students[student] = 1;
            }
        }

        for (int i = 1; i < 101; i++) {
            if (students[i] != 0) {
                System.out.print(i + " ");
            }
        }
    }

    static class PhotoFrame implements Comparable<PhotoFrame> {
        int student;
        int votes;
        int time;

        public PhotoFrame(int student, int votes, int time) {
            this.student = student;
            this.votes = votes;
            this.time = time;
        }

        @Override
        public int compareTo(PhotoFrame o) { //return 값이 양수이면 순서바꿈. 음수거나 0이면 자리 바꾸지않음.
            if (this.votes == o.votes) { //투표가 같으면
                return this.time - o.time; //오래된걸 앞으로.
            } else if (this.votes < o.votes) { //투표 수 오름차순 정렬. 
                return -1;
            } else
                return 1;
        }


    }
}
