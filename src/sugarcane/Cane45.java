package sugarcane;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Cane45 {

  public static void main(String[] args) {
    //
    Cane45 cane45 = new Cane45();
    System.out.println(cane45.jump(new int[] {2, 3, 1, 1, 4}));
  }

  public int jump(int[] nums) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    int minJumps = Integer.MAX_VALUE;
    LinkedList<Node> itr = new LinkedList<>();
    itr.add(new Node(0, 0));
    while (!itr.isEmpty()) {
      Node tmp = itr.removeFirst();
      if (tmp.position == nums.length - 1) {
        if (tmp.jumps < minJumps) {
          minJumps = tmp.jumps;
        }
      } else {
        for (int j = 1; j <= nums[tmp.position]; j++) {
          if (tmp.position + j < nums.length) {
            Integer tmpJumps = hashMap.get(tmp.position + j);
            if (tmpJumps == null || tmp.jumps + 1 < tmpJumps) {
              itr.add(new Node(tmp.jumps + 1, tmp.position + j));
              hashMap.put(tmp.position + j, tmp.jumps + 1);
            }
          }
        }
      }
    }
    return minJumps;
  }

  class Node {
    int jumps;
    int position;

    public Node(int jumps, int position) {
      this.jumps = jumps;
      this.position = position;
    }
  }
}
