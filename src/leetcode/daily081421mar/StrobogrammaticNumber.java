package leetcode.daily081421mar;

import java.util.HashMap;

public class StrobogrammaticNumber {
    HashMap<Character, Character> map = new HashMap<>();
  {

    map.put('0', '0');
    map.put('1', '1');
    map.put('6', '9');
    map.put('8', '8');
    map.put('9', '6');
  }

  public boolean isStrobogrammatic(String num) {
      char[] arr = num.toCharArray();
      StringBuilder sb = new StringBuilder("");
      for(int i=arr.length-1;i>-1;i--) {
          if(map.containsKey(arr[i])) {
              sb.append(map.get(arr[i]));
          } else {
              return false;
          }
      }
      return num.equals(sb.toString());
  }
}
