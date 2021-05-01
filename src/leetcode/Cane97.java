package leetcode;

public class Cane97 {

  private Boolean[][] call;

  public boolean isInterleaveDpTopDown(char[] s1, char[] s2, char[] s3, int i, int j, int k) {
    if (s3.length == k) {
      return s1.length == i && s2.length == j;
    }
    if (call[i][j] != null) {
      return call[i][j];
    }
    if (i < s1.length && j < s2.length && s1[i] == s3[k] && s2[j] == s3[k]) {
      call[i][j] = isInterleaveDpTopDown(s1, s2, s3, i + 1, j, k + 1) ||
          isInterleaveDpTopDown(s1, s2, s3, i, j + 1, k + 1);
    } else if (i < s1.length && s1[i] == s3[k]) {
      call[i][j] = isInterleaveDpTopDown(s1, s2, s3, i + 1, j, k + 1);
    } else if (j < s2.length && s2[j] == s3[k]) {
      call[i][j] = isInterleaveDpTopDown(s1, s2, s3, i, j + 1, k + 1);
    } else {
      call[i][j] = false;
    }
    return call[i][j];
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    return isInterleaveDpTopDown(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0);
  }

  public static void main(String[] args) {
    Cane97 cane97 = new Cane97();
    String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
    cane97.call = new Boolean[s1.length() + 1][s2.length() + 1];
    System.out.println(cane97.isInterleave(s1, s2, s3));
  }
}
