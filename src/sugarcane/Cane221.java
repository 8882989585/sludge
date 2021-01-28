package sugarcane;

public class Cane221 {

  public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    boolean[][] truth = new boolean[matrix.length][matrix[0].length];
    boolean[][] runTruth = new boolean[matrix.length][matrix[0].length];
    int max = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '1') {
          truth[i][j] = true;
          max = 1;
        }
      }
    }
    int maxSquare = Math.min(matrix.length, matrix[0].length);
    for (int i = 2; i <= maxSquare; i++) {
      for (int j = i - 1; j < matrix.length; j++) {
        for (int k = i - 1; k < matrix[0].length; k++) {
          runTruth[j][k] = truth[j][k] && truth[j - 1][k] && truth[j][k - 1] && truth[j - 1][k - 1];
          if (runTruth[j][k] && i > max) {
            max = i;
          }
        }
      }
      truth = runTruth;
      runTruth = new boolean[matrix.length][matrix[0].length];
    }
    return max * max;
  }

  public static void main(String[] args) {
    Cane221 cane221 = new Cane221();
//    System.out.println(cane221.maximalSquare(
//        new char[][]{
//            {'1', '0', '1', '0', '0'},
//            {'1', '0', '1', '1', '1'},
//            {'1', '1', '1', '1', '1'},
//            {'1', '0', '0', '1', '0'}}));
    System.out.println(cane221.maximalSquare(
        new char[][]{
            {'0', '0', '0', '1'},
            {'1', '1', '0', '1'},
            {'1', '1', '1', '1'},
            {'0', '1', '1', '1'},
            {'0', '1', '1', '1'}}
    ));


  }

}
