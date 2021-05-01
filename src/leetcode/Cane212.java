package leetcode;

import java.util.*;

public class Cane212 {

  public static void main(String[] args) {
    //
    Cane212 cane212 = new Cane212();
    //      cane212.findWords(new
    // char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}, new
    // String[]{"oath","pea","eat","rain"});
    cane212.findWords(
        new char[][] {{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}},
        new String[] {"eaabcdgfa"});
  }

  public List<String> findWords(char[][] board, String[] words) {
    HashMap<Pair, Character> map1 = new HashMap<>();
    HashMap<Character, HashSet<Pair>> map2 = new HashMap<>();
    ArrayList<String> res = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        Pair pair = new Pair(i, j);
        map1.put(pair, board[i][j]);
        if (map2.containsKey(board[i][j])) {
          map2.get(board[i][j]).add(pair);
        } else {
          HashSet<Pair> set = new HashSet<>();
          set.add(pair);
          map2.put(board[i][j], set);
        }
      }
    }
    for (String word : words) {
      char[] chars = word.toCharArray();
      HashSet<Pair> set = map2.get(chars[0]);
      if (set != null) {
        for (Pair pair : set) {
          LinkedList<Node> list = new LinkedList<>();
          list.add(new Node(pair, 0, pair));
          boolean flag = false;
          while (!list.isEmpty()) {
            Node tmp = list.removeLast();
            if (tmp.counter == chars.length - 1) {
              res.add(word);
              flag = true;
              break;
            }
            Pair tmp2 = new Pair(tmp.pair.i - 1, tmp.pair.j);
            Character ch = map1.get(tmp2);
            if (!tmp.path.contains(tmp2) && ch != null && ch.equals(chars[tmp.counter + 1])) {
              list.add(new Node(tmp2, tmp.counter + 1, tmp.path, tmp2));
            }
            tmp2 = new Pair(tmp.pair.i + 1, tmp.pair.j);
            ch = map1.get(tmp2);
            if (!tmp.path.contains(tmp2) && ch != null && ch.equals(chars[tmp.counter + 1])) {
              list.add(new Node(tmp2, tmp.counter + 1, tmp.path, tmp2));
            }
            tmp2 = new Pair(tmp.pair.i, tmp.pair.j + 1);
            ch = map1.get(tmp2);
            if (!tmp.path.contains(tmp2) && ch != null && ch.equals(chars[tmp.counter + 1])) {
              list.add(new Node(tmp2, tmp.counter + 1, tmp.path, tmp2));
            }
            tmp2 = new Pair(tmp.pair.i, tmp.pair.j - 1);
            ch = map1.get(tmp2);
            if (!tmp.path.contains(tmp2) && ch != null && ch.equals(chars[tmp.counter + 1])) {
              list.add(new Node(tmp2, tmp.counter + 1, tmp.path, tmp2));
            }
          }
          if (flag) {
            break;
          }
        }
      }
    }
    return res;
  }

  class Pair {
    int i;
    int j;

    public Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Pair pair = (Pair) o;

      if (i != pair.i) return false;
      return j == pair.j;
    }

    @Override
    public int hashCode() {
      int result = i;
      result = 31 * result + j;
      return result;
    }
  }

  class Node {
    Pair pair;
    Integer counter;
    HashSet<Pair> path;

    public Node(Pair pair, Integer counter, Pair pair1) {
      this.pair = pair;
      this.counter = counter;
      this.path = new HashSet<>();
      this.path.add(pair1);
    }

    public Node(Pair pair, Integer counter, HashSet<Pair> path, Pair pair1) {
      this.pair = pair;
      this.counter = counter;
      this.path = (HashSet<Pair>) path.clone();
      this.path.add(pair1);
    }
  }
}
