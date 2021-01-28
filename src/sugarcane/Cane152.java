package sugarcane;

import java.util.LinkedList;

public class Cane152 {

  public int maxProduct(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    boolean flag1 = false;
    LinkedList<Integer> zeros = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        zeros.add(i);
        flag1 = true;
      }
    }
    zeros.add(nums.length);
    Integer max = null;
    int i = 0;
    while (!zeros.isEmpty()) {
      int j = zeros.removeFirst(), prod = 1, revProd = 1, k = j;
      Integer firstNegative = null, revFirstNegative = null;
      if (k - i == 1) {
        if (max == null || max < nums[i]) {
          max = nums[i];
        }
      } else {
        boolean flag = false;
        while (i < k) {
          flag = true;
          prod = prod * nums[i];
          revProd = revProd * nums[j-1];
          if (prod < 0 && firstNegative == null) {
            firstNegative = prod;
          }
          if (revProd < 0 && revFirstNegative == null) {
            revFirstNegative = revProd;
          }
          i++;
          j--;
        }
        if (flag) {
          if (prod < 0) {
            int tmp = prod / (firstNegative > revFirstNegative ? firstNegative : revFirstNegative);
            if (max == null || tmp > max) {
              max = tmp;
            }
          } else {
            if (max == null || prod > max) {
              max = prod;
            }
          }
        }
      }
      i = k + 1;
    }
    if (max == null) {
      max = 0;
    }
    if(max < 0  && flag1) {
      max = 0;
    }
    return max;
  }

  public static void main(String[] args) {
    Cane152 cane152 = new Cane152();
    System.out.println(cane152.maxProduct(new int[]{3, 4, -2, -3, 2, -1, 2, 2, 2, 2, 2}));
    System.out.println(cane152.maxProduct(new int[]{-3, 4}));
    System.out.println(cane152.maxProduct(new int[]{3, -4}));
    System.out.println(cane152.maxProduct(new int[]{-4}));
    System.out.println(cane152.maxProduct(new int[]{}));
    System.out.println(cane152.maxProduct(new int[]{0, 0, 0, 0}));
    System.out.println(cane152.maxProduct(new int[]{0}));
    System.out.println(cane152.maxProduct(new int[]{2, -5, 3, 1, -4, 0, -10, 2, 8}));
    System.out.println(cane152.maxProduct(new int[]{0, 2}));
  }
}
