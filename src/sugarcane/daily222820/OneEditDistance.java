package sugarcane.daily222820;

public class OneEditDistance {

  public boolean isOneEditDistanceDpSol(char[] s, char[] t) {
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
    return arr[s.length][t.length] ==1;
  }

  public boolean isOneEditDistanceSol(char[] s, char[] t, int i, int j, int e) {
    if (e > 1) {
      return false;
    }
    if (s.length == i) {
      return e + t.length - j <= 1;
    }
    if (t.length == j) {
      return e + s.length - i <= 1;
    }
    if (s[i] == t[j]) {
      return isOneEditDistanceSol(s, t, i + 1, j + 1, 0);
    }
    return isOneEditDistanceSol(s, t, i, j + 1, e + 1) ||
        isOneEditDistanceSol(s, t, i + 1, j + 1, e + 1) ||
        isOneEditDistanceSol(s, t, i + 1, j, e + 1);
  }

  public boolean isOneEditDistance(String s, String t) {
    if (s.length() == 0) {
      return t.length() == 1;
    }
    if (t.length() == 0) {
      return s.length() == 1;
    }
//    return isOneEditDistanceSol(s.toCharArray(), t.toCharArray(), 0, 0, 0);
    return isOneEditDistanceDpSol(s.toCharArray(), t.toCharArray());
  }

  public static void main(String[] args) {
    OneEditDistance oed = new OneEditDistance();
    System.out.println(oed.isOneEditDistance("ab", "acb"));
    System.out.println(oed.isOneEditDistance("a", "ba"));
//    System.out.println(oed.isOneEditDistance("ba", "a"));
//    System.out.println(oed.isOneEditDistance("", "abc"));
//    System.out.println(oed.isOneEditDistance("ab", ""));
//    System.out.println(oed.isOneEditDistance("", "a"));
//    System.out.println(oed.isOneEditDistance("a", ""));
    System.out.println(oed.isOneEditDistance("addfsdds", "addgsdds"));
    System.out.println(oed.isOneEditDistance("ab", "ab"));
  }
}