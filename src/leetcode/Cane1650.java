package leetcode;

import java.util.HashSet;

public class Cane1650 {

  public Node lowestCommonAncestor(Node p, Node q) {
    HashSet<Integer> nodes = new HashSet<>();
    while (p != null) {
      nodes.add(p.val);
      p = p.parent;
    }
    while (q != null) {
      if (nodes.contains(q.val)) {
        return q;
      } else {
        q = q.parent;
      }
    }
    return null;
  }

  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
  }
}
