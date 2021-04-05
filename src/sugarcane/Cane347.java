package sugarcane;

import java.util.*;

public class Cane347 {

  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, HashSet<Integer>> map1 = new HashMap<>();
    HashMap<Integer, Integer> map2 = new HashMap<>();
    for (int i : nums) {
      Integer currentCount = map2.get(i);
      if (currentCount == null) {
        map2.put(i, 1);
        HashSet<Integer> set = map1.computeIfAbsent(1, k1 -> new HashSet<>());
        set.add(i);
      } else {
        map2.put(i, currentCount + 1);
        map1.get(currentCount).remove(i);
        HashSet<Integer> set = map1.computeIfAbsent(currentCount + 1, k1 -> new HashSet<>());
        set.add(i);
      }
    }
    int[] result = new int[k];
    int t = 0;
    for (Map.Entry<Integer, HashSet<Integer>> entry :
        new TreeMap<>(map1).descendingMap().entrySet()) {
      for (Integer j : entry.getValue()) {
        if (t == k) {
          return result;
        }
        result[t] = j;
        t++;
      }
    }
    return result;
  }
}
