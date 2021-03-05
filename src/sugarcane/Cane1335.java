package sugarcane;

public class Cane1335 {

  public static void main(String[] args) {
    Cane1335 cane1335 = new Cane1335();
    System.out.println(cane1335.minDifficulty(new int[] {11, 111, 22, 222, 33, 333, 44, 444}, 6));
    //    System.out.println(cane1335.minDifficulty(new int[] {4, 2, 3}, 2));
  }

  public int minDifficultyCorrect(int[] jobDifficulty, int D) {
    final int N = jobDifficulty.length;
    if (N < D) return -1;
    int[][] dp = new int[D][N];

    dp[0][0] = jobDifficulty[0];
    for (int j = 1; j < N; ++j) {
      dp[0][j] = Math.max(jobDifficulty[j], dp[0][j - 1]);
    }

    for (int d = 1; d < D; ++d) {
      for (int len = d; len < N; ++len) {
        int localMax = jobDifficulty[len];
        dp[d][len] = Integer.MAX_VALUE;
        for (int schedule = len; schedule >= d; --schedule) {
          localMax = Math.max(localMax, jobDifficulty[schedule]);
          dp[d][len] = Math.min(dp[d][len], dp[d - 1][schedule - 1] + localMax);
        }
      }
    }

    return dp[D - 1][N - 1];
  }

  public int minDifficulty(int[] jobDifficulty, int D) {
    if (jobDifficulty.length < D) return -1;
    int[][] res = new int[jobDifficulty.length][D + 1];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < jobDifficulty.length; i++) {
      max= Math.max(jobDifficulty[i], max);
      res[i][1] = max;
    }
    for (int j = 2; j <= D; j++) {
      for (int i = j - 1; i < jobDifficulty.length; i++) {
        res[i][j] = jobDifficulty[i] + res[i-1][j-1];
        max = Integer.MIN_VALUE;
        for(int k=i;k>j-2;k--) {
          max = Math.max(max, jobDifficulty[k]);
          res[i][j] = Math.min(res[i][j], res[k-1][j-1] + max);
        }
      }
    }
    return res[jobDifficulty.length-1][D];
  }
}
