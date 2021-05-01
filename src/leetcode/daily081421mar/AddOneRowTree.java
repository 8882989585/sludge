package leetcode.daily081421mar;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class AddOneRowTree {

  public TreeNode addOneRow(TreeNode root, int v, int d) {
      if(root == null) {
          return null;
      }
      if(d==1) {
          return new TreeNode(v, root, null);
      }
      LinkedList<Node> nodes = new LinkedList<>();
      nodes.add(new Node(root, 1));
      while (!nodes.isEmpty()) {
          Node node = nodes.removeFirst();
          if(node.level == d-1) {
              TreeNode tmp = node.node.left;
              node.node.left = new TreeNode(v, tmp, null);
              tmp = node.node.right;
              node.node.right = new TreeNode(v, null, tmp);
          } else {
              if(node.node.left!=null) {
                  nodes.add(new Node(node.node.left, node.level+1));
              }
              if(node.node.right!=null) {
                  nodes.add(new Node(node.node.right, node.level+1));
              }
          }
      }
      return root;
  }



  public class Node {
      TreeNode node;
      int level;

      public Node(TreeNode node, int level) {
          this.node = node;
          this.level = level;
      }
  }

  public static void main(String[] args) {
      AddOneRowTree aort = new AddOneRowTree();
      aort.addOneRow(new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), new TreeNode(6,new TreeNode(5), null)), 1, 2);
  }
}
