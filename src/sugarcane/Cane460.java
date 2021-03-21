package sugarcane;

import java.util.HashMap;
import java.util.TreeSet;

public class Cane460 {

  TreeSet<Node> nodes;
  HashMap<Integer, Node> map;
  int capacity;
  long count;

  public Cane460(int capacity) {
    nodes =
        new TreeSet<>(
            (node1, node2) -> {
              int r = Integer.compare(node1.f, node2.f);
              if (r == 0) {
                return Long.compare(node1.d, node2.d);
              }
              return r;
            });
    map = new HashMap<>();
    this.capacity = capacity;
    count = 0;
  }

  public static void main(String[] args) {
    Cane460 cane460 = new Cane460(2);
    System.out.println(cane460.get(2));
    cane460.put(2, 6);
    System.out.println(cane460.get(1));
    cane460.put(1, 5);
    cane460.put(1, 2);
    System.out.println(cane460.get(1));
    System.out.println(cane460.get(2));
  }

  public int get(int key) {
    count++;
    Node tmp = map.get(key);
    if (tmp == null) {
      return -1;
    }
    nodes.remove(tmp);
    tmp.f++;
    tmp.d = count;
    nodes.add(tmp);
    return tmp.v;
  }

  public void put(int key, int value) {
    count++;
    Node tmp = map.get(key);
    if (tmp != null) {
      nodes.remove(tmp);
      tmp.v = value;
      tmp.f++;
      tmp.d = count;
      map.put(key, tmp);
      nodes.add(tmp);
    } else {
      if (map.size() < capacity) {
        tmp = new Node(key, value, 1, count);
        map.put(key, tmp);
        nodes.add(tmp);
      } else {
        tmp = nodes.pollFirst();
        if (tmp != null) {
          map.remove(tmp.k);
          tmp = new Node(key, value, 1, count);
          map.put(key, tmp);
          nodes.add(tmp);
        }
      }
    }
  }

  class Node {
    int k;
    int v;
    int f;
    long d;

    public Node(int k, int v, int f, long d) {
      this.v = v;
      this.f = f;
      this.d = d;
      this.k = k;
    }
  }
}
