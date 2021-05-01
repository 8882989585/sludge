package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Cane1086 {
  public int[][] highFive(int[][] items) {
    HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
    for(int i=0;i<items.length;i++) {
      if(!map.containsKey(items[i][0])) {
        map.put(items[i][0], new LinkedList<>());
      }
      map.get(items[i][0]).add(items[i][1]);
    }
    int[][] result = new int[map.size()][2];
    int i = 0;
    for(Map.Entry<Integer, LinkedList<Integer>> entry:map.entrySet()) {
      int count = 0;
      int sum = 0;
      entry.getValue().sort(Collections.reverseOrder());
      for(Integer j:entry.getValue()) {
        sum += j;
        count++;
        if(count == 5) {
          result[i][0] = entry.getKey();
          result[i][1] = sum / 5;
          i++;
          break;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Cane1086 cane1086 = new Cane1086();
    cane1086.highFive(new int[][]
        {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}});
  }
}
