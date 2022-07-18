import java.util.*;
public class SortFileName {
    public String[] solution(String[] files) {
        int size = files.length;
        String[] answer = new String[size];
        File[] f = new File[size];
        int index = 0;
        for(String file : files) {
            StringBuilder name = new StringBuilder();
            StringBuilder num = new StringBuilder();

            boolean check = false;
            for(int i=0; i<file.length(); i++) {
                if(file.charAt(i) >= '0' && file.charAt(i) <= '9') {
                    num.append(file.charAt(i));
                    check = true;
                } else {
                    if(check) break;
                    name.append(file.charAt(i));
                }

            }
            // System.out.println("name : " + name);
            // System.out.println("num : " + num);
            f[index] = new File(name.toString().toUpperCase(), Integer.parseInt(num.toString()), index);
            index++;

        }
        Arrays.sort(f);
        for(int i=0; i<size; i++) {
            answer[i] = files[f[i].idx];
        }

        return answer;
    }
    private static class File implements Comparable<File>{
        String name;
        int num, idx;
        public File(String name, int num, int idx) {
            this.name = name;
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(File o) {
            if(this.name.equals(o.name)) {
                if(this.num == o.num) {
                    return Integer.compare(this.idx, o.idx);
                }
                return Integer.compare(this.num, o.num);
            }
            return this.name.compareTo(o.name);
        }
    }
}