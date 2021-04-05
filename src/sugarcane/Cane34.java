package sugarcane;

import java.util.Arrays;

public class Cane34 {

  public static void main(String[] args) {
    Cane34 cane34 = new Cane34();
    System.out.println(Arrays.toString(cane34.searchRange(new int[] {0, 0, 0, 1, 2, 3}, 0)));
  }

  public int[] searchRange(int[] nums, int target) {
    int i = Arrays.binarySearch(nums, target);
    if (i < 0 || i > nums.length - 1) {
      return new int[] {-1, -1};
    }
    int toIndex = i + 1;
    int[] res = new int[2];
    while (true) {
      if (toIndex == 0) {
        break;
      }
      int t = Arrays.binarySearch(nums, 0, toIndex, target);
      if (t == 0 || (t > 0 && nums[t - 1] != target)) {
        res[0] = t;
        break;
      } else {
        toIndex = t - 1;
      }
    }
    toIndex = i;
    while (true) {
      if (toIndex == nums.length - 1) {
        res[1] = nums.length - 1;
        break;
      }
      int t = Arrays.binarySearch(nums, toIndex, nums.length, target);
      if (t == nums.length - 1 || (t < nums.length - 1 && nums[t + 1] != target)) {
        res[1] = t;
        break;
      } else {
        toIndex = t + 1;
      }
    }
    return res;
  }
}
