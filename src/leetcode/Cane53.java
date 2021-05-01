package leetcode;

import java.util.Arrays;

public class Cane53 {

  public int maxSubArray(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int maxSum = 0, runSum = 0;
    for (int num : nums) {
      runSum += num;
      if (maxSum < runSum) {
        maxSum = runSum;
      }
      if (runSum < 0) {
        runSum = 0;
      }
    }
    if (maxSum == 0) {
      maxSum = Arrays.stream(nums).max().getAsInt();
    }
    return maxSum;
  }

  public static void main(String[] args) {
    Cane53 cane53 = new Cane53();
    System.out.println(cane53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    System.out.println(cane53.maxSubArray(new int[]{0, 0, 0}));
    System.out.println(cane53.maxSubArray(new int[]{-1, -2, -3}));
  }
}
