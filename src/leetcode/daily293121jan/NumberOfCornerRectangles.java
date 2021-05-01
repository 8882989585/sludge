package leetcode.daily293121jan;

public class NumberOfCornerRectangles {

  public int scanCorners(int[][] grid, int r, int c) {
    int count = 0;
    for (int i = r + 1; i < grid.length; i++) {
      if (grid[i][c] == 1) {
        for (int j = c + 1; j < grid[0].length; j++) {
          if (grid[r][j] == 1 && grid[i][j] == 1) {
            count++;
          }
        }
      }
    }
    return count;
  }

  public int countCornerRectangles(int[][] grid) {
    if (grid.length < 2 || grid[0].length < 2) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          count += scanCorners(grid, i, j);
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    NumberOfCornerRectangles ncr = new NumberOfCornerRectangles();
    System.out.println(ncr.countCornerRectangles(
        new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));
    System.out.println(ncr.countCornerRectangles(
        new int[][]{{1, 0, 0, 1, 0}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 0, 1}}));
    System.out.println(ncr.countCornerRectangles(
        new int[][]{{1, 0, 1}, {0, 1, 1}, {1, 1, 1}, {1, 0, 1}}));
  }
}
