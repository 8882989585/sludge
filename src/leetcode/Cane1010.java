package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Cane1010 {

  public static void main(String[] args) {
    Cane1010 cane1010 = new Cane1010();
    System.out.println(cane1010.numPairsDivisibleBy60(new int[] {60, 60, 120, 120, 180, 180, 180}));
    System.out.println(cane1010.numPairsDivisibleBy60(new int[] {30, 20, 150, 100, 40}));
      System.out.println(cane1010.numPairsDivisibleBy60(new int[] {}));
      System.out.println(cane1010.numPairsDivisibleBy60(new int[] {0, 0, 0}));
      System.out.println(cane1010.numPairsDivisibleBy60(new int[] {60, 60, 60}));
      System.out.println(cane1010.numPairsDivisibleBy60(new int[] {30,30,30}));
      System.out.println(cane1010.numPairsDivisibleBy60(new int[] {439,407,197,191,291,486,30,307,11}));
  }


    public int numPairsDivisibleBy60(int[] time) {
    HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
    for (int t : time) {
      map.putIfAbsent(t % 60, new HashMap<>());
      HashMap<Integer, Integer> tmp = map.get(t % 60);
      tmp.put(t, tmp.getOrDefault(t, 0) + 1);
    }
    int count = 0;
    for (Integer key : new LinkedList<>(map.keySet())) {
      HashMap<Integer, Integer> map1 = map.get(key);
      if (map1 != null) {
        HashMap<Integer, Integer> map2 = map.get(60 - key);
        if (map2 != null && map1 != map2) {
          map.remove(key);
          map.remove(60 - key);
          int counter = map2.values().stream().reduce(Integer::sum).get();
          for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            count += entry.getValue() * counter;
          }
        } else if(key == 0 || key == 30) {
          int counter = map1.values().stream().reduce(Integer::sum).get();
          count += (counter * (counter - 1)) / 2;
          map.remove(key);
        }
      }
    }
    return count;
  }
}
