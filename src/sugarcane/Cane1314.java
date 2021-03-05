package sugarcane;

public class Cane1314 {
  public static void main(String[] args) {
    Cane1314 cane1314 = new Cane1314();
    cane1314.matrixBlockSum(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1);
  }

  public int[][] matrixBlockSum(int[][] mat, int K) {
    int[][] res = new int[mat.length][mat[0].length];
    for (int i = 1; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        mat[i][j] = mat[i][j] + mat[i - 1][j];
      }
    }
    for (int i = 0; i < mat.length; i++) {
      for (int j = 1; j < mat[i].length; j++) {
        mat[i][j] = mat[i][j] + mat[i][j - 1];
      }
    }
    int p, q, r, s = -1;
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        p = i - K;
        q = i + K;
        r = j - K;
        s = j + K;
        if (q >= mat.length) {
          q = mat.length - 1;
        }
        if (s >= mat[i].length) {
          s = mat[i].length - 1;
        }
        res[i][j] = mat[q][s];
        if (p > 0) {
          res[i][j] -= mat[p - 1][s];
        }
        if (r > 0) {
          res[i][j] -= mat[q][r - 1];
        }
        if (p > 0 && r > 0) {
          res[i][j] += mat[p - 1][r - 1];
        }
      }
    }
    return res;
  }
}
