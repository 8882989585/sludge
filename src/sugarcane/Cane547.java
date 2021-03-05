package sugarcane;

import java.util.LinkedList;

public class Cane547 {

  public static void main(String[] args) {
    //
    Cane547 cane547 = new Cane547();
    cane547.findCircleNum(new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
  }

  private void bfs(int[][] isConnected, int i) {
    LinkedList<Integer> iList = new LinkedList<>();
    iList.add(i);
    while (!iList.isEmpty()) {
      int t = iList.removeFirst();
      for (int j = 0; j < isConnected[0].length; j++) {
        if (isConnected[t][j] == 1) {
          isConnected[t][j] = -1;
          isConnected[j][t] = -1;
          if (t != j) iList.add(j);
        }
      }
    }
  }

  public int findCircleNum(int[][] isConnected) {
    int result = 0;
    for (int i = 0; i < isConnected.length; i++) {
      for (int j = 0; j < isConnected[0].length; j++) {
        if (isConnected[i][j] == 1) {
          result++;
          bfs(isConnected, i);
        }
      }
    }
    return result;
  }
}
