package leetcode;

import java.util.*;

public class Cane126 {

  public static void main(String[] args) {
    Cane126 cane126 = new Cane126();
    cane126.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
  }

  public int compare2Words(char[] w1, char[] w2) {
    int diff = 0;
    for (int i = 0; i < w1.length; i++) {
      if (w1[i] != w2[i]) {
        diff++;
      }
    }
    return diff;
  }

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    int minLength = wordList.size();

    char[] bWordChars = beginWord.toCharArray();
    char[] eWordChars = endWord.toCharArray();
    char[][] dict = new char[wordList.size()][];
    int i = 0;
    for (String word : wordList) {
      dict[i] = word.toCharArray();
      i++;
    }

    List<Node> resultNodes = new ArrayList<>();

    LinkedList<Node> itr = new LinkedList<>();
    itr.add(new Node(null, bWordChars, 1));

    HashMap<String, Integer> map = new HashMap<>();
    while (!itr.isEmpty()) {
      Node tmp = itr.removeFirst();
      if (compare2Words(tmp.word, eWordChars) == 0 && tmp.length <= minLength) {
        resultNodes.add(tmp);
        minLength = tmp.length;
      }

      for (i = 0; i < dict.length; i++) {
        if (map.getOrDefault(String.valueOf(dict[i]), Integer.MAX_VALUE) >= tmp.length + 1
            && compare2Words(tmp.word, dict[i]) == 1 && tmp.length < wordList.size()) {
          itr.add(new Node(tmp, dict[i], tmp.length + 1));
          map.put(String.valueOf(dict[i]), tmp.length + 1);
        }
      }
    }

    List<List<String>> result = new ArrayList<>();

    for (Node itrNode : resultNodes) {
      if (minLength == itrNode.length) {
        LinkedList<String> tmpList = new LinkedList<>();
        Node tmp = itrNode;
        while (tmp != null) {
          tmpList.addFirst(String.valueOf(tmp.word));
          tmp = tmp.prevNode;
        }
        result.add(tmpList);
      }
    }

    return result;
  }

  class Node {
    Node prevNode;
    char[] word;
    int length;

    public Node(Node node, char[] word, int length) {
      this.prevNode = node;
      this.word = word;
      this.length = length;
    }
  }
}
