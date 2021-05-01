package leetcode;

import java.util.*;

public class Cane692 {

  public static void main(String[] args) {
    //
    Cane692 cane692 = new Cane692();
    cane692.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
  }

  public List<String> topKFrequent(String[] words, int k) {
    List<String> result = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    TreeSet<Node> treeSet =
        new TreeSet<>(
                (node1, node2) -> {
                  if(node1.c < node2.c) {
                    return 1;
                  } else if (node1.c > node2.c) {
                    return -1;
                  } else {
                    return node1.v.compareTo(node2.v);
                  }
                });
    Arrays.stream(words).forEach(word -> map.put(word, map.getOrDefault(word, 0) + 1));
    for(Map.Entry<String, Integer> entry:map.entrySet()) treeSet.add(new Node(entry.getKey(), entry.getValue()));
    for(Node node:treeSet) {
      if(k==0) {
        break;
      }
      k--;
      result.add(node.v);
    }
    return result;
  }

  class Node {
    String v;
    int c;

    public Node(String v, int c) {
      this.v = v;
      this.c = c;
    }
  }
}
