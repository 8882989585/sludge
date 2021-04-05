package sugarcane;

import java.util.*;

//Passes only half the cases
public class Cane545 {

  public static void main(String[] args) {
    Cane545 cane545 = new Cane545();
    cane545.boundaryOfBinaryTree(
        new TreeNode(
            1, null, new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null))));
  }

  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    LinkedList<Node> nodes = new LinkedList<>();
    nodes.add(new Node(root, 0, 'L'));
    LinkedHashMap<Integer, Character> set = new LinkedHashMap<>();
    Node lastNode = null;
    while (!nodes.isEmpty()) {
      Node tmp = nodes.removeFirst();
      if (lastNode == null) {
        set.put(tmp.treeNode.val, 'L');
      } else if (lastNode.level != tmp.level) {
        set.putIfAbsent(lastNode.treeNode.val, 'R');
        set.putIfAbsent(tmp.treeNode.val, tmp.child);
      }
      if (tmp.treeNode.left != null) {
        nodes.add(new Node(tmp.treeNode.left, tmp.level + 1, 'L'));
      }
      if (tmp.treeNode.right != null) {
        nodes.add(new Node(tmp.treeNode.right, tmp.level + 1, 'R'));
      }
      lastNode = tmp;
    }
    nodes = new LinkedList<>();
    nodes.add(new Node(root, 0, 'L'));
    while (!nodes.isEmpty()) {
      Node tmp = nodes.removeLast();
      if (tmp.treeNode.right == null && tmp.treeNode.left == null) {
        set.putIfAbsent(tmp.treeNode.val, 'B');
      }
      if (tmp.treeNode.right != null) {
        nodes.add(new Node(tmp.treeNode.right, tmp.level + 1, 'R'));
      }
      if (tmp.treeNode.left != null) {
        nodes.add(new Node(tmp.treeNode.left, tmp.level + 1, 'L'));
      }
    }
    nodes.add(new Node(root, 0, 'L'));
    LinkedList<Integer> result = new LinkedList<>();
    for (Map.Entry<Integer, Character> entry : set.entrySet()) {
      if (entry.getValue() == 'L') {
        result.add(entry.getKey());
      }
    }
    for (Map.Entry<Integer, Character> entry : set.entrySet()) {
      if (entry.getValue() == 'B') {
        result.add(entry.getKey());
      }
    }
    ArrayList<Integer> list = new ArrayList<>(set.keySet());
    Collections.reverse(list);
    for (Integer i : list) {
      if (set.get(i) == 'R') {
        result.add(i);
      }
    }
    return result;
  }

  class Node {
    TreeNode treeNode;
    int level;
    char child;

    public Node(TreeNode treeNode, int level, char child) {
      this.treeNode = treeNode;
      this.level = level;
      this.child = child;
    }
  }
}
