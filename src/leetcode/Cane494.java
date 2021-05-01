package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class Cane494 {

  public static void main(String[] args) {
    //
    Cane494 cane494 = new Cane494();
    System.out.println(cane494.findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3));
  }

  public int findTargetSumWays(int[] nums, int S) {
    int counter = 0;
    HashMap<String, Node> map = new HashMap<>();
    LinkedList<Node> nodes = new LinkedList<>();
    nodes.add(new Node(0, -1, 1));
    while (!nodes.isEmpty()) {
      Node tmp1 = nodes.removeFirst();
      if (tmp1.sum == S && tmp1.i == nums.length - 1) {
        counter += tmp1.weight;
      } else {
        if (tmp1.i + 1 < nums.length) {
          Node tmp2 = map.get(tmp1.sum + nums[tmp1.i + 1] + "-" + tmp1.i + 1);
          if (tmp2 != null) {
            tmp2.weight += tmp1.weight;
          } else {
            Node tmp3 = new Node(tmp1.sum + nums[tmp1.i + 1], tmp1.i + 1, tmp1.weight);
            nodes.add(tmp3);
            map.put(tmp1.sum + nums[tmp1.i + 1] + "-" + tmp1.i + 1, tmp3);
          }
          tmp2 = map.get(tmp1.sum + -1 * (nums[tmp1.i + 1]) + "-" + tmp1.i + 1);
          if (tmp2 != null) {
            tmp2.weight += tmp1.weight;
          } else {
            Node tmp3 = new Node(tmp1.sum + -1 * (nums[tmp1.i + 1]), tmp1.i + 1, tmp1.weight);
            nodes.add(tmp3);
            map.put(tmp1.sum + -1 * (nums[tmp1.i + 1]) + "-" + tmp1.i + 1, tmp3);
          }
        }
      }
    }
    return counter;
  }

  class Node {
    int sum;
    int weight;
    int i;

    public Node(int sum, int i, int weight) {
      this.sum = sum;
      this.i = i;
      this.weight = weight;
    }
  }
}
