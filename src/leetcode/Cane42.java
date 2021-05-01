package leetcode;

/**
 * Use the 2 pointer approach
 */
public class Cane42 {

  public int trap(int[] height) {
    int start = 0, end = height.length - 1, min = 0, water = 0, i, j, max = 0;
    while (start < end) {
      min = Math.min(height[start], height[end]);
      water = water + ((min - max) * (end - start + 1));
      j = start;
      if (max < min) {
        max = min;
      }
      if (height[start] <= height[end]) {
        i = start;
        while (height[i] <= height[start] && i < end) {
          water = water - height[i];
          i++;
        }
        start = i;
      }
      if (height[end] <= height[j]) {
        i = end;
        while (height[i] <= height[end] && i > start) {
          water = water - height[i];
          i--;
        }
        end = i;
      }
    }
    if (start == end) {
      water = water - min;
    }
    return water;
  }

  public static void main(String[] args) {
    Cane42 cane42 = new Cane42();
    System.out.println(cane42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
  }
}
