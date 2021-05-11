package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class Cane174 {

  public static void main(String[] args) {
    Cane174 cane174 = new Cane174();
    cane174.calculateMinimumHP(new int[][] {{1, -2, 3}, {2, -2, -2}});
  }

  public int calculateMinimumHP(int[][] dungeon) {
    int[][] runSum = new int[dungeon.length][dungeon[0].length];
    int[][] minSum = new int[dungeon.length][dungeon[0].length];

    for (int i = 0; i < dungeon.length; i++) {
      Arrays.fill(runSum[i], Integer.MIN_VALUE);
      Arrays.fill(minSum[i], Integer.MAX_VALUE);
    }

    runSum[0][0] = dungeon[0][0];
    minSum[0][0] = dungeon[0][0] <= 0 ? (dungeon[0][0] * -1) + 1 : 1;

    for (int i = 0; i < dungeon.length; i++) {
      for (int j = 0; j < dungeon[0].length; j++) {
        if (i + 1 < dungeon.length && runSum[i][j] + dungeon[i + 1][j] > runSum[i + 1][j]) {
          runSum[i + 1][j] = runSum[i][j] + dungeon[i + 1][j];
          minSum[i + 1][j] =
              Math.min(
                  minSum[i + 1][j],
                  Math.max(runSum[i + 1][j] <= 0 ? (runSum[i + 1][j] * -1) + 1 : 1, minSum[i][j]));
        }
        if (j + 1 < dungeon[0].length && runSum[i][j] + dungeon[i][j + 1] > runSum[i][j + 1]) {
          runSum[i][j + 1] = runSum[i][j] + dungeon[i][j + 1];
          minSum[i][j + 1] =
              Math.min(
                  minSum[i][j + 1],
                  Math.max(runSum[i][j + 1] <= 0 ? (runSum[i][j + 1] * -1) + 1 : 1, minSum[i][j]));
        }
      }
    }
    return minSum[dungeon.length - 1][dungeon[0].length - 1];
  }
}
