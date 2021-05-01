package leetcode;

import java.util.List;

public class Cane1428 {

  public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    Integer[] dimensions = binaryMatrix.dimensions().toArray(new Integer[] {});
    int min = dimensions[1];
    for (int i = 0; i < dimensions[0]; i++) {
      int m = 0, n = dimensions[1] - 1;
      boolean flag = false;
      while (m <= n) {
        int mid = (m + n) / 2;
        if (binaryMatrix.get(i, mid) == 0) {
          m = mid + 1;
        } else {
          n = mid;
        }
        if (m == n && binaryMatrix.get(i, m) == 1) {
          flag = true;
          break;
        }
      }
      if (flag && min > m) {
        min = m;
      }
    }
    if (min != dimensions[1]) {
      return min;
    }
    return -1;
  }

  interface BinaryMatrix {
    int get(int row, int col);

    List<Integer> dimensions();
  }
}
