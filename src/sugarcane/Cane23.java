package sugarcane;

import java.util.Arrays;

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

public class Cane23 {
  public static void main(String[] args) {
    Cane23 cane23 = new Cane23();
    cane23.mergeKLists(
        new ListNode[] {
          new ListNode(2, new ListNode(6)),
          new ListNode(1, new ListNode(4, new ListNode(5))),
          new ListNode(1, new ListNode(3, new ListNode(4)))
        });
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length < 1) {
      return null;
    }
    boolean flag = true;
    while (flag) {
      flag = false;
      Arrays.sort(
          lists,
          (t1, t2) -> {
            if (t1 != null && t2 != null) {
              return Integer.compare(t1.val, t2.val);
            } else if (t1 == null && t2 == null) {
              return 0;
            } else if (t1 == null) {
              return 1;
            } else {
              return -1;
            }
          });
      for (int i = lists.length - 2; i > -1; i--) {
        if (lists[i] != null && lists[i + 1] != null) {
          flag = true;
          ListNode orgPtr = lists[i];
          ListNode prevPtr = null;
          while (lists[i] != null && lists[i].val <= lists[i + 1].val) {
            prevPtr = lists[i];
            lists[i] = lists[i].next;
          }
          if (prevPtr != null) {
            prevPtr.next = lists[i + 1];
            ListNode nxtPtr = prevPtr;
            if (lists[i] == null) {
              lists[i + 1] = null;
            } else {
              while (nxtPtr != null && nxtPtr.val <= lists[i].val) {
                prevPtr = nxtPtr;
                nxtPtr = nxtPtr.next;
              }
              lists[i + 1] = prevPtr.next;
              prevPtr.next = lists[i];
            }
            lists[i] = orgPtr;
          }
        }
      }
    }
    return lists[0];
  }
}
