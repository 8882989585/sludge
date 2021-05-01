package leetcode;

import java.util.PriorityQueue;

public class Cane1167 {

  public static void main(String[] args) {
    //
    Cane1167 cane1167 = new Cane1167();
//    System.out.println(cane1167.connectSticks(new int[] {1, 8, 3, 5}));
    System.out.println(
        cane1167.connectSticks(
            new int[] {3354, 4316, 3259, 4904, 4598, 474, 3166, 6322, 8080, 9009}));
    System.out.println(
            cane1167.connectSticks(
                    new int[] {3354}));
  }

  public int connectSticks(int[] sticks) {
    int res = 0, c = 0;
    if(sticks.length < 2) {
      return 0;
    }
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Integer::compareTo);
    for (int stick : sticks) {
      priorityQueue.add(stick);
    }
    while (!priorityQueue.isEmpty()) {
      c = priorityQueue.poll();
      if (!priorityQueue.isEmpty()) {
        c += priorityQueue.poll();
      }
      res += c;
      if (priorityQueue.isEmpty()) {
        return res;
      } else {
        priorityQueue.add(c);
      }
    }
    return res;
  }
}
