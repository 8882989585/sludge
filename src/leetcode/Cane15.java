package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Cane15 {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new LinkedList<>();
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length - 1; i++) {
      if(!set.contains(nums[i])) {
        Set<Integer> subset = new HashSet<>();
        Set<Integer> subset2 = new HashSet<>();
        for (int j = i + 1; j < nums.length; j++) {
          if (!set.contains(nums[j])) {
            int t = -(nums[i] + nums[j]);
            if (subset.contains(t) && !subset2.contains(nums[j])) {
              result.add(Arrays.asList(nums[i], nums[j], t));
              subset2.add(nums[j]);
              subset2.add(t);
            } else {
              subset.add(nums[j]);
            }
          }
        }
      }
      set.add(nums[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    Cane15 cane15 = new Cane15();
    int[]
        data = new int[]{-1, 0, 1, 2, -1, -4};
//        data = new int[]{
//        -8, 8, 5, -2, -8, -9, -10, 6, -3, -5, 5, -6, -2, -6, 5, -5, 7, 3, -4, 0, -5, -2};
    data = new int[]{0, 0, 0, 0, 0};
    cane15.threeSum(data);
  }
}
