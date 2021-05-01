package leetcode;

public class Cane5 {

  public static void main(String[] args) {
    Cane5 cane5 = new Cane5();
    System.out.println(cane5.longestPalindrome("ccd"));
  }

  public String longestPalindrome(String s) {
    char[] ch = s.toCharArray();
    if (ch.length == 0) {
      return "";
    }
    if(ch.length == 1) {
      return s;
    }
    if(ch.length == 2) {
      if (ch[0] == ch[1]) {
        return s;
      } else {
        return s.substring(0,1);
      }
    }
    int m = -1, n = -1, maxLength = 0, p, q, runLength;
    for (int i = 1; i < ch.length - 1; i++) {
      runLength = 1;
      if (runLength > maxLength) {
        maxLength = runLength;
        m = i;
        n = i;
      }
      p = i - 1;
      q = i + 1;
      while (p >= 0 && q < ch.length) {
        if (ch[p] == ch[q]) {
          runLength = runLength + 2;
          if (runLength > maxLength) {
            maxLength = runLength;
            m = p;
            n = q;
          }
        }else {
          break;
        }
        p--;
        q++;
      }
      if (ch[i] == ch[i + 1] || ch[i] == ch[i-1]) {
        runLength = 2;
        if(ch[i] == ch[i + 1]) {
          if (runLength > maxLength) {
            maxLength = runLength;
            m = i;
            n = i + 1;
          }
          p = i - 1;
          q = i + 2;
        } else {
          if (runLength > maxLength) {
            maxLength = runLength;
            m = i - 1;
            n = i;
          }
          p = i - 2;
          q = i + 1;
        }
        while (p >= 0 && q < ch.length) {
          if (ch[p] == ch[q]) {
            runLength = runLength + 2;
            if (runLength > maxLength) {
              maxLength = runLength;
              m = p;
              n = q;
            }
          }else {
            break;
          }
          p--;
          q++;
        }
      }
    }
    return s.substring(m, n+1);
  }
}
