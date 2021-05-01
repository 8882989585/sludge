package leetcode;

public class Cane333 {

  public int[] solution(TreeNode root) {
    if (root.left == null && root.right == null) {
      return new int[] {1, 1};
    }
    boolean flag = true;
    int[] leftChild = new int[] {0, 1};
    int[] rightChild = new int[] {0, 1};
    if (root.left != null) {
      leftChild = solution(root.left);
      if (root.left.val > root.val) {
        flag = false;
      }
    }
    if (root.right != null) {
      rightChild = solution(root.right);
      if (root.right.val <= root.val) {
        flag = false;
      }
    }
    if (flag) {
      if (leftChild[1] == 0 || rightChild[1] == 0) {
        return new int[] {Math.max(leftChild[0], rightChild[0]), 0};
      } else {
        return new int[] {leftChild[0] + rightChild[0] + 1, 1};
      }
    } else {
      return new int[] {Math.max(leftChild[0], rightChild[0]), 0};
    }
  }

  public int largestBSTSubtree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return solution(root)[0];
  }
}
