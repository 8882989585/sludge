package leetcode;

public class Cane880 {
  public String decodeAtIndex(String S, int K) {
    StringBuilder sb = new StringBuilder();
    int len = 0;
    for (char ch : S.toCharArray()) {
      if (ch >= '2' && ch <= '9') {
        int t = len;
        len = len * (ch - '0');
        if (len >= K) {
            K--;
          return String.valueOf(sb.charAt((K % t)));
        } else {
          sb.append(String.valueOf(sb).repeat(Math.max(0, (ch - '0' - 1))));
        }
      } else {
        sb.append(ch);
        len++;
        if (len == K) {
          return String.valueOf(ch);
        }
      }
    }
    if (len >= K) {
      return String.valueOf(sb.charAt(K - 1));
    } else {
      return "";
    }
  }
}
