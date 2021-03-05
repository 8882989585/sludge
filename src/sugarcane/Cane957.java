package sugarcane;

import java.util.*;

public class Cane957 {
  public static void main(String[] args) {
    Cane957 cane957 = new Cane957();
//        cane957.prisonAfterNDays(new int[] {0, 1, 0, 1, 1, 0, 0, 1}, 20);
//    cane957.prisonAfterNDays(new int[] {1, 0, 0, 1, 0, 0, 1, 0}, 1000000000);
      cane957.prisonAfterNDays(new int[] {1, 0, 0, 1, 0, 0, 0, 1}, 826);
  }

  public int[] prisonAfterNDays(int[] cells, int N) {
      if (N > 0) {
          HashMap<String, List<Integer>> map = new HashMap<>();
          List<Integer> al = new ArrayList<>();
          al.add(0);
          map.put(Arrays.toString(cells), al);
          if (N > 14) {
              N = N % 14;
          }
          if(N == 0) {
              N= 14;
          }
          for (int i = 1; i <= N; i++) {
              int[] newCells = new int[cells.length];
              for (int j = 1; j < 7; j++) {
                  if (cells[j - 1] == cells[j + 1]) {
                      newCells[j] = 1;
                  }
              }
              if (map.get(Arrays.toString(newCells)) == null) {
                  al = new ArrayList<>();
                  al.add(i);
                  map.put(Arrays.toString(newCells), al);
              } else {
                  map.get(Arrays.toString(newCells)).add(i);
              }
              cells = newCells;
          }
      }
      return cells;
  }
}
