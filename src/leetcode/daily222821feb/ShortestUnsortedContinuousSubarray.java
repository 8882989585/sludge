package leetcode.daily222821feb;

public class ShortestUnsortedContinuousSubarray {
  public static void main(String[] args) {
    //
    ShortestUnsortedContinuousSubarray sucs = new ShortestUnsortedContinuousSubarray();
    System.out.println(sucs.findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15}));
    System.out.println(sucs.findUnsortedSubarray(new int[] {2, 6, 4, 8, 16, 9, 15}));
    System.out.println(sucs.findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 7, 16, 9, 15}));
    System.out.println(sucs.findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 1, 16, 9, 15}));
    System.out.println(sucs.findUnsortedSubarray(new int[] {1, 2, 3, 4}));
  }

  public int findUnsortedSubarray(int[] nums) {
    if (nums.length < 2) {
      return 0;
    }
    int maxError = Integer.MIN_VALUE, minError = Integer.MAX_VALUE;
    boolean flag = false;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        flag = true;
        if (maxError < nums[i - 1]) {
          maxError = nums[i - 1];
        }
        if (minError > nums[i]) {
          minError = nums[i];
        }
      }
    }
    if (flag) {
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] > minError) {
          minError = i;
          break;
        }
      }
      for (int i = nums.length - 1; i > -1; i--) {
        if (nums[i] < maxError) {
          maxError = i;
          break;
        }
      }
      return maxError - minError + 1;
    }
    return 0;
  }
}
