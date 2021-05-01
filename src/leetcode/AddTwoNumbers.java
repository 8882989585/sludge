package leetcode;

//Alternative solution
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int carry = 0;
//        ListNode previous = new ListNode(0, null);
//        ListNode start = previous;
//        while (l1 != null || l2 != null || carry != 0) {
//            int value = 0;
//            if (l1 != null) {
//                value += l1.val;
//                l1 = l1.next;
//            }
//            if (l2 != null) {
//                value += l2.val;
//                l2 = l2.next;
//            }
//            value += carry;
//            previous.next = new ListNode(value % 10, null);
//            previous = previous.next;
//            carry = value / 10;
//        }
//        return start.next;
//    }
//}


//You are given two non-empty linked lists representing two non-negative integers.
//The digits are stored in reverse order, and each of their nodes contains a single digit.
//Add the two numbers and return the sum as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//Example 1:
//
//
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//Example 2:
//
//Input: l1 = [0], l2 = [0]
//Output: [0]
//Example 3:
//
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]


class ListNodeCane2 {
    int val;
    ListNodeCane2 next;

    ListNodeCane2() {
    }

    ListNodeCane2(int val) {
        this.val = val;
    }

    ListNodeCane2(int val, ListNodeCane2 next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNodeCane2 l1 = new ListNodeCane2(9);
        l1.next = new ListNodeCane2(9);
        l1.next.next = new ListNodeCane2(9);
        ListNodeCane2 l2 = new ListNodeCane2(9);
        l2.next = new ListNodeCane2(9);
        l2.next.next = new ListNodeCane2(9);
        addTwoNumbers.addTwoNumbers(l1, l2);
    }

    public ListNodeCane2 addTwoNumbers(ListNodeCane2 l1, ListNodeCane2 l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0, tmp;
        ListNodeCane2 itr1 = l1, itr2 = l2, prev = l1;
        while (itr1.val != 0 || itr2.val != 0 || carry != 0 || itr1.next != null || itr2.next != null) {
            prev = itr1;
            tmp = itr1.val + itr2.val + carry;
            carry = tmp / 10;
            itr1.val = tmp % 10;
            if (itr1.next == null) {
                itr1.next = new ListNodeCane2(0);
            }
            if (itr2.next == null) {
                itr2.next = new ListNodeCane2(0);
            }
            itr1 = itr1.next;
            itr2 = itr2.next;
        }
        if (prev.next != null && prev.next.val == 0) {
            prev.next = null;
        }
        return l1;
    }
}

