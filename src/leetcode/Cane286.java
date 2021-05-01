package leetcode;

import java.util.LinkedList;

public class Cane286 {

  class Node286 {
    int i;
    int j;
    int n;

    public Node286(int i, int j, int n) {
      this.i = i;
      this.j = j;
      this.n = n;
    }
  }

  public int[][] calcPath(int[][] rooms, int i, int j) {
    LinkedList<Node286> linkedList = new LinkedList<>();
    linkedList.add(new Node286(i, j, 0));
    while (!linkedList.isEmpty()) {
      Node286 temp = linkedList.removeFirst();
      if (temp.i - 1 > -1 && rooms[temp.i - 1][temp.j] > temp.n+1) {
        rooms[temp.i - 1][temp.j] = temp.n + 1;
        linkedList.add(new Node286(temp.i - 1, temp.j, temp.n + 1));
      }
      if (temp.i + 1 < rooms.length && rooms[temp.i + 1][temp.j] > temp.n+1) {
        rooms[temp.i + 1][temp.j] = temp.n + 1;
        linkedList.add(new Node286(temp.i + 1, temp.j, temp.n + 1));
      }
      if (temp.j - 1 > -1 && rooms[temp.i][temp.j - 1] > temp.n+1) {
        rooms[temp.i][temp.j - 1] = temp.n + 1;
        linkedList.add(new Node286(temp.i, temp.j - 1, temp.n + 1));
      }
      if (temp.j + 1 < rooms[0].length && rooms[temp.i][temp.j + 1] > temp.n+1) {
        rooms[temp.i][temp.j + 1] = temp.n + 1;
        linkedList.add(new Node286(temp.i, temp.j + 1, temp.n + 1));
      }
    }
    return rooms;
  }

  public void wallsAndGates(int[][] rooms) {
    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[0].length; j++) {
          if(rooms[i][j] == 0) {
            rooms = calcPath(rooms, i, j);
          }
      }
    }
    return;
  }

  public static void main(String[] args) {
    Cane286 cane286 = new Cane286();
    cane286.wallsAndGates(new int[][]
        {
            {2147483647, -1, 0, 2147483647},
            {2147483647, 2147483647, 2147483647, -1},
            {2147483647, -1, 2147483647, -1},
            {0, -1, 2147483647, 2147483647}
        });
  }
}
