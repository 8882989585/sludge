package leetcode;

public class Cane153 {

  public int findMin(int[] nums) {
    int i = 0, j = nums.length - 1;
    if (i == j) {
      return nums[i];
    }
    while (i != j) {
      int mid = (i + j) / 2;
      if (nums[mid] < nums[mid + 1]) {
        if (nums[mid] > nums[j]) {
          i = mid + 1;
        } else {
          j = mid;
        }
      } else {
        i = mid + 1;
      }
    }
    return nums[i];
  }

  public static void main(String[] args) {
    Cane153 cane153 = new Cane153();
    System.out.println(cane153.findMin(new int[]{0, 1, 2, 3, 4}));
    System.out.println(cane153.findMin(new int[]{7, 8, 0, 1, 2, 3, 4, 5, 6}));
    System.out.println(cane153.findMin(new int[]{3, 4, 5, 6, 7, 8, 0, 1, 2}));
    System.out.println(cane153.findMin(new int[]{4, 5, 6, 7, 8, 0, 1, 2, 3}));
  }
}