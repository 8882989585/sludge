package sugarcane;

import java.util.Objects;

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

public class Cane114 {

  public void flatten(TreeNode root) {
    TreeNode itr = root;
    while (itr != null) {
      if (itr.left != null && itr.right != null) {
        TreeNode mostRight = itr.left;
        while (mostRight.right != null) {
          mostRight = mostRight.right;
        }
        mostRight.right = itr.right;
        itr.right = itr.left;
        itr.left = null;
      } else if (itr.left != null) {
        itr.right = itr.left;
        itr.left = null;
      }
      itr = itr.right;
    }
  }

  public static void main(String[] args) {
    Cane114 cane114 = new Cane114();
    cane114.flatten(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
        new TreeNode(5, null, new TreeNode(6))));

    if (Objects.nonNull(cane114) ? true : false) {

    }
  }
}
