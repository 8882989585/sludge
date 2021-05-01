package leetcode;

public class Cane41 {

  public int firstMissingPositive(int[] nums) {
    if (nums.length == 0) {
      return 1;
    }
    int i = 0;
    while (i < nums.length) {
      if (nums[i] <= nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
        int tmp = nums[nums[i] - 1];
        int n = nums[i] -1;
        nums[nums[i] - 1] = nums[i];
        nums[i] = tmp;
        i = Math.min(n, i);
        continue;
      }
      i++;
    }
    for (i = 0; i < nums.length; i++) {
      if (i + 1 != nums[i]) {
        return i + 1;
      }
    }
    return nums[nums.length - 1] + 1;
  }

  public static void main(String[] args) {
      Cane41 cane41 = new Cane41();
      cane41.firstMissingPositive(new int[]{1,2,0});
  }
}
