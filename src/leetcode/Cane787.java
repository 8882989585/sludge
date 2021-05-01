package leetcode;

import java.util.*;

public class Cane787 {

  public static void main(String[] args) {
    //
      Cane787 cane787 = new Cane787();
      System.out.println(cane787.findCheapestPrice(10, new int[][]{{3,4,4},{2,5,6},{4,7,10},{9,6,5},{7,4,4},{6,2,10},{6,8,6},{7,9,4},{1,5,4},{1,0,4},{9,7,3},{7,0,5},{6,5,8},{1,7,6},{4,0,9},{5,9,1},{8,7,3},{1,2,6},{4,1,5},{5,2,4},{1,9,1},{7,8,10},{0,4,2},{7,2,8}}, 6, 0, 7));
  }

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    HashMap<Integer, List<Node>> map = new HashMap<>();
    HashMap<Integer, Integer> visited = new HashMap<>();
    for (int[] schedule : flights) {
      map.putIfAbsent(schedule[0], new ArrayList<>());
      map.get(schedule[0]).add(new Node(schedule[1], schedule[2]));
    }
    LinkedList<Node> itr = new LinkedList<>();
    itr.add(new Node(src, 0));
    visited.put(0, 0);
    int minCost = Integer.MAX_VALUE;
    while (!itr.isEmpty()) {
      Node tmp = itr.removeFirst();
      if (tmp.k <= K+1 && tmp.cost < minCost && tmp.flightTo == dst) {
        minCost = tmp.cost;
      }
      List<Node> des = map.get(tmp.flightTo);
      if (des != null) {
        for (Node d : des) {
          if (tmp.k <= K) {
            itr.add(new Node(d.flightTo, tmp.cost + d.cost, tmp.k + 1));
            visited.put(d.flightTo, tmp.cost + d.cost);
          }
        }
      }
    }
    return minCost == Integer.MAX_VALUE ? -1 : minCost;
  }

  class Node {
    int flightTo;
    int cost;
    int k;

    public Node(int flightTo, int cost) {
      this.flightTo = flightTo;
      this.cost = cost;
      this.k = 0;
    }

    public Node(int flightTo, int cost, int k) {
      this.flightTo = flightTo;
      this.cost = cost;
      this.k = k;
    }
  }
}
