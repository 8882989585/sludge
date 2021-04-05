package sugarcane.mock;

import java.util.Arrays;
import java.util.LinkedList;

public class Question2 {

  public static void main(String[] args) {
    //
    Question2 question2 = new Question2();
    System.out.println(question2.removeKdigits("112", 1));
  }

  public String removeKdigits(String num, int k) {
    char[] chars = num.toCharArray();
    if (k >= chars.length) {
      return "0";
    }
    LinkedList<Character> linkedList = new LinkedList<>();
    int i = 0;
    while (i < chars.length) {
      while (!linkedList.isEmpty() && i - linkedList.size() < k) {
        if (linkedList.getLast().compareTo(chars[i]) > 0) {
          linkedList.removeLast();
        } else {
          break;
        }
      }
      linkedList.add(chars[i]);
      i++;
    }
    StringBuilder sb = new StringBuilder();
    linkedList.forEach(sb::append);
    num = sb.substring(0, chars.length - k).replaceFirst("^0*", "");
    if (num.equals("")) {
      return "0";
    }
    return num;
  }
}
