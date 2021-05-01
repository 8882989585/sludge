package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Cane740 {

  public static void main(String[] args) {
    Cane740 cane740 = new Cane740();
    System.out.println(cane740.deleteAndEarn(new int[] {1, 2, 2, 3, 3, 4, 4, 5, 6, 7, 7, 7, 8, 8,8,8}));
  }

  public int recursion(int[] v, int[] c) {
    int[] dp = new int[v.length];
    dp[0] = v[0] * c[0];
    if (v.length == 1) {
      return dp[0];
    }
    dp[1] = v[1] == v[0] + 1 ? Math.max(v[1] * c[1], v[0] * c[0]) : v[1] * c[1] + v[0] * c[0];
    for (int i = 2; i < v.length; i++) {
      dp[i] =
          Math.max(
              v[i] == v[i - 1] + 1 ? dp[i - 1] : dp[i - 1] + v[i] * c[i], v[i] * c[i] + dp[i - 2]);
    }
    return dp[dp.length - 1];
  }

  public int deleteAndEarn(int[] nums) {
    Arrays.sort(nums);
    TreeMap<Integer, Integer> map = new TreeMap<>();
    Arrays.stream(nums).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));
    int[] v = new int[map.size()];
    int[] c = new int[map.size()];
    int i = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      v[i] = entry.getKey();
      c[i] = entry.getValue();
      i++;
    }
    return recursion(v, c);
  }
}
