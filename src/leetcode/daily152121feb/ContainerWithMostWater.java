package leetcode.daily152121feb;

public class ContainerWithMostWater {
  public static void main(String[] args) {
    //
    ContainerWithMostWater cwmw = new ContainerWithMostWater();
    System.out.println(cwmw.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }

  public int maxArea(int[] height) {
    if (height.length < 2) {
      return 0;
    }
    int i = 0, j = height.length - 1, max = -1, area = -1;
    while (i < j) {
      area = Math.min(height[i], height[j]) * (j - i);
      if (area > max) {
        max = area;
      }
      if (height[i] > height[j]) {
        j--;
      } else {
        i++;
      }
    }
    return max;
  }
}
