package leetcode;

public class Cane1750 {
  public int minimumLength(String s) {
    char[] chrs = s.toCharArray();
    int i = 0, j = chrs.length - 1;
    while (i != j && j > -1 && chrs[i] == chrs[j]) {
      int l = i, m = j;
      char ch = chrs[i];
      while (l < chrs.length && chrs[l] == ch) {
        l++;
      }
      while (m > -1 && chrs[m] == ch) {
        m--;
      }
      if (l - 1 < m + 1) {
        i = l;
        j = m;
      } else if ((l - m) > 0) {
        return 0;
      } else {
        break;
      }
    }
    return j - i + 1;
  }

  public static void main(String[] args) {
    Cane1750 cane1750 = new Cane1750();
    System.out.println(cane1750.minimumLength("aabccabba"));
    System.out.println(cane1750.minimumLength(""));
    System.out.println(cane1750.minimumLength("cabaabac"));
      System.out.println(cane1750.minimumLength("cababac"));
    System.out.println(cane1750.minimumLength("ccccccccccc"));
    System.out.println(cane1750.minimumLength("cccccccccc"));
    System.out.println(cane1750.minimumLength("andsjfrjmd"));
      System.out.println(cane1750.minimumLength("bbbbbbbbbbbbbbbbbbb"));

  }
}
