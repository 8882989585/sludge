package leetcode;

import java.util.*;

public class Cane1326 {

  public static void main(String[] args) {
    //
    Cane1326 cane1326 = new Cane1326();
//    System.out.println(cane1326.minTaps(7, new int[] {1, 2, 1, 0, 2, 1, 0, 1}));
//    System.out.println(cane1326.minTaps(8, new int[] {4, 0, 0, 0, 4, 0, 0, 0, 4}));
//    System.out.println(cane1326.minTaps(8, new int[] {4, 0, 0, 0, 0, 0, 0, 0, 4}));
//    System.out.println(cane1326.minTaps(9, new int[] {0, 5, 0, 3, 3, 3, 1, 4, 0, 4}));
    System.out.println(cane1326.minTaps(35, new int[]{1,0,4,0,4,1,4,3,1,1,1,2,1,4,0,3,0,3,0,3,0,5,3,0,0,1,2,1,2,4,3,0,1,0,5,2}));
  }

  public int minTaps(int n, int[] A) {
    LinkedList<Node> linkedList = new LinkedList<>();
    for (int i = 0; i <= n; i++) {
      if (A[i] != 0) {
        linkedList.add(new Node(i, A[i], n));
      }
    }
    linkedList.sort(
        (node1, node2) -> {
          if (node1.s < node2.s) {
            return -1;
          } else if (node1.s == node2.s) {
            return -1 * Integer.compare(node1.r, node2.r);
          } else {
            return 1;
          }
        });
    int counter = 0;
    while (!linkedList.isEmpty()) {
      counter++;
      Node node = linkedList.removeFirst();
      Node maxEnd = null;
      if (node.e == n) {
        return counter;
      }
      while (!linkedList.isEmpty()) {
        Node innerNode = linkedList.getFirst();
        if (innerNode.s <= node.e) {
          linkedList.removeFirst();
          if (innerNode.e > node.e && (maxEnd == null || maxEnd.e < innerNode.e)) {
            maxEnd = innerNode;
            if (maxEnd.e == n) {
              return ++counter;
            }
          }
        } else if (maxEnd == null) {
          return -1;
        } else {
          linkedList.addFirst(maxEnd);
          break;
        }
      }
    }
    return -1;
  }

  class Node {
    int t;
    int s;
    int e;
    int r;

    public Node(int t, int r, int n) {
      this.t = t;
      this.r = r;
      this.s = t - r;
      if (this.s < 0) {
        this.s = 0;
      }
      this.e = t + r;
      if (this.e > n) {
        this.e = n;
      }
      this.r = e - s + 1;
    }
  }
}
