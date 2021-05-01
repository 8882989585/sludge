package leetcode;

import java.util.Arrays;
import java.util.List;

public class Cane472 {

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    Arrays.sort(
        words,
        (x, y) -> {
          int xl = x.length(), yl = y.length();
          if (xl < yl) {
            return -1;
          } else if (xl > yl) {
            return 1;
          } else {
            return x.compareTo(y);
          }
        });
    return  null;
  }
}
