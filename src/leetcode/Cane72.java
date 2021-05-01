package leetcode;

class Cane72 {
  public int minDistance(String word1, String word2) {
    char[] s = word1.toCharArray();
    char[] t = word2.toCharArray();
    int[][] arr = new int[s.length + 1][t.length + 1];
    for (int i = 1; i <= s.length; i++) {
      arr[i][0] = i;
    }
    for (int i = 1; i <= t.length; i++) {
      arr[0][i] = i;
    }
    for (int i = 1; i <= s.length; i++) {
      for (int j = 1; j <= t.length; j++) {
        if (s[i - 1] == t[j - 1]) {
          arr[i][j] = arr[i - 1][j - 1];
        } else {
          arr[i][j] = Math.min(Math.min(arr[i - 1][j - 1], arr[i - 1][j]), arr[i][j - 1]) + 1;
        }
      }
    }
    return arr[s.length][t.length];
  }
}
