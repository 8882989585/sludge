package leetcode.daily010721feb;

public class SquirrelSimulation {
  public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
    int distance = 0;
    for (int i = 0; i < nuts.length; i++) {
      distance += (Math.abs(nuts[i][0] - tree[0]) + Math.abs(nuts[i][1] - tree[1])) * 2;
    }
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < nuts.length; i++) {
       int d = distance - (Math.abs(nuts[i][0] - tree[0]) + Math.abs(nuts[i][1] - tree[1])) +
               (Math.abs(nuts[i][0] - squirrel[0]) + Math.abs(nuts[i][1] - squirrel[1]));
       if(min > d) {
           min = d;
       }
    }
    return min;
  }

  public static void main(String[] args) {
    SquirrelSimulation squirrelSimulation = new SquirrelSimulation();
    System.out.println(
        squirrelSimulation.minDistance(
            0, 0, new int[] {2, 2}, new int[] {4, 4}, new int[][] {{3, 0}, {2, 5}}));
    System.out.println(
        squirrelSimulation.minDistance(
            0,
            0,
            new int[] {3, 2},
            new int[] {0, 1},
            new int[][] {
              {2, 0}, {4, 1}, {0, 4}, {1, 3}, {1, 0}, {3, 4}, {3, 0}, {2, 3}, {0, 2}, {0, 0},
              {2, 2}, {4, 2}, {3, 3}, {4, 4}, {4, 0}, {4, 3}, {3, 1}, {2, 1}, {1, 4}, {2, 4}
            }));
      System.out.println(
              squirrelSimulation.minDistance(
                      0, 0, new int[] {0,1}, new int[] {0,0}, new int[][] {{0,2}}));
  }
}
