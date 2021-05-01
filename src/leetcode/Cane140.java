package leetcode;

import java.util.*;

public class Cane140 {

  public static void main(String[] args) {
    //
    Cane140 cane140 = new Cane140();
//    cane140.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
      cane140.wordBreak("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple"));
  }

  public boolean areTheySame(char[] chars, String r) {
      char[] cht = r.toCharArray();
      int i=0,j=0;
      while (j<cht.length) {
          if(cht[j] == ' ') {
              j++;
              continue;
          }
          if(cht[j]!=chars[i]) {
              return false;
          }
          j++;
          i++;
      }
      return true;
  }
  public List<String> wordBreak(String s, List<String> wordDict) {
    char[] chrs = new char[s.length() + 1];
    int f = 0;
    for (Character character : s.toCharArray()) {
      chrs[f] = character;
      f++;
    }
    chrs[s.length()] = ' ';
    HashMap<String, List<String>> map = new HashMap<>();
    for (String word : wordDict) {
      map.putIfAbsent(word.substring(0, 1), new ArrayList<>());
      map.get(word.substring(0, 1)).add(word);
    }

    LinkedList<Node> itr = new LinkedList<>();
    itr.add(new Node("", String.valueOf(chrs[0]), 0));
    List<String> result = new ArrayList<>();
    while (!itr.isEmpty()) {
      Node tmp = itr.pop();
      if (tmp.ch.equals(" ")) {
        result.add(tmp.sb);
        continue;
      }
      for (String word : map.getOrDefault(tmp.ch, new ArrayList<>())) {
        if (tmp.sb.equals("") && areTheySame(chrs, word)) {
          itr.add(new Node(word, String.valueOf(chrs[word.length()]), 0));
        } else {
          if (tmp.sb.length() + word.length() - tmp.i < chrs.length) {
              String r = tmp.sb + " " + word;
              if(areTheySame(chrs, r)) {
            itr.add(
                new Node(
                    r, String.valueOf(chrs[tmp.sb.length() + word.length() - tmp.i]), tmp.i + 1));
          }}
        }
      }
    }
    return result;
  }

  class Node {
    String sb;
    String ch;
    int i;

    public Node(String sb, String ch, int i) {
      this.sb = sb;
      this.ch = ch;
      this.i = i;
    }
  }
}
