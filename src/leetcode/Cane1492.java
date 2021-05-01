package leetcode;

import java.util.ArrayList;
import java.util.TreeSet;

public class Cane1492 {

  public int kthFactor(int n, int k) {
    int sqrt = new Double(Math.sqrt(n)).intValue();
    int t = k;
    TreeSet<Integer> factors = new TreeSet<>();
    if (k == 1) {
      return 1;
    }
    factors.add(1);
    k--;
    for (int i = 2; i <= sqrt; i++) {
      if (n % i == 0) {
        factors.add(i);
        k--;
        if (k == 0) {
          return i;
        }
        factors.add(n / i);
      }
    }
    factors.add(n);
    if (factors.size() < t) {
      return -1;
    }
    return new ArrayList<>(factors).get(t-1);
  }

  public static void main(String[] args) {
      Cane1492 cane1492 = new Cane1492();
    System.out.println(
    cane1492.kthFactor(4, 4));
  }
}
