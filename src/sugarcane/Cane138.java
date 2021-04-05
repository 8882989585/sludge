package sugarcane;

public class Cane138 {

  public static void main(String[] args) {
    //
    Cane138 cane138 = new Cane138();
    cane138.runner();
  }

  public Node runner() {
    Node node5 = new Node(1);
    Node node4 = new Node(10);
    node4.next = node5;
    Node node3 = new Node(11);
    node3.next = node4;
    Node node2 = new Node(13);
    node2.next = node3;
    Node node1 = new Node(7);
    node1.next = node2;
    node2.random = node1;
    node3.random = node5;
    node4.random = node3;
    node5.random = node1;

    return copyRandomList(node1);
  }

  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }
    Node itr = head;
    while (itr != null) {
      Node tmp = new Node(itr.val);
      tmp.next = itr.next;
      tmp.random = itr.random;
      itr.next = tmp;
      itr = itr.next.next;
    }
    Node res = head.next;
    itr = head;
    while (itr != null) {
      Node tmp1 = itr.next;
      itr = itr.next.next;
      if (tmp1.random != null) {
        tmp1.random = tmp1.random.next;
      }
    }
    itr = head;
    while (itr != null) {
      Node tmp1 = itr.next;
      Node tmp2 = itr;
      itr = itr.next.next;
      Node tmp3 = tmp1.next;
      if (tmp1.next != null) {
        tmp1.next = tmp1.next.next;
      }
      tmp2.next = tmp3;
    }
    return res;
  }

  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}
