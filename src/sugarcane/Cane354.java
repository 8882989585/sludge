package sugarcane;

import java.util.Arrays;
import java.util.Comparator;

public class Cane354 {

  public int maxEnvelopes(int[][] envelopes) {
    int[] res = new int[envelopes.length];
    Arrays.fill(res, 1);
    Arrays.sort(
        envelopes,
        (t1, t2) -> {
          if (t1[0] < t2[0]) {
            return -1;
          } else if (t1[0] == t2[0]) {
            return Integer.compare(t1[1], t2[1]);
          } else return 1;
        });
    for (int i = 0; i < envelopes.length; i++) {
      for (int j = i + 1; j < envelopes.length; j++) {
        if (envelopes[i][0] < envelopes[j][0]
            && envelopes[i][1] < envelopes[j][1]
            && res[j] < res[i] + 1) {
          res[j] = res[i] + 1;
        }
      }
    }
    return Arrays.stream(res).max().getAsInt();
  }
}
