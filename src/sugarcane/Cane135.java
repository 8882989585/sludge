package sugarcane;

import java.lang.reflect.Array;
import java.util.*;

public class Cane135 {

  public static void main(String[] args) {
    //
    Cane135 cane135 = new Cane135();
    System.out.println(cane135.candy(new int[] {1, 0, 1, 2, 3, 4, 2, 2}));
  }

  public int candy(int[] ratings) {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < ratings.length; i++) {
      if (ratings[i] != 0) {
        map.putIfAbsent(ratings[i], new ArrayList<>());
        map.get(ratings[i]).add(i);
      }
    }
    int[] result = new int[ratings.length];
    Arrays.fill(result, 1);
    for (int i = 1; i <= 20000; i++) {
      List<Integer> list = map.get(i);
      if (list != null) {
        for (Integer t : list) {
          if (t - 1 > -1) {
            if (ratings[t - 1] < ratings[t] && result[t] <= result[t - 1]) {
              result[t] = result[t - 1] + 1;
            }
          }
          if (t + 1 < ratings.length) {
            if (ratings[t + 1] < ratings[t] && result[t] <= result[t + 1]) {
              result[t] = result[t + 1] + 1;
            }
          }
        }
      }
    }
    return Arrays.stream(result).sum();
  }
}
