package leetcode;

import java.util.Arrays;

public class Cane1641 {
  private static final char[] chars = {'a', 'e', 'i', 'o', 'u'};

  public static void main(String[] args) {
    Cane1641 cane1641 = new Cane1641();
    System.out.println(cane1641.countVowelStrings(4));
  }

  public int countVowelStringsTask(int n, int s, int c) {
    if (c == n) {
      return 1;
    }
    if (s == chars.length) {
      return 0;
    }
    int sum = 0;
    for (int i = s; i < 5; i++) {
      sum += countVowelStringsTask(n, i, c + 1);
    }
    return sum;
  }

  public int countVowelStrings(int n) {
    //    return countVowelStringsTask(n, 0, 0);
    if (n < 1) return 0;
    int[] res = new int[n];
    Arrays.fill(res, 1);
    res[0] = 1;
    for (int i = 1; i < 5; i++) {
      res[0] = i + 1;
      for (int j = 1; j < n; j++) {
        res[j] = res[j] + res[j - 1];
      }
    }
    return res[n - 1];
  }
}
