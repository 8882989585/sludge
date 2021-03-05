package sugarcane;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Cane253 {

  public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(
        intervals,
        (obj1, obj2) -> {
          if (obj1[0] < obj2[0]) {
            return -1;
          } else if (obj1[0] == obj1[1]) {
            return Integer.compare(obj1[1], obj2[1]);
          } else return 1;
        });
      TreeMap<Integer, Integer> treeMap = new TreeMap<>();
      int count = 0;
      for(int[] i:intervals) {
          if(i[1] - i[0] < 1) {
              continue;
          }
          Map.Entry<Integer,Integer> entry = treeMap.floorEntry(i[0]);
          if (entry == null) {
              treeMap.merge(i[1], 1, Integer::sum);
              count++;
          } else {
              if(entry.getValue() == 1) {
                  treeMap.remove(entry.getKey());
              } else {
                  treeMap.put(entry.getKey(), entry.getValue()-1);
              }
              treeMap.merge(i[1], 1, Integer::sum);
          }
      }
    System.out.println(count);
      return count;
  }

  public static void main(String[] args) {
    Cane253 cane253 = new Cane253();
    cane253.minMeetingRooms(new int[][] {{0, 30}, {5, 10}, {15, 20}, {25,40}, {25,40}});
      cane253.minMeetingRooms(new int[][] {{0, 0}, {0, 0}, {0, 0}, {0,0}, {0,0}});
      cane253.minMeetingRooms(new int[][] {{0, 10}, {0, 10}, {0, 10}, {0,10}, {0,10}});
      cane253.minMeetingRooms(new int[][] {});
  }
}
