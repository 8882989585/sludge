package leetcode;

public class Cane814 {

  public static void main(String[] args) {
    Cane814 cane814 = new Cane814();
    cane814.pruneTree(
        new TreeNode(
            1, null, new TreeNode(0, new TreeNode(0, null, null), new TreeNode(1, null, null))));
  }

  public boolean pruneTreeHelper(TreeNode root) {
    boolean tmp1 = false, tmp2 = false;
    if (root.left != null) {
      tmp1 = pruneTreeHelper(root.left);
      if (!tmp1) {
        root.left = null;
      }
    }
    if (root.right != null) {
      tmp2 = pruneTreeHelper(root.right);
      if (!tmp2) {
        root.right = null;
      }
    }
    return tmp1 || tmp2 || root.val == 1;
  }

  public TreeNode pruneTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    return pruneTreeHelper(root) ? root : null;
  }
}
