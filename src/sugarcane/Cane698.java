package sugarcane;

import java.util.Arrays;

// leaves 1 test cases.
public class Cane698 {

  public static void main(String[] args) {
    Cane698 cane698 = new Cane698();
    cane698.canPartitionKSubsets(new int[] {7, 2, 2, 2, 2, 2, 2, 2, 3}, 3);
  }

  public boolean canPartitionKSubsets(int[] nums, int k) {
    Arrays.sort(nums);
    int sum = Arrays.stream(nums).sum();
    int count = 0;
    if (sum % k == 0) {
      boolean[] arr = new boolean[(sum / k) + 1];
      arr[0] = true;
      int runSum = 0;
      for (int num : nums) {
        runSum += num;
        for (int j = 1; j <= (sum / k) && j <= runSum; j++) {
          if (j - num > -1 && arr[j - num]) {
            if (j == (sum / k)) {
              count++;
            }
            arr[j] = true;
          }
        }
      }
      if (count >= k) {
        for (int num : nums) {
          if ((sum / k) - num < 0 || !arr[(sum / k) - num]) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }
}
