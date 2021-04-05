package sugarcane;

import java.util.*;
import java.util.stream.Collectors;

public class Cane17 {

  static HashMap<Character, List<Character>> map = new HashMap<>();

  static {
    map.put('2', Arrays.asList('a', 'b', 'c'));
    map.put('3', Arrays.asList('d', 'e', 'f'));
    map.put('4', Arrays.asList('g', 'h', 'i'));
    map.put('5', Arrays.asList('j', 'k', 'l'));
    map.put('6', Arrays.asList('m', 'n', 'o'));
    map.put('7', Arrays.asList('p', 'q', 'r', 's'));
    map.put('8', Arrays.asList('t', 'u', 'v'));
    map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
  }

  public List<StringBuilder> addToList(char c, List<StringBuilder> lists) {
    List<StringBuilder> newList = new ArrayList<>();
    if (lists.isEmpty()) {
      for (char cItr : map.get(c)) {
        newList.add(new StringBuilder().append(cItr));
      }
    } else {
      for (char cItr : map.get(c)) {
        for (StringBuilder sb : lists) {
          newList.add(new StringBuilder(sb).append(cItr));
        }
      }
    }
    return newList;
  }

  public List<String> letterCombinations(String digits) {

    List<StringBuilder> lists = new LinkedList<>();
    for (char ch : digits.toCharArray()) {
      lists = addToList(ch, lists);
    }
    return lists.stream().map(StringBuilder::toString).collect(Collectors.toList());
  }

  public static void main(String[] args) {
      Cane17 cane17 = new Cane17();
      cane17.letterCombinations("223");
  }
}
