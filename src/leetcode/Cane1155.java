package leetcode;

public class Cane1155 {

  public static void main(String[] args) {
    //
    Cane1155 cane1155 = new Cane1155();
    cane1155.numRollsToTarget(3, 3, 8);
  }

  public int numRollsToTarget(int d, int f, int target) {
    int[][] arr = new int[d + 1][target + 1];
    arr[0][0] = 1;
    for (int i = 1; i <= d; i++) {
      for (int j = i; j <= target; j++) {
        for (int k = 1; k <= f; k++) {
          if (j - k >= 0) {
            arr[i][j] = arr[i][j] + arr[i - 1][j - k] % 100_000_000_7;
          }
        }
      }
    }
    return arr[d][target];
  }
}
