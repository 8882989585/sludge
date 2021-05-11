package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Cane127 {

  public static void main(String[] args) {
    Cane127 cane127 = new Cane127();
    System.out.println(
    cane127.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
  }

  public int detectSingleChange(char[] chr1, char[] chr2) {
    if (chr1.length != chr2.length) {
      return -1;
    }
    boolean flag = false;
    for (int i = 0; i < chr1.length; i++) {
      if (chr1[i] != chr2[i]) {
        if (!flag) {
          flag = true;
        } else {
          return -1;
        }
      }
    }
    return flag ? 1 : 0;
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    char[] endW = endWord.toCharArray();
    char[] startW = beginWord.toCharArray();
    HashMap<String, Integer> map = new HashMap<>();
    LinkedList<Node> itr = new LinkedList<>();
    itr.add(new Node(startW, 0));
    while (!itr.isEmpty()) {
      Node tmp = itr.removeFirst();
      if (detectSingleChange(endW, tmp.word) == 0) {
          return tmp.count + 1;
      }
      for (String word : wordList) {
        char[] tChar = word.toCharArray();
        if (map.getOrDefault(word, Integer.MAX_VALUE) > tmp.count
            && detectSingleChange(tChar, tmp.word) == 1) {
          itr.add(new Node(tChar, tmp.count + 1));
          map.put(word, tmp.count + 1);
        }
      }
    }
    return 0;
  }

  class Node {
    char[] word;
    int count;

    public Node(char[] word, int count) {
      this.word = word;
      this.count = count;
    }
  }
}
