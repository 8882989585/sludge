package sugarcane;

public class Cane523 {

  public boolean checkSubarraySum(int[] nums, int k) {
    for (int i = 1; i < nums.length; i++) {
      nums[i] = nums[i] + nums[i - 1];
      if (k == 0 && nums[i] == 0) {
        return true;
      } else if (k != 0 && nums[i] % k == 0) {
        return true;
      }
    }
    for (int i = 2; i < nums.length; i++) {
      for (int j = i - 2; j > -1; j--) {
        if (k == 0 && (nums[i] - nums[j]) == 0) {
          return true;
        } else if (k != 0 && (nums[i] - nums[j]) % k == 0) {
          return true;
        }
      }
    }
    return false;
  }
}
