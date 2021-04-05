package beetroot.march2021circuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class AFairCompetition {
  public static void main(String[] args) throws IOException {
    //
    AFairCompetition aFairCompetition = new AFairCompetition();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());
    for (int i = 0; i < count; i++) {
      int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      aFairCompetition.solution(A[0], A[1], br);
    }
  }

  public void findAndFlat(
      int i, int j, HashMap<Integer, Node> map, HashMap<Node, Long> countMap) {
    Node parent;
    ArrayList<Node> parentChain1 = new ArrayList<>();
    ArrayList<Node> parentChain2 = new ArrayList<>();
    Node child1 = map.get(i);
    Node child2 = map.get(j);
    parent = child1.parent;
    while (parent != parent.parent) {
      parentChain1.add(parent);
      parent = parent.parent;
    }
    parentChain1.add(child1);
    parent = child2.parent;
    while (parent != parent.parent) {
      parentChain2.add(parent);
      parent = parent.parent;
    }
    parentChain2.add(child2);
    if (countMap.get(parentChain1.get(0).parent) >= countMap.get(parentChain2.get(0).parent)) {
      parent = parentChain1.get(0).parent;
    } else {
      parent = parentChain2.get(0).parent;
    }
    for (Node node : parentChain1) {
      if (node.parent != parent) {
        countMap.put(node.parent, countMap.get(node.parent) - 1);
        countMap.put(parent, countMap.get(parent) + 1);
        node.parent = parent;
      }
    }
    for (Node node : parentChain2) {
      if (node.parent != parent) {
        countMap.put(node.parent, countMap.get(node.parent) - 1);
        countMap.put(parent, countMap.get(parent) + 1);
        node.parent = parent;
      }
    }
  }

  public void solution(int noOfChildren, int noOFRelationships, BufferedReader br)
      throws IOException {
    HashMap<Integer, Node> hashMap = new HashMap<>();
    HashMap<Node, Long> countMap = new HashMap<>();
    for (int i = 1; i <= noOfChildren; i++) {
      Node child = new Node(null);
      child.parent = child;
      hashMap.put(i, child);
      countMap.put(child, 1L);
    }
    for (int i = 0; i < noOFRelationships; i++) {
      int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      findAndFlat(A[0], A[1], hashMap, countMap);
    }
    Long[] res =
        countMap.values().stream()
            .filter(x -> x != 0)
            .collect(Collectors.toList())
            .toArray(new Long[]{});
    long cum = 0;
    for (int i = 0; i < res.length; i++) {
      cum = cum + res[i];
      res[i] = cum;
    }
    long result = 0;
    for (int i = 0; i < res.length - 1; i++) {
      if (i - 1 < 0) {
        result = result + (res[i] * (res[res.length - 1] - res[i]));
      } else {
        result = result + ((res[i] - res[i - 1]) * (res[res.length - 1] - res[i]));
      }
    }
    System.out.println(result * 2);
  }

  class Node {
    Node parent;

    public Node(Node parent) {
      this.parent = parent;
    }
  }
}
