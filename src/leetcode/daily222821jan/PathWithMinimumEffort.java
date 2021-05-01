package leetcode.daily222821jan;

import java.util.Arrays;

public class PathWithMinimumEffort {

  public int minimumEffortPath(int[][] heights) {
    int[][] weights = new int[heights.length][heights[0].length];
    for (int[] row : weights) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    weights[0][0] = 0;
    for (int i = 0; i < heights.length; i++) {
      for (int j = 0; j < heights[0].length; j++) {
        if (i + 1 < heights.length) {
          weights[i + 1][j] = Math
              .min(weights[i + 1][j], Math.abs(heights[i][j] - heights[i + 1][j]));
        }
        if (j + 1 < heights[0].length) {
          weights[i][j + 1] = Math
              .min(weights[i][j + 1], Math.abs(heights[i][j] - heights[i][j + 1]));
        }
      }
    }
    for (int i = 0; i < weights.length; i++) {
      for (int j = 0; j < weights[0].length; j++) {
        Integer min = null;
        if (i - 1 >= 0 && j - 1 >= 0) {
          min = Math.min(weights[i - 1][j], weights[i][j - 1]);
        } else if (i - 1 >= 0) {
          min = weights[i - 1][j];
        } else if (j - 1 >= 0) {
          min = weights[i][j - 1];
        }
        if (min != null) {
          weights[i][j] = Math.max(weights[i][j], min);
        }
      }
    }
    return weights[heights.length - 1][heights[0].length - 1];
  }

  public static void main(String[] args) {
    PathWithMinimumEffort pwme = new PathWithMinimumEffort();
//    System.out.println(pwme.minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
//    System.out.println(pwme.minimumEffortPath(
//        new int[][]{{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1},
//            {1, 1, 1, 2, 1}}));
//    System.out.println(pwme.minimumEffortPath(new int[][]{{1, 10, 6, 7, 9, 10, 4, 9}}));
    System.out.println(pwme.minimumEffortPath(
        new int[][]{{4, 3, 4, 10, 5, 5, 9, 2}, {10, 8, 2, 10, 9, 7, 5, 6},
            {5, 8, 10, 10, 10, 7, 4, 2}, {5, 1, 3, 1, 1, 3, 1, 9}, {6, 4, 10, 6, 10, 9, 4, 6}}));
  }
}
