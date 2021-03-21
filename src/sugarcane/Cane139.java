package sugarcane;

import java.util.*;

public class Cane139 {
  class Node {
    char ch;
    int i;

    public Node(char ch, int i) {
      this.ch = ch;
      this.i = i;
    }
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    HashMap<Character, List<char[]>> map = new HashMap<>();
    for(String word:wordDict) {
      char[] chars = word.toCharArray();
      if(!map.containsKey(chars[0])) {
        map.put(chars[0], new ArrayList<>());
      }
      map.get(chars[0]).add(chars);
    }
    char[] ch = s.toCharArray();
    LinkedList<Node> list = new LinkedList<>();
    HashSet<Integer> set = new HashSet<>();
    list.add(new Node(ch[0], 0));
    set.add(0);
    while (!list.isEmpty()) {
      Node tmp = list.pop();
      List<char[]> tmpList = map.get(tmp.ch);
      if (tmpList != null) {
        for (char[] chrs : tmpList) {
          int i = tmp.i, j = 0;
          while (j < chrs.length && i < ch.length) {
            if (chrs[j] != ch[i]) {
              break;
            }
            j++;
            i++;
          }
          if (j == chrs.length) {
            if (i == ch.length) {
              return true;
            } else {
              if (!set.contains(i)) {
                list.add(new Node(ch[i], i));
                set.add(i);
              }
            }
          }
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
      Cane139 cane139 = new Cane139();
    System.out.println(cane139.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
  }
}
