package sugarcane;

import java.util.Arrays;

public class Cane256 {

  public int minCost(int[][] costs) {
    if(costs.length == 0){
      return 0;
    }
    for (int i = 1; i < costs.length; i++) {
      costs[i][0] = Math.min(costs[i - 1][1] + costs[i][0], costs[i - 1][2] + costs[i][0]);
      costs[i][1] = Math.min(costs[i - 1][0] + costs[i][1], costs[i - 1][2] + costs[i][1]);
      costs[i][2] = Math.min(costs[i - 1][0] + costs[i][2], costs[i - 1][1] + costs[i][2]);
    }
    return Arrays.stream(costs[costs.length - 1]).min().orElse(0);
  }

  public static void main(String[] args) {
    Cane256 cane256 = new Cane256();
    int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
    System.out.println(cane256.minCost(costs));
    System.out.println(cane256.minCost(new int[][]{}));
  }
}
