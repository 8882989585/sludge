package leetcode;

public class Cane1144 {

  public static void main(String[] args) {
    Cane1144 cane1144 = new Cane1144();
    cane1144.movesToMakeZigzag(new int[] {10,4,4,10,10,6,2,3});
  }

  public int movesToMakeZigzag(int[] nums) {
    int sum1 = 0, sum2 = 0;
    for (int i = 0; i < nums.length; i++) {
      int t =
          nums[i]
              - Math.min(
                  i + 1 < nums.length ? nums[i + 1] : Integer.MAX_VALUE,
                  i - 1 > -1 ? nums[i - 1] : Integer.MAX_VALUE);
      if (t >= 0) {
        if (i % 2 == 0) {
          sum1 += t + 1;
        } else {
          sum2 += t + 1 ;
        }
      }
    }
    return Math.min(sum1, sum2);
  }
}
