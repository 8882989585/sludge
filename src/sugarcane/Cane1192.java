package sugarcane;

import java.util.*;

public class Cane1192 {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashMap<Integer, Node> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(List<Integer> connection:connections) {
            Collections.sort(connection);
            Node tmp1 = map.get(connection.get(0));
            if(tmp1==null) {
                tmp1= new Node(connection.get(0), null);
            }
            Node tmp2 = map.get(connection.get(1));
            if(tmp2==null) {
                tmp2= new Node(connection.get(1), null);
            }
            map.put(connection.get(0), tmp1);
            map.put(connection.get(1), tmp2);
            Node parent1 = tmp1, parent2 = tmp2;
            if(parent1.previous != null) {
                parent1 = parent1.previous;
            }
            if(parent2.previous != null) {
                parent2 = parent2.previous;
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> connection:connections) {
            if(!set.contains(connection.get(0))) {
                res.add(connection);
            }
            if(!set.contains(connection.get(1))) {
                res.add(connection);
            }
        }
        return res;
    }

    class Node {
        int val;
        Node previous;

        public Node(int val, Node previous) {
            this.val = val;
            this.previous = previous;
        }
    }

  public static void main(String[] args) {
    //
      Cane1192 cane1192 = new Cane1192();
      List<List<Integer>> connections = new ArrayList<>();
      connections.add(new ArrayList<>(){{add(0); add(1);}});
      connections.add(new ArrayList<>(){{add(1); add(2);}});
      connections.add(new ArrayList<>(){{add(2); add(0);}});
      connections.add(new ArrayList<>(){{add(1); add(3);}});
      cane1192.criticalConnections(4, connections);
  }
}
