package sugarcane;

import java.util.*;
import java.util.stream.Collectors;

public class Cane1048 {

  public static void main(String[] args) {
    //
    Cane1048 cane1048 = new Cane1048();
    cane1048.longestStrChain(new String[] {"a","b","ab","bac"});
  }

  public boolean checkApplicable(char[] arr1, char[] arr2) {
    int i = 0, j = 0;
    while (i < arr1.length && j < arr2.length) {
      if (arr1[i] == arr2[j]) {
        i++;
      }
      j++;
    }
    return j - i == 1 || j-i==0;
  }

  public int longestStrChain(String[] words) {
    HashMap<Integer, List<Node>> map = new HashMap<>();
    int maxLength = -1;
    for (String word : words) {
      char[] tmp = word.toCharArray();
      if (tmp.length > maxLength) {
        maxLength = tmp.length;
      }
      map.putIfAbsent(tmp.length, new ArrayList<>());
      map.get(tmp.length).add(new Node(1, tmp));
    }
    for (int i = 0; i < maxLength; i++) {
      List<Node> entry1 = map.get(i);
      List<Node> entry2 = map.get(i + 1);
      if (entry1 != null && entry2 != null) {
        for (Node itr1 : entry1) {
          for (Node itr2 : entry2) {
            if (itr2.i <= itr1.i && checkApplicable(itr1.word, itr2.word)) {
              itr2.i = itr1.i + 1;
            }
          }
        }
      }
    }
    maxLength = -1;
    for (List<Node> nodes : map.values()) {
      for (Node itr : nodes) {
        if (itr.i > maxLength) {
          maxLength = itr.i;
        }
      }
    }
    return maxLength;
  }

  class Node {
    int i;
    char[] word;

    public Node(int i, char[] word) {
      this.i = i;
      this.word = word;
    }
  }
}
