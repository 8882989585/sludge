package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Cane3 {

  public int lengthOfLongestSubstring(String s) {
    char[] charArray = s.toCharArray();
    if (charArray.length == 0) {
      return 0;
    }
    int start = 0, end = 0, max = 1;
    Map<Character, Integer> map = new HashMap<>();
    map.put(charArray[0], 0);
    for (int i = 1; i < charArray.length; i++) {
      Integer t = map.get(charArray[i]);
      if (t != null && t >= start) {
        if (end - start + 1 > max) {
          max = end - start + 1;
        }
        start = t + 1;
      }
      map.put(charArray[i], i);
      end = i;
    }
    if (end - start + 1 > max) {
      max = end - start + 1;
    }
    return max;
  }

  public static void main(String[] args) {
    Cane3 cane3 = new Cane3();
    System.out.println(cane3.lengthOfLongestSubstring("abcabcbb"));
    System.out.println(cane3.lengthOfLongestSubstring("bbbbb"));
    System.out.println(cane3.lengthOfLongestSubstring("pwwkew"));
    System.out.println(cane3.lengthOfLongestSubstring(""));
    System.out.println(cane3.lengthOfLongestSubstring("au"));
  }
}
