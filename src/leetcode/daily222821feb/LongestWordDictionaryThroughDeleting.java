package leetcode.daily222821feb;

import java.util.Arrays;
import java.util.List;

public class LongestWordDictionaryThroughDeleting {

  public static void main(String[] args) {
    LongestWordDictionaryThroughDeleting lwdtd = new LongestWordDictionaryThroughDeleting();
    List<String> list = Arrays.asList("ale", "apple", "monkey", "plea");
    System.out.println(lwdtd.findLongestWord("abpcplea", list));
  }

  public String findLongestWord(String s, List<String> d) {
    int previousLength = -1;
    String result = "";
    char[] mainString = s.toCharArray();
    for (String v : d) {
      char[] arr = v.toCharArray();
      if (arr.length >= previousLength) {
        int i = 0, j = 0;
        while (i < mainString.length && j < arr.length) {
          if (mainString[i] == arr[j]) {
            j++;
          }
          i++;
        }
        if (j == arr.length) {
          if (arr.length == previousLength) {
            result = result.compareTo(v) <= 0 ? result : v;
          } else {
            previousLength = arr.length;
            result = v;
          }
        }
      }
    }
    return result;
  }
}
