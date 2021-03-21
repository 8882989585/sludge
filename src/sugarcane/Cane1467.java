package sugarcane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Cane1467 {

    public int minDeletions(String s) {
        char[] ch = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c:ch) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int[] values = new int[map.size()];
        int h=0;
        for(Integer i:map.values()) {
            values[h] = i;
            h++;
        }
        h = 0;
        Arrays.sort(values);
        for(int i=values.length-1;i>0;i--) {
            if(values[i] == 0) {
                h+= values[i-1];
                values[i-1] = 0;
            }
            else if(values[i] <= values[i-1]) {
                int i1 = values[i - 1] - values[i] + 1;
                h+= i1;
                values[i-1] = values[i-1] - i1;
            }
        }
        return h;
    }
  public static void main(String[] args) {
    //
      Cane1467 cane1467 = new Cane1467();
    System.out.println(
    cane1467.minDeletions("bggfffdddd"));
  }
}
