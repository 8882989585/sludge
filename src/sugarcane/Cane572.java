package sugarcane;

import java.util.LinkedList;

public class Cane572 {

  public boolean checkSubtree(TreeNode s, TreeNode t) {
    LinkedList<TreeNode> list1 = new LinkedList<>();
    LinkedList<TreeNode> list2 = new LinkedList<>();
    list1.add(s);
    list2.add(t);
    while (!list1.isEmpty() && !list2.isEmpty()) {
      TreeNode tmp1 = list1.removeFirst();
      TreeNode tmp2 = list2.removeFirst();
      if (tmp1.val != tmp2.val
          || (tmp1.left != null && tmp2.left == null)
          || (tmp1.left == null && tmp2.left != null)
          || (tmp1.right != null && tmp2.right == null)
          || (tmp1.right == null && tmp2.right != null)) {
        return false;
      }
      if (tmp1.left != null) {
        list1.add(tmp1.left);
      }
      if (tmp1.right != null) {
        list1.add(tmp1.right);
      }
      if (tmp2.left != null) {
        list2.add(tmp2.left);
      }
      if (tmp2.right != null) {
        list2.add(tmp2.right);
      }
    }
    return list1.isEmpty() && list2.isEmpty();
  }

  public boolean isSubtree(TreeNode s, TreeNode t) {
    LinkedList<TreeNode> list = new LinkedList<>();
    list.add(s);
    while (!list.isEmpty()) {
      TreeNode tmp = list.removeFirst();
      if (tmp.val == t.val) {
        boolean res = checkSubtree(tmp, t);
        if (res) {
          return true;
        }
      }
      if (tmp.left != null) {
        list.add(tmp.left);
      }
      if (tmp.right != null) {
        list.add(tmp.right);
      }
    }
    return false;
  }
}
