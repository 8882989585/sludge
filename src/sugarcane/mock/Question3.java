package sugarcane.mock;

public class Question3 {

  public static void main(String[] args) {
    //
      Question3 question3 = new Question3();
      question3.xx();
  }

  public void xx(){
      mergeTwoLists(
              new ListNode(1, new ListNode(1, new ListNode(6, new ListNode(8, null)))),
              new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))))
              );
  }
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode itr;
    if (l1.val > l2.val) {
      itr = l2;
      l2 = l1;
      l1 = itr;
    }
    itr = l1;
    ListNode prevItr = l1, prevItr2 = l2;
    while (l1 != null && l2 != null) {
      while (l1 != null && l1.val <= l2.val) {
        prevItr = l1;
        l1 = l1.next;
      }
      prevItr.next = l2;
        boolean flag = true;
      while (l2 != null && l1 != null && l2.val < l1.val) {
        flag = false;
          prevItr2 = l2;
        l2 = l2.next;
      }
      if (!flag) {
        prevItr2.next = l1;
      }
    }
    return itr;
  }

  class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
