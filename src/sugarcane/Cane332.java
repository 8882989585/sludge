package sugarcane;

import java.util.*;

public class Cane332 {

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, TreeSet<String>> map = new HashMap<>();
        for(List<String> ticket:tickets) {
            map.putIfAbsent(ticket.get(0), new TreeSet<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> result = new ArrayList<>();
        String lastStation = "JFK";
        while(true) {
            result.add(lastStation);
            if (map.containsKey(lastStation)) {
                TreeSet<String> treeSet = map.get(lastStation);
                String nextStation = treeSet.pollFirst();
                if(treeSet.size() == 0) {
                    map.remove(lastStation);
                }
                lastStation = nextStation;
            } else {
                return result;
            }
        }
    }

  public static void main(String[] args) {
    //
      Cane332 cane332 = new Cane332();
      cane332.findItinerary(Arrays.asList(
              Arrays.asList("JFK","KUL"),
              Arrays.asList("JFK","NRT"),
              Arrays.asList("NRT","JFK")));
  }
}
