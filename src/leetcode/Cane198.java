package leetcode;

import java.util.Arrays;

public class Cane198 {
  public int rob(int[] nums) {
    int[] res = new int[nums.length];
    if (nums.length == 1) {
      return nums[0];
    }
    res[0] = nums[0];
    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    res[1] = nums[1];
    res[2] = nums[2] + nums[0];
    for (int i = 3; i < nums.length; i++) {
      res[i] = Math.max(res[i - 2], res[i - 3]) + nums[i];
    }
    return Arrays.stream(res).max().getAsInt();
  }
}
