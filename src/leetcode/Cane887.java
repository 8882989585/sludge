package leetcode;

public class Cane887 {

  public static void main(String[] args) {
    //
    Cane887 cane887 = new Cane887();
    //    System.out.println(cane887.superEggDrop(3, 9));
    System.out.println(cane887.superEggDrop(10, 100));
  }

  public int superEggDrop(int k, int n) {
    int[][] moves = new int[n + 1][k + 1];
    int move = 0;
    while (moves[move][k] < n) {
      ++move;
      for (int i = 1; i <= k; i++) {
        moves[move][i] = moves[move - 1][i] + moves[move - 1][i - 1] + 1;
      }
    }
    return move;
  }

}
