package leetcode;

import java.util.*;

public class Cane1055 {

  public static void main(String[] args) {
    Cane1055 cane1055 = new Cane1055();
    cane1055.shortestWay("xyz", "xzyxz");
  }

  public int shortestWay(String source, String target) {
    char[] sourceToCharArray = source.toCharArray();
    char[] targetToCharArray = target.toCharArray();
    HashMap<Character, TreeSet<Integer>> charPositionMap = new HashMap<>();
    for (int i = 0; i < sourceToCharArray.length; i++) {
      charPositionMap.putIfAbsent(sourceToCharArray[i], new TreeSet<>());
      charPositionMap.get(sourceToCharArray[i]).add(i);
    }
    int result = 0;
    int runIdx = -1;
    for (int i = 0; i < targetToCharArray.length; ) {
      if (runIdx == -1) {
        result++;
      }
      TreeSet<Integer> tmp = charPositionMap.get(targetToCharArray[i]);
      if (tmp == null) {
        return -1;
      }
      Integer tmpCeil = tmp.ceiling(runIdx + 1);
      runIdx = Objects.requireNonNullElse(tmpCeil, -1);
      if (tmpCeil != null) {
        i++;
      }
    }
    return result;
  }
}
