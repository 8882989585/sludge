package sugarcane;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Cane139 {
  public boolean wordBreak(String s, List<String> wordDict) {
    List<String> tempDict = wordDict;
    for(String i:tempDict) {
      for(String j:wordDict) {

      }
    }
    return false;
  }

  public static void main(String[] args) {
      Cane139 cane139 = new Cane139();
    System.out.println(cane139.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
  }
}
