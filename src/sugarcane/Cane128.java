package sugarcane;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Cane128 {

  public int longestConsecutive(int[] nums) {
    HashSet<Integer> numSet = new HashSet<>();
    HashSet<Integer> usedNumSet = new HashSet<>();
    Arrays.stream(nums).forEach(numSet::add);
    int max = 0;
    for (int num : nums) {
      if (!usedNumSet.contains(num)) {
        usedNumSet.add(num);
        int t1 = num + 1, t2 = num - 1, c1 = 0, c2 = 0;
        while (numSet.contains(t1)) {
          c1++;
          usedNumSet.add(t1);
          t1++;
        }
        while (numSet.contains(t2)) {
          c1++;
          usedNumSet.add(t2);
          t2--;
        }
        int l = 1 + c1 + c2;
        if (l > max) {
          max = l;
        }
      }
    }
    return max;
  }
}
