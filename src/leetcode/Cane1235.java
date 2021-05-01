package leetcode;

import java.util.*;

public class Cane1235 {

  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    TreeMap<Integer, OuterNode> scheduler = new TreeMap<>();
    int max = Arrays.stream(profit).max().getAsInt();
    for (int i = 0; i < startTime.length; i++) {
      scheduler.putIfAbsent(startTime[i], new OuterNode(new ArrayList<>(), null));
      scheduler.get(startTime[i]).nodes.add(new InnerNode(endTime[i], profit[i]));
    }
    OuterNode lastNode = null;
    for (OuterNode node : scheduler.values()) {
      if (lastNode != null) {
        lastNode.nextNode = node;
      }
      lastNode = node;
    }

    for (Map.Entry<Integer, OuterNode> entry : scheduler.entrySet()) {
      for (InnerNode innerNode : entry.getValue().nodes) {
        Map.Entry<Integer, OuterNode> tmp = scheduler.ceilingEntry(innerNode.endTime);
        Integer tmpMax = null;
        if (tmp != null) {
          OuterNode outerNode = tmp.getValue();
          while (outerNode != null && (tmpMax == null || tmp.getKey() < tmpMax)) {
            for (InnerNode innerNode1 : outerNode.nodes) {
              if (tmpMax == null || innerNode1.endTime > tmpMax) {
                tmpMax = innerNode1.endTime;
              }
              if (innerNode.cost + innerNode1.profit > innerNode1.cost) {
                innerNode1.cost = innerNode.cost + innerNode1.profit;
                if (innerNode1.cost > max) {
                  max = innerNode1.cost;
                }
              }
            }
            outerNode = outerNode.nextNode;
          }
        }
      }
    }
    return max;
  }

  class InnerNode {
    int endTime;
    int cost;
    int profit;

    public InnerNode(int endTime, int profit) {
      this.endTime = endTime;
      this.profit = profit;
      this.cost = profit;
    }
  }

  class OuterNode {
    List<InnerNode> nodes;
    OuterNode nextNode;

    public OuterNode(List<InnerNode> nodes, OuterNode nextNode) {
      this.nodes = nodes;
      this.nextNode = nextNode;
    }
  }
}
