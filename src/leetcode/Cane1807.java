package leetcode;

import java.util.HashMap;
import java.util.List;

public class Cane1807 {

  public String evaluate(String s, List<List<String>> knowledge) {
    HashMap<String, String> map = new HashMap<>();
    for (List<String> entry : knowledge) {
      map.put(entry.get(0), entry.get(1));
    }
    StringBuilder res = new StringBuilder();
    char[] chars = s.toCharArray();
    boolean flag = false;
    StringBuilder tmp = new StringBuilder();
    for (char ch : chars) {
      if (ch == '(') {
        flag = true;
      }
      else if (ch == ')') {
        res.append(map.getOrDefault(tmp.toString(), "?"));
        flag = false;
        tmp = new StringBuilder();
      }
      else if (flag) {
        tmp.append(ch);
      } else {
        res.append(ch);
      }
    }
    return res.toString();
  }
}
