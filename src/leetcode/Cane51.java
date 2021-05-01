package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cane51 {

  public static void main(String[] args) {
    Cane51 cane51 = new Cane51();
    int n = 10;
    System.out.println(cane51.solveNQueens(n));
  }

  public List<String> createResult(int[][] matrix) {
    List<String> res = new ArrayList<>();
    for (int[] ints : matrix) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < matrix.length; j++) {
        if (ints[j] == 1) {
          sb.append("Q");
        } else {
          sb.append(".");
        }
      }
      res.add(sb.toString());
    }
    return res;
  }

  public int[][] captureLocations(int[][] matrix, int i, int j) {
    for (int n = 0; n < matrix[0].length; n++) {
      if (matrix[i][n] != 1) {
        matrix[i][n] = -1;
      }
    }
    for (int m = 0; m < matrix.length; m++) {
      if (matrix[m][j] != 1) {
        matrix[m][j] = -1;
      }
    }
    int m = i, n = j;
    while (m > -1 && n > -1) {
      if (matrix[m][n] != 1) {
        matrix[m][n] = -1;
      }
      m--;
      n--;
    }
    m = i;
    n = j;
    while (m < matrix.length && n < matrix[0].length) {
      if (matrix[m][n] != 1) {
        matrix[m][n] = -1;
      }
      m++;
      n++;
    }
    m = i;
    n = j;
    while (m > -1 && n < matrix[0].length) {
      if (matrix[m][n] != 1) {
        matrix[m][n] = -1;
      }
      m--;
      n++;
    }
    m = i;
    n = j;
    while (m < matrix.length && n > -1) {
      if (matrix[m][n] != 1) {
        matrix[m][n] = -1;
      }
      m++;
      n--;
    }
    return matrix;
  }

  //  public List<List<String>> solveNQueens(int n) {}

  public List<List<String>> solveNQueens(int n) {
    LinkedList<Node> itr = new LinkedList<>();
    itr.add(new Node(0, new int[n][n], 0));
    List<List<String>> res = new ArrayList<>();
    while (!itr.isEmpty()) {
      Node tmp = itr.pop();
      if (tmp.i < n) {
        for (int j = 0; j < n; j++) {
          if (tmp.matrix[tmp.i][j] == 0) {
            int[][] newMatrix =
                java.util.Arrays.stream(tmp.matrix)
                    .map(int[]::clone)
                    .toArray($ -> tmp.matrix.clone());
            newMatrix[tmp.i][j] = 1;
            if (tmp.queenNo == n - 1) {
              res.add(createResult(newMatrix));
            }
            newMatrix = captureLocations(newMatrix, tmp.i, j);
            itr.add(new Node(tmp.queenNo + 1, newMatrix, tmp.i + 1));
          }
        }
      }
    }
    return res;
  }

  class Node {
    int queenNo;
    int[][] matrix;
    int i;

    public Node(int queenNo, int[][] matrix, int i) {
      this.queenNo = queenNo;
      this.matrix = matrix;
      this.i = i;
    }
  }
}
