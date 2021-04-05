package sugarcane.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question6 {

    class Pair {
        int first;
        int last;

        public Pair(int first, int last) {
            this.first = first;
            this.last = last;
        }
    }

    public List<Integer> partitionLabels(String S) {
        HashMap<Character, Pair> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        char[] chars = S.toCharArray();
        for(int i=0;i<chars.length;i++) {
            Pair tmp = map.get(chars[i]);
            if(tmp == null) {
                map.put(chars[i], new Pair(i, i));
            } else {
                tmp.last = i;
            }
        }
        int runVar = -1;
        int init = -1;
        for(int i=0;i<chars.length;i++) {
            if (map.get(chars[i]).last > runVar) {
                runVar = map.get(chars[i]).last;
            }
            if(runVar == i) {
                result.add(runVar - init);
                init = i;
            }
        }
        return result;
    }

  public static void main(String[] args) {
    //
      Question6 question6 = new Question6();
      question6.partitionLabels("");
  }
}
