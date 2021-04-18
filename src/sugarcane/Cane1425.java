package sugarcane;

import java.util.Arrays;

public class Cane1425 {

  public static void main(String[] args) {
    Cane1425 cane1425 = new Cane1425();
    cane1425.constrainedSubsetSum(new int[] {10, -2, -10, -5, 20}, 2);
  }

  public int constrainedSubsetSum(int[] nums, int k) {
    int[] res = new int[nums.length];
    Arrays.fill(res, Integer.MIN_VALUE);
    for (int i = 0; i < nums.length; i++) {
      int max = nums[i];
      for (int j = i - 1; j >= i - k && j > -1; j--) {
        max = Math.max(res[j] + nums[i], max);
      }
      res[i] = max;
    }
    return Arrays.stream(res).max().getAsInt();
  }
}
