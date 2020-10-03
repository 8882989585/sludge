package sugarcane;

import java.util.HashMap;

class Cane146 {

  class NodeCane146 {

    private Integer key;
    private Integer value;
    private NodeCane146 previous;
    private NodeCane146 next;

    public NodeCane146(Integer key, Integer value, NodeCane146 previous, NodeCane146 next) {
      this.key = key;
      this.value = value;
      this.previous = previous;
      this.next = next;
    }
  }

  private final HashMap<Integer, NodeCane146> map;
  private final Integer capacity;
  private NodeCane146 last;
  private NodeCane146 first;

  public Cane146(int capacity) {
    this.map = new HashMap<>(capacity + 1, 1.0f);
    this.capacity = capacity;
  }

  public void addToLast(int key, int value, NodeCane146 node) {
    NodeCane146 newNode;
    if(node == null) {
      newNode = new NodeCane146(key, value, last, null);
    } else {
      newNode = node;
      newNode.key = key;
      newNode.value = value;
      newNode.previous = last;
      newNode.next = null;
    }
    map.put(key, newNode);
    if (last != null) {
      last.next = newNode;
    }
    last = newNode;
  }

  public int get(int key) {
    NodeCane146 node = map.get(key);
    if (node != null) {
      if (node != last) {
        if (node.previous != null) {
          node.previous.next = node.next;
        }
        if (node.next != null) {
          node.next.previous = node.previous;
        }
        if (node == first) {
          first = first.next;
        }
        addToLast(key, node.value, node);
      }
      return last.value;
    }
    return -1;
  }

  public void put(int key, int value) {
    if(this.capacity == 0) {
      return;
    }
    if (map.containsKey(key)) {
      get(key);
      last.value = value;
      return;
    }
    if (map.size() == this.capacity) {
      NodeCane146 removed = map.remove(first.key);
      first = first.next;
      removed.next = null;
      removed.previous = null;
    }
    addToLast(key, value, null);
    if (first == null) {
      first = last;
    }
  }

  public static void lruParser(String[] cmd, String value) {
    String[] valueTokens = value.split("a");
    Cane146 lruCache = new Cane146(Integer.parseInt(valueTokens[1]));
    for (int i = 1; i < cmd.length; i++) {
      String[] values = valueTokens[i + 1].split(",");
      switch (cmd[i]) {
        case "get": {
          System.out
              .println("get -> " + values[0] + " -> " + lruCache.get(Integer.parseInt(values[0])));
          System.out
              .println("first -> " + lruCache.first.key + "," + "last -> " + lruCache.last.key);
          System.out.println();
          break;
        }
        case "put": {
//          System.out.println("put -> " + values[0] + "," + values[1]);
          lruCache.put(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
//          System.out
//              .println("first -> " + lruCache.first.key + "," + "last -> " + lruCache.last.key);
//          System.out.println();
          break;
        }
      }
    }
  }

  public static void main(String[] args) {
    String[] cmd = new String[]{"LRUCache", "put", "put", "put", "put", "put", "get", "put", "get",
        "get", "put", "get", "put", "put", "put", "get", "put", "get", "get", "get", "get", "put",
        "put", "get", "get", "get", "put", "put", "get", "put", "get", "put", "get", "get", "get",
        "put", "put", "put", "get", "put", "get", "get", "put", "put", "get", "put", "put", "put",
        "put", "get", "put", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put",
        "get", "put", "put", "get", "put", "get", "get", "get", "put", "get", "get", "put", "put",
        "put", "put", "get", "put", "put", "put", "put", "get", "get", "get", "put", "put", "put",
        "get", "put", "put", "put", "get", "put", "put", "put", "get", "get", "get", "put", "put",
        "put", "put", "get", "put", "put", "put", "put", "put", "put", "put"};
    String value = "a10a10,13a3,17a6,11a10,5a9,10a13a2,19a2a3a5,25a8a9,22a5,5a1,30a11a9,12a7a5a8a9a4,30a9,3a9a10a10a6,14a3,1a3a10,11a8a2,14a1a5a4a11,4a12,24a5,18a13a7,23a8a12a3,27a2,12a5a2,9a13,4a8,18a1,7a6a9,29a8,21a5a6,30a1,12a10a4,15a7,22a11,26a8,17a9,29a5a3,4a11,30a12a4,29a3a9a6a3,4a1a10a3,29a10,28a1,20a11,13a3a3,12a3,8a10,9a3,26a8a7a5a13,17a2,27a11,15a12a9,19a2,15a3,16a1a12,17a9,1a6,19a4a5a5a8,1a11,7a5,2a9,28a1a2,2a7,4a4,22a7,24a9,26a13,28a11,26a";
    lruParser(cmd, value);
  }

}
